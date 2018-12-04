package chidinma.com.fasthousing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Setting extends AppCompatActivity {
    private TextView tvChangeEmail,tvChangePhone,tvChangePassword,tvRate, tvAbout;

    private String email, phone, password,rate, about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        tvChangeEmail = findViewById(R.id.tvEmail);
//        tvChangePhone = findViewById(R.id.tvPhone);
//        tvChangePassword = findViewById(R.id.tvPassword);
        tvRate = findViewById(R.id.tvRate);
        tvAbout = findViewById(R.id.tvAbout);



        tvRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //link to google
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
