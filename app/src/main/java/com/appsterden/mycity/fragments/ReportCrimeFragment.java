package com.appsterden.mycity.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class ReportCrimeFragment extends Fragment implements View.OnClickListener {

    private final int REQUEST_CODE_PLACE_PICKER = 4321;

    private EditText incedentEt;
    private EditText dateEt;
    private EditText timeEt;
    private TextView locationEt;
    private EditText descriptionEt;
    private Button uploadBtn;
    private Button submitBtn;
    private ImageView locationiIv;
    private LatLng selectedPlace;
    private Boolean isNotEnoughData = false;

    public static ReportCrimeFragment newInstance() {
        ReportCrimeFragment fragment = new ReportCrimeFragment();
        return fragment;
    }

    public ReportCrimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report_crime, container, false);

        incedentEt = (EditText) view.findViewById(R.id.incidentEt);
        dateEt = (EditText) view.findViewById(R.id.dateEt);
        timeEt = (EditText) view.findViewById(R.id.timeEt);
        locationEt = (TextView) view.findViewById(R.id.locationEt);
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
                incedentEt.setError(null);
                descriptionEt.setError(null);
                dateEt.setError(null);
                timeEt.setError(null);
                isNotEnoughData = false;
                if (locationEt.getText().toString().isEmpty()) {
                    locationEt.setError("Pls Enter location");
                    isNotEnoughData = true;
                }
                if (incedentEt.getText().toString().isEmpty()) {
                    incedentEt.setError("Pls Enter incident");
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
                    ParseObject crimeReportObject = new ParseObject("CrimeReport");
                    crimeReportObject.put("incedent", incedentEt.getText().toString());
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
                            incedentEt.setText("");
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
