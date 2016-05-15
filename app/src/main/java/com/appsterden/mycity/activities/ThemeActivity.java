package com.appsterden.mycity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.appsterden.mycity.R;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView citizenService;
    TextView wasteManagement;
    TextView transport;
    TextView helthcare;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        citizenService = (TextView) findViewById(R.id.citizen);
        wasteManagement = (TextView) findViewById(R.id.waste);
        transport = (TextView) findViewById(R.id.transport);
        helthcare = (TextView) findViewById(R.id.health);
        citizenService.setOnClickListener(this);
        wasteManagement.setOnClickListener(this);
        transport.setOnClickListener(this);
        helthcare.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(ThemeActivity.this, CitizenServiceActivity.class);
        switch (id) {
            case R.id.citizen:
                intent = new Intent(ThemeActivity.this, CitizenServiceActivity.class);
                break;
            case R.id.waste:
                intent = new Intent(ThemeActivity.this, WasteManagementActivity.class);
                break;
            case R.id.transport:
                intent = new Intent(ThemeActivity.this, TransportActivity.class);
                break;
            case R.id.health:
                intent = new Intent(ThemeActivity.this, HealthcareActivity.class);
                break;
            default:
        }
        startActivity(intent);
    }
}
