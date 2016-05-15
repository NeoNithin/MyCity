package com.appsterden.mycity.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.appsterden.mycity.R;

public class HealthcareActivity extends AppCompatActivity {
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare);
        description = (TextView) findViewById(R.id.health_description);
        description.setText(Html.fromHtml("<h1>Healthcare screen</h1>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>With chat bots (with machine learning) build a virtual doctor which interacts with people and collects data(symptoms), since many would be uncomfortable/cannot afford/ would not want to pay a visit to&nbsp;doctor to share their health condition. Where users can share their problems/issues with our intelligent bots.</li>\n" +
                "\t<li style=\"line-height: 20.8px;\">The data is sent to server(With out users personel info) this helps suggesting user the quick solution.</li>\n" +
                "\t<li><span style=\"line-height: 20.8px;\">Data helps medical officers&nbsp;to analyse the medical situation of the city and make plans accordingly.</span>&nbsp;</li>\n" +
                "</ul>\n"));
    }
}
