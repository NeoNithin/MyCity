package com.appsterden.mycity.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.appsterden.mycity.R;

public class TransportActivity extends AppCompatActivity {
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        description = (TextView) findViewById(R.id.transport_description);
        description.setText(Html.fromHtml("<h1>Transport Screen</h1>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>Each phones will send data about transport status and path user travells to determine which route is used at what density.</li>\n" +
                "\t<li>Our AI machine will study the data and reports if any irregularity is detected, Using that further investigation will be made.&nbsp;</li>\n" +
                "\t<li>Our Intelligent Machine will analyse previous road accidents occurred and density of traffic mainly to&nbsp;reduce accidents / commute time and&nbsp;to have a safe and happy commuting across all kinds of transport&nbsp;like public/individual.</li>\n" +
                "</ul>\n"));
    }
}
