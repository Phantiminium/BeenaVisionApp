package com.example.joseph.beenavisionapp;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.joseph.beenavisionapp.R.id.submitBtn;

public class Logo extends AppCompatActivity {

    EditText usernameTxt;
    EditText passwordTxt;
    String test;


    private boolean isNetworkConnected() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE); // 1
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo(); // 2
        return networkInfo != null && networkInfo.isConnected(); // 3
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getIntent().getStringExtra("key").equals("0")) {
            Toast.makeText(getApplicationContext(), "Username or password is incorrect", Toast.LENGTH_LONG).show();
        }
        else if (getIntent().getStringExtra("key").equals("3")) {
            Toast.makeText(getApplicationContext(), "Unable to retrieve user data", Toast.LENGTH_LONG).show();
        }

        usernameTxt = (EditText) (findViewById(R.id.usernameTxt));
        passwordTxt = (EditText) (findViewById(R.id.passwordTxt));

        Button submitBtn = (Button) (findViewById(R.id.submitBtn));
        submitBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick (View view) {
                String u = usernameTxt.getText().toString();
                String p = passwordTxt.getText().toString();
                String[] login = {u, p};

                Intent home = new Intent(Logo.this,
                        MainActivity2.class).putExtra("key", login);
                //Intent home = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(home);
            }
        });

        // Get the view from activity_main.xml
        ////Intent myIntent = new Intent(MainActivity.this, HomePage.class);
        ////myIntent.putExtra("key", value); //Optional parameters
        ////MainActivity.this.startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_id:
                //Toast.makeText(getApplicationContext(), "Info icon is selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Logo.this, MainAbout.class));
                break;
            case R.id.product_id:
                //Toast.makeText(getApplicationContext(), "Setting icon is selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Logo.this, Page2.class));
                break;
            case R.id.contact_id:
                startActivity(new Intent(Logo.this, Page3.class));
                break;
            case R.id.login_id:
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }



}