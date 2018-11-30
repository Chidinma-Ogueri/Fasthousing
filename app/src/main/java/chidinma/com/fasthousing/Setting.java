package chidinma.com.fasthousing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Setting extends AppCompatActivity {
    private TextView tvRate, tvAbout;

    private String rate, about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tvRate = findViewById(R.id.tvRate);
        tvAbout = findViewById(R.id.tvAbout);

        rate = tvRate.getText().toString().trim();
        about= tvAbout.getText().toString().trim();

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
                startActivity(new Intent(Setting.this, AboutPage.class));
            }
        });
    }
}
