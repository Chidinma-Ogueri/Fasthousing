package chidinma.com.fasthousing.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import chidinma.com.fasthousing.R;
import chidinma.com.fasthousing.utils.JsonParser;
import chidinma.com.fasthousing.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    KProgressHUD hud;


    private EditText etemail,etpassword;
    private Button btnlogin,btnforgotten,btnregister;
    private String email,password;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnforgotten = findViewById(R.id.btnforgotten);
        btnregister = findViewById(R.id.btnregister);

        btnforgotten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgottenActivity.class));
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {

        email = etemail.getText().toString().trim();
        password = etpassword.getText().toString().trim();

        if(utils.isNetworkAvailable(getApplicationContext())){

            if (TextUtils.isEmpty(email)){
                etemail.setError("email is empty");
                return;
            }


            if (TextUtils.isEmpty(password)){
                etpassword.setError("email is empty");
                return;
            }

            else{
                Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,HomePage.class));
            }
        }
        else
        {
            Toast.makeText(this, "On your network", Toast.LENGTH_SHORT).show();

        }
    }

    private class sendPostRequest extends AsyncTask<String, Void, JSONObject> {
        JsonParser jsonParser = new JsonParser();

        private  static final  String LOGIN_URL = "192.168.43.233:8000/api/login";
        String email = etemail.getText().toString().trim();
        String password = etpassword.getText().toString().trim();

        @Override
        protected void onPreExecute() {
            hud = KProgressHUD.create(LoginActivity.this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("please wait...")
                    .setCancellable(true)
                    .setBackgroundColor(Color.BLUE)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                    .setCornerRadius(20)
                    .show();
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            try{
                HashMap<String, String > params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);

                JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);

                if (json != null){
                    return json;
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hud.dismiss();
                            String message = "Network Error Pls Try Again Later";
                            utils.toastMessage(getApplicationContext(), message);

                        }
                    });
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(JSONObject json) {

            hud.dismiss();
            try{
                if (json != null && json.getString("status").equals(201)){
                    Log.d("jsonerror", ""+json);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }catch(NullPointerException e){
                e.printStackTrace();
                           }
            super.onPostExecute(json);
        }
    }
}
