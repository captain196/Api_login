package com.example.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import model.ReaObj;
import model.frontobj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Page extends AppCompatActivity {

    EditText email,password1;
    Button login;
    Userservice userservice;
    ProgressDialog progressDialog;
    String toke;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="result";
    private static final String KEY_NAME1="email";
    private static final String KEY_NAME2="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        Intialize();

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String username=email.getText().toString();
             String password=password1.getText().toString();

             if(validateLogin(username,password)){
                doLogin(username,password);
             }


            }
        });



    }

    private boolean validateLogin(String username, String password) {

        if(username==null || TextUtils.isEmpty(username)){
            Toast.makeText(this, "Please Enter username", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(password==null || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

    private void doLogin(String username, String password){
        Call<ReaObj> call=userservice.login(username,password);
        call.enqueue(new Callback<ReaObj>() {
            @Override
            public void onResponse(Call<ReaObj> call, Response<ReaObj> response) {

                //ReaObj r1=response.body();
                //Log.i("printttt",r1.getToken().toString());
                //toke=r1.getToken().toString();

                if(response.isSuccessful()){

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(KEY_NAME,"1");
                    editor.putString(KEY_NAME1,username);
                    editor.putString(KEY_NAME2,password);
                    editor.apply();
                    sendtoDashboard();

                }else{
                    Toast.makeText(Login_Page.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(KEY_NAME,"0");
                    editor.putString(KEY_NAME1,"hacked");
                    editor.putString(KEY_NAME2,"hacked");
                    editor.apply();
                }
            }

            @Override
            public void onFailure(Call<ReaObj> call, Throwable t) {
                Toast.makeText(Login_Page.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void sendtoDashboard() {

        Toast.makeText(Login_Page.this, "Sucess", Toast.LENGTH_SHORT).show();
        Intent dasIntent=new Intent(Login_Page.this,dashboard.class);
        dasIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(dasIntent);
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();

        toke=sharedPreferences.getString(KEY_NAME,null);
        if(toke.equals("1")){
            sendtoDashboard();
        }
    }

    private void Intialize() {

        email=(EditText)findViewById(R.id.email1);
        password1=(EditText)findViewById(R.id.password1);
        login=(Button)findViewById(R.id.login_button);
        userservice=Apiutils.getUserServices();
    }
}