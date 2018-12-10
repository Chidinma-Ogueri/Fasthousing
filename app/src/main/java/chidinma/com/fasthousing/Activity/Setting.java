package chidinma.com.fasthousing.Activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import chidinma.com.fasthousing.R;

public class Setting extends AppCompatActivity {
    private TextView tvChangeEmail,tvRate, tvAbout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        tvChangeEmail = findViewById(R.id.tvEmail);
        tvRate = findViewById(R.id.tvRate);
        tvAbout = findViewById(R.id.tvAbout);

        tvChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Setting.this, EmailActivity.class));
            }
        });



        tvRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                //link to google
                //TODO get the link of app on the google playstore
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=santase.radefffactory")));
            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=santase.radefffactory")));
            }
            }
        });

        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //link to website
                startActivity(new Intent(Setting.this, AboutUs.class));
            }
        });
    }
}
