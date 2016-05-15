package com.appsterden.mycity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsterden.mycity.R;
import com.appsterden.mycity.adapter.CrimeTrafficAdapter;
import com.appsterden.mycity.model.CrimeTrafficReport;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link CrimeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrimeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<CrimeTrafficReport> crimeTrafficReportList = new ArrayList<CrimeTrafficReport>();
    private CrimeTrafficAdapter crimeReportAdapter;

    public static CrimeListFragment newInstance() {
        CrimeListFragment fragment = new CrimeListFragment();
        return fragment;
    }

    public CrimeListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_crime_traffic, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.crimeTrafficInfoRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("CrimeReport");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> crimeReports, ParseException e) {
                crimeTrafficReportList.clear();
                if (e == null) {
                    for (ParseObject crimeReport : crimeReports) {
                        CrimeTrafficReport tempCrimeTrafficReport = new CrimeTrafficReport();
                        tempCrimeTrafficReport.setDate((String) crimeReport.get("date"));
                        tempCrimeTrafficReport.setDescription((String) crimeReport.get("description"));
                        tempCrimeTrafficReport.setIncedent((String) crimeReport.get("incedent"));
                        tempCrimeTrafficReport.setLat((Double) crimeReport.get("lat"));
                        tempCrimeTrafficReport.setLng((Double) crimeReport.get("lng"));
                        tempCrimeTrafficReport.setPlace((String) crimeReport.get("loc"));
                        tempCrimeTrafficReport.setTime((String) crimeReport.get("time"));
                        crimeTrafficReportList.add(tempCrimeTrafficReport);
                    }
                    crimeReportAdapter = new CrimeTrafficAdapter(getActivity(), crimeTrafficReportList);
                    mRecyclerView.setAdapter(crimeReportAdapter);
                } else {
                    // handle Parse Exception here
                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
