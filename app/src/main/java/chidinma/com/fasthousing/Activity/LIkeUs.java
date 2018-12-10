package chidinma.com.fasthousing.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import chidinma.com.fasthousing.R;

public class LIkeUs extends AppCompatActivity {
    private ImageButton imgTwitter, imgFacebook, imgGoogle;

    private String twitter, facebook, google;
    private String uriString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_us2);

        imgTwitter = findViewById(R.id.imageTwitter);
        imgFacebook = findViewById(R.id.imageFacebook);
        imgGoogle = findViewById(R.id.imageGooglePlus);

        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateTwitter();
            }
        });
        imgGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateGoogle();
            }
        });

        imgFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFacebook();
            }
        });
    }

    private void validateGoogle() {
        try{
            google = imgGoogle.getAnimation().toString().trim();
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT,uriString);
            sharingIntent.setPackage("com.google.android.apps.plus");
            startActivity(sharingIntent);
        }
        catch (Exception e) {
            Toast.makeText(LIkeUs.this, "Please install the GooglePlus App",
                    Toast.LENGTH_SHORT).show();
        }


    }

    private void validateFacebook() {
        try{
            facebook = imgFacebook.getAnimation().toString().trim();
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            //Give url in uriString
            uriString = "http://www.google.com";
            sharingIntent.putExtra(Intent.EXTRA_TEXT,uriString);
            sharingIntent.setPackage("com.facebook.katana");
            startActivity(sharingIntent);

        }catch (Exception e) {
            Toast.makeText(LIkeUs.this, "Please install the Facebook App",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void validateTwitter() {
        //this will try and catch for sending the app link on twitter enabling one to tweat
        try {
            twitter = imgTwitter.getAnimation().toString().trim();
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Best App for renting houses: ");
            //add website url for website in the bracket above
            sharingIntent.setPackage("advanced.twitter.android");
        } catch (Exception e) {
            Toast.makeText(LIkeUs.this, "Please install the Twitter App",
                    Toast.LENGTH_SHORT).show();
        }
    }



}
