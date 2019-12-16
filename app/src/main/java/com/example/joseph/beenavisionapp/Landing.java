package com.example.joseph.beenavisionapp;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;


public class Landing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_landing);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void aboutlink(View view){
        Intent startact = new Intent(this, MainAbout.class);
        startActivity(startact);

    }


    public void productslink(View view){
        Intent startact = new Intent(this, Page2.class);
        startActivity(startact);

    }

    public void contactlink(View view){
        Intent startact = new Intent(this, Page3.class);
        startActivity(startact);

    }

    public void loginlink(View view){
        Intent startact = new Intent(this, MainActivity.class);
        startActivity(startact);

    }}

