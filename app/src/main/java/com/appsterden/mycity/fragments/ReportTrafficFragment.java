package com.appsterden.mycity.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.appsterden.mycity.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportTrafficFragment extends Fragment implements View.OnClickListener {

    private final int REQUEST_CODE_PLACE_PICKER = 1234;

    private Spinner typeSpinner;
    private EditText dateEt;
    private EditText timeEt;
    private TextView locationEt;
    private EditText descriptionEt;
    private Button uploadBtn;
    private Button submitBtn;
    private ImageView locationiIv;
    private LatLng selectedPlace;
    private Boolean isNotEnoughData = false;

    public static ReportTrafficFragment newInstance() {
        ReportTrafficFragment fragment = new ReportTrafficFragment();
        return fragment;
    }

    public ReportTrafficFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report_traffic, container, false);

        typeSpinner = (Spinner) view.findViewById(R.id.typeSpinner);
        locationEt = (TextView) view.findViewById(R.id.locationEt);
        dateEt = (EditText) view.findViewById(R.id.dateEt);
        timeEt = (EditText) view.findViewById(R.id.timeEt);
        descriptionEt = (EditText) view.findViewById(R.id.descriptionEt);
        uploadBtn = (Button) view.findViewById(R.id.uploadBtn);
        submitBtn = (Button) view.findViewById(R.id.submitBtn);
        locationiIv = (ImageView) view.findViewById(R.id.locationiIv);
        locationiIv.setOnClickListener(this);
        dateEt.setOnClickListener(this);
        timeEt.setOnClickListener(this);
        uploadBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.locationiIv:
                try {
                    Intent locationPickerIntent = new PlacePicker.IntentBuilder().build(getActivity());
                    startActivityForResult(locationPickerIntent, REQUEST_CODE_PLACE_PICKER);
                } catch (GooglePlayServicesRepairableException eGooglePlayServicesRepairableException) {
                    Toast.makeText(getActivity(), eGooglePlayServicesRepairableException.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                } catch (GooglePlayServicesNotAvailableException eGooglePlayServicesNotAvailableException) {
                    Toast.makeText(getActivity(), eGooglePlayServicesNotAvailableException.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.dateEt:
                break;
            case R.id.timeEt:
                break;
            case R.id.uploadBtn:
                break;
            case R.id.submitBtn:
                locationEt.setError(null);
                descriptionEt.setError(null);
                dateEt.setError(null);
                timeEt.setError(null);
                isNotEnoughData = false;
                if (locationEt.getText().toString().isEmpty()) {
                    locationEt.setError("Pls Enter location");
                    isNotEnoughData = true;
                }
                if (descriptionEt.getText().toString().isEmpty()) {
                    descriptionEt.setError("Pls Enter description");
                    isNotEnoughData = true;
                }
                if (dateEt.getText().toString().isEmpty()) {
                    dateEt.setError("Pls Enter date");
                    isNotEnoughData = true;
                }
                if (timeEt.getText().toString().isEmpty()) {
                    timeEt.setError("Pls Enter time");
                    isNotEnoughData = true;
                }
                submitBtn.setClickable(false);
                if (!isNotEnoughData) {
                    ParseObject crimeReportObject = new ParseObject("TrafficReport");
                    crimeReportObject.put("incedent", typeSpinner.getSelectedItem().toString());
                    crimeReportObject.put("loc", locationEt.getText().toString());
                    crimeReportObject.put("lat", selectedPlace.latitude);
                    crimeReportObject.put("lng", selectedPlace.longitude);
                    crimeReportObject.put("date", dateEt.getText().toString());
                    crimeReportObject.put("time", timeEt.getText().toString());
                    crimeReportObject.put("description", descriptionEt.getText().toString());
                    crimeReportObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            selectedPlace = new LatLng(-1, -1);
                            dateEt.setText("");
                            timeEt.setText("");
                            locationEt.setText("");
                            descriptionEt.setText("");
                            submitBtn.setClickable(true);
                            Toast.makeText(getActivity(), "Report Submited Sucessfully", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PLACE_PICKER && resultCode == Activity.RESULT_OK) {
            Place place = PlacePicker.getPlace(data, getActivity());
            selectedPlace = place.getLatLng();
            locationEt.setText(String.format("Place: %s", place.getName()));
        }
    }
}
