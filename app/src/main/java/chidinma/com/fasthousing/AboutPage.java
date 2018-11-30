package chidinma.com.fasthousing;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class AboutPage extends AppCompatActivity {
    private TextView tvAbout;
    private String about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        tvAbout = findViewById(R.id.tvAbout);

        about = tvAbout.getText().toString().trim();


//
//        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
//        View view = layoutInflater.inflate(R.layout.activity_about_page, null);
//        // AlertDialog used for pop-Ups
//        AlertDialog.Builder builder = new AlertDialog.Builder(AboutPage.this);
//        builder.setView(view);
    }
}
