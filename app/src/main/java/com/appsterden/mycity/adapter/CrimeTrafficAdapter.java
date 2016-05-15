package com.appsterden.mycity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsterden.mycity.R;
import com.appsterden.mycity.model.CrimeTrafficReport;

import java.util.List;

/**
 * Created by Nithin on 10/5/2015.
 */
public class CrimeTrafficAdapter extends RecyclerView.Adapter<CrimeTrafficAdapter.CrimeTrafficViewHolder> {
    private List<CrimeTrafficReport> crimeTrafficReports;
    private Context mContext;

    public CrimeTrafficAdapter(Context context, List<CrimeTrafficReport> crimeTrafficReports) {
        this.crimeTrafficReports = crimeTrafficReports;
        this.mContext = context;
    }

    @Override
    public CrimeTrafficViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_crime_info, null);
        CrimeTrafficViewHolder viewHolder = new CrimeTrafficViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CrimeTrafficViewHolder holder, int position) {
        CrimeTrafficReport crimeTrafficReport = crimeTrafficReports.get(position);
        holder.incedentTv.setText(crimeTrafficReport.getIncedent());
        holder.locationTv.setText(crimeTrafficReport.getPlace());
        holder.dateTv.setText("Date : " + crimeTrafficReport.getDate());
        holder.timeTv.setText("Time : " + crimeTrafficReport.getTime());
        holder.descriptionTv.setText("Details : " + crimeTrafficReport.getDescription());
    }

    @Override
    public int getItemCount() {
        return (null != crimeTrafficReports ? crimeTrafficReports.size() : 0);
    }

    public class CrimeTrafficViewHolder extends RecyclerView.ViewHolder {
        protected TextView incedentTv;
        protected TextView locationTv;
        protected TextView dateTv;
        protected TextView timeTv;
        protected TextView descriptionTv;

        public CrimeTrafficViewHolder(View view) {
            super(view);
            this.incedentTv = (TextView) view.findViewById(R.id.incedentTv);
            this.locationTv = (TextView) view.findViewById(R.id.locationTv);
            this.dateTv = (TextView) view.findViewById(R.id.dateTv);
            this.timeTv = (TextView) view.findViewById(R.id.timeTv);
            this.descriptionTv = (TextView) view.findViewById(R.id.descriptionTv);
        }
    }
}