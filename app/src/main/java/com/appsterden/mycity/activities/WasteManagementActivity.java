package com.appsterden.mycity.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.appsterden.mycity.R;

public class WasteManagementActivity extends AppCompatActivity {
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_management);
        description = (TextView) findViewById(R.id.waste_description);
        description.setText(Html.fromHtml("<h1><strong>Waste management screen</strong></h1>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>\n" +
                "\t<pre style=\"color: rgb(0, 0, 0); font-family: 'Courier New'; font-size: 9.6pt;\">\n" +
                "<span style=\"color:#008000;font-weight:bold;\"> This screens helps the user to identify and separate type of waste.\n" +
                "</span></pre>\n" +
                "\t</li>\n" +
                "\t<li>\n" +
                "\t<pre style=\"color: rgb(0, 0, 0); font-family: 'Courier New'; font-size: 9.6pt;\">\n" +
                "<span style=\"color: rgb(0, 128, 0); font-weight: bold;\">Informs if the waste is easily processed in home and used.If yes provides details about it.</span><span style=\"color: rgb(51, 51, 51); font-family: sans-serif, Arial, Verdana, 'Trebuchet MS'; font-size: 13px; line-height: 1.6;\">&nbsp;</span></pre>\n" +
                "\t</li>\n" +
                "\t<li>\n" +
                "\t<p style=\"color: rgb(0, 0, 0); font-family: 'Courier New'; font-size: 9.6pt;\"><span style=\"color: rgb(0, 128, 0); font-weight: bold;\">Will inform about the&nbsp;waste collecting vehical&#39;s location arrives in their area or alarms if waste collecting vehical is yet to come.</span></p>\n" +
                "\t</li>\n" +
                "\t<li>\n" +
                "\t<pre>\n" +
                " <font color=\"#008000\" face=\"Courier New\"><span style=\"font-size: 12.8px; line-height: 20.48px;\"><b>This screen contains a camera screen which helps the user to identify waste and processing waste.</b></span></font></pre>\n" +
                "\t</li>\n" +
                "\t<li><font color=\"#008000\" face=\"Courier New\"><span style=\"font-size: 12.8px; line-height: 20.48px;\"><b>Everything will be powered by AI.</b></span></font></li>\n" +
                "</ul>\n"));
    }
}
