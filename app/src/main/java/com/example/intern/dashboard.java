package com.example.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {


    TextView profile;
    String token;
    ImageView logout;
    SharedPreferences sharedPreferences;
    private ListView mllist;

    private static final String SHARED_PREF_NAME="mypref";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Intialize();

        MyAdapter myadapter=new MyAdapter();
        mllist.setAdapter(myadapter);




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("result","0");
                editor.putString("email","hacked");
                editor.putString("password","hacked");
                editor.apply();
                token=sharedPreferences.getString("result",null);
                sendtoLogin();
            }
        });


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendtoProfile();
            }
        });



    }

    private void sendtoProfile() {
        Intent loginIntent=new Intent(dashboard.this,profile.class);
        startActivity(loginIntent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

    }

    private void Intialize() {


        logout=(ImageView)findViewById(R.id.logout);
        profile=(TextView)findViewById(R.id.profile);
        mllist=(ListView)findViewById(R.id.list1);

    }


    @Override
    protected void onStart() {
        super.onStart();

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        token=sharedPreferences.getString("result",null);

        if (token==null || token.equals("0")){
            Intent loginIntent=new Intent(dashboard.this,Login_Page.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginIntent);
            finish();

        }


    }

    private void sendtoLogin() {

        Intent loginIntent=new Intent(dashboard.this,Login_Page.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.recycle,parent,false);

            return convertView;
        }
    }

    @Override
    public void finish() {
        super.finish();
    }


}