package chidinma.com.fasthousing.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import chidinma.com.fasthousing.R;

public class ForgottenActivity extends AppCompatActivity {
    private EditText etnew_pass, etconfirm;
    private Button btnlogin;
    private String newpass, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten);

        etnew_pass = findViewById(R.id.etnew_pass);
        etconfirm = findViewById(R.id.etconfirm_pass);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {

        if (TextUtils.isEmpty(newpass)) {
            etnew_pass.setError("new password is empty");
        }

        if (TextUtils.isEmpty(confirm)) {
            etconfirm.setError("confirm password is empty");
        }
        else
        {
            Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ForgottenActivity.this,RegistrationActivity.class));
        }
    }
}
