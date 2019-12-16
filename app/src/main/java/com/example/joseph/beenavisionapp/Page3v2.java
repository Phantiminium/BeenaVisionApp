package com.example.joseph.beenavisionapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Joseph on 6/27/2017.
 */

public class Page3v2 extends AppCompatActivity implements Serializable{
    TextView t;
    TrainInfo trainInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        trainInfo = (TrainInfo) getIntent().getSerializableExtra("trains");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_page_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.product2_id:
                //Toast.makeText(getApplicationContext(), "Setting icon is selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page3v2.this, Page2v2.class).putExtra("trains", trainInfo));
                break;
            case R.id.contact2_id:
                //startActivity(new Intent(Page3.this, Page3.class));
                //startActivity(new Intent(Page2v2.this, Page3v2.class).putExtra("trains", trainInfo));
                break;
            case R.id.home_id:
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page3v2.this, Home.class).putExtra("trains", trainInfo));
                break;
            case R.id.logout_id:
                startActivity(new Intent(Page3v2.this, Logo.class).putExtra("key", "no"));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
