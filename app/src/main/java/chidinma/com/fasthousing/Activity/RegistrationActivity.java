package chidinma.com.fasthousing.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import chidinma.com.fasthousing.R;

public class RegistrationActivity extends AppCompatActivity {
    private EditText etusername,etemail,etpassword,etconfirm_pass;
    private Button btnregister;
    private RadioButton radio1, radio2;
    private RadioGroup radioGroup;
    private String username,email,password,confirm_password;
    private String selectedPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);




        etusername = findViewById(R.id.etusername);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        etconfirm_pass = findViewById(R.id.etconfirm_pass);
        radioGroup = findViewById(R.id.radioGroup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        btnregister = findViewById(R.id.btnregister);



        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {


        username = etusername.getText().toString().trim();
        email = etemail.getText().toString().trim();
        password = etpassword.getText().toString().trim();
        confirm_password = etconfirm_pass.getText().toString().trim();


        if (TextUtils.isEmpty(username)) {
            etusername.setError("username is empty");
            return;
        }


        if (TextUtils.isEmpty(email)) {
            etemail.setError("email is empty");
            return;
        }


        if (TextUtils.isEmpty(password)) {
            etpassword.setError("password is empty");
            return;
        }

        if (TextUtils.isEmpty(confirm_password)) {
            etconfirm_pass.setError("confirm password is empty");
            return;
        }

        if(!radio1.isChecked() && !radio2.isChecked()) {
            Toast.makeText(this, "Please select an option to register as",
                    Toast.LENGTH_SHORT).show();
        }
        if(radio1.isChecked()){
            selectedPerson = radio1.getText().toString();
        }
        if(radio2.isChecked()){
            selectedPerson = radio2.getText().toString();
        }
        else {
            Toast.makeText(this, "registration successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
        }
    }
//
//    private void addListenerOnButton() {
//
//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        //this is the validation for thr radio button
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId){
//                    case R.id.radio1:
//                        selectedPerson = radio1.getText().toString();
//                        startActivity(new Intent(RegistrationActivity.this, AgentDash.class));
//                        break;
//
//                    case R.id.radio2:
//                        selectedPerson = radio2.getText().toString();
//                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
//                        break;
//                }
//            }
//
//        });
//
//    }

}

