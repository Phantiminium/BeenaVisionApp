package com.example.joseph.beenavisionapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Page3 extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

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
                startActivity(new Intent(Page3.this, MainAbout.class));
                break;
            case R.id.product_id:
                //Toast.makeText(getApplicationContext(), "Setting icon is selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page3.this, Page2.class));
                break;
            case R.id.contact_id:
                //startActivity(new Intent(Page3.this, Page3.class));
                break;
            case R.id.login_id:
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page3.this, Logo.class).putExtra("key", "no"));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}



