package chidinma.com.fasthousing.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import chidinma.com.fasthousing.R;

public class EmailActivity extends AppCompatActivity {
    private EditText etemail;
    private Button btnforgotten_email,btncreate,btnnext;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etemail = findViewById(R.id.etemail);
        btnforgotten_email = findViewById(R.id.btnforgotten);
        btncreate = findViewById(R.id.btncreate);
        btnnext = findViewById(R.id.btn_next);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {
        email = etemail.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            etemail.setError("email is empty");
        }
        else {
            startActivity(new Intent(EmailActivity.this,HomePage.class));
        }

    }
}

