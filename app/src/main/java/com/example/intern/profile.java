package com.example.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    TextView name,password;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    String name1,password1;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intialize();

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        name1=sharedPreferences.getString("email",null);
        password1=sharedPreferences.getString("password",null);

        name.setText(name1);
        password.setText(password1);
        
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendtodashboard();
            }
        });

    }

    private void sendtodashboard() {

        Intent dasIntent=new Intent(profile.this,dashboard.class);
        startActivity(dasIntent);
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);


    }

    private void Intialize() {


        name=(TextView)findViewById(R.id.name);
        password=(TextView)findViewById(R.id.password);
        back=(Button)findViewById(R.id.back);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);


    }
}