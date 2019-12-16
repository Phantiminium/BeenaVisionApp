package com.example.joseph.beenavisionapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.joseph.beenavisionapp.R.id.spinner;


public class Page2v2 extends AppCompatActivity {
    TrainInfo trainInfo;
    Spinner s;
    TextView tv;
    ImageView iv;
    TextView tv2;
    Resources res;
    ViewPager vp;
    CustomSwipeAdapter csa;

    List<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        trainInfo = (TrainInfo) getIntent().getSerializableExtra("trains");
        tv = (TextView) findViewById(R.id.textView8);
        s = (Spinner) findViewById(R.id.spinner1);
        //tv = (TextView) findViewById(R.id.textView8);
        tv2 = (TextView) findViewById(R.id.textView30);
        //iv = (ImageView) findViewById(R.id.imageView11);
        vp = (ViewPager) findViewById(R.id.viewpager);

        res = getResources();

        items = new ArrayList<String>();
        items.add("  Wheel View");
        items.add("  Brake View");
        items.add("  Tread View");
        items.add("  Truck View");
        items.add("  LAH View");

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, items);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        s.setAdapter(adapter);
        csa = new CustomSwipeAdapter(this);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int i = position;
                //tv.setText(items.get(i));

                if (i == 0) {
                    tv2.setText(res.getString(R.string.wheelt));
                    //iv.setImageResource(R.drawable.wheel);
                    int[] files = {R.drawable.wheelview1, R.drawable.wheelview2, R.drawable.wheelview3, R.drawable.wheelview4, R.drawable.wheelview5, R.drawable.wheelview6, R.drawable.wheelview7};
                    csa.addImages(files);
                    vp.setAdapter(csa);
                }
                else if (i == 1) {
                    tv2.setText(res.getString(R.string.braket));
                    //iv.setImageResource(R.drawable.brake);
                    int[] files = {R.drawable.brakeview1, R.drawable.brakeview2, R.drawable.brakeview3, R.drawable.brakeview4, R.drawable.brakeview5, R.drawable.brakeview6, R.drawable.brakeview7, R.drawable.brakeview8, R.drawable.brakeview9, R.drawable.brakeview10, R.drawable.brakeview11, R.drawable.brakeview12, R.drawable.brakeview13, R.drawable.brakeview14, R.drawable.brakeview15, R.drawable.brakeview16, R.drawable.brakeview17};
                    csa.addImages(files);
                    vp.setAdapter(csa);
                }
                else if (i == 2) {
                    tv2.setText(res.getString(R.string.treadt));
                    //iv.setImageResource(R.drawable.tread);
                    int[] files = {R.drawable.tradeview1, R.drawable.tradeview2, R.drawable.tradeview3, R.drawable.tradeview4, R.drawable.tradeview5, R.drawable.tradeview6, R.drawable.tradeview7, R.drawable.tradeview8, R.drawable.tradeview9};
                    csa.addImages(files);
                    vp.setAdapter(csa);
                }
                else if (i == 3) {
                    tv2.setText(res.getString(R.string.truckt));
                    // iv.setImageResource(R.drawable.truck2);
                    int[] files = {R.drawable.truckview1, R.drawable.truckview2, R.drawable.truckview3, R.drawable.tradeview4, R.drawable.truckview5, R.drawable.truckview6, R.drawable.truckview7, R.drawable.truckview8, R.drawable.truckview9};
                    csa.addImages(files);
                    vp.setAdapter(csa);
                }
                else if (i == 4) {
                    tv2.setText(res.getString(R.string.laht));
                    //iv.setImageResource(R.drawable.lah);
                    int[] files = {R.drawable.lahview1, R.drawable.lahview2, R.drawable.lahview3, R.drawable.lahview4, R.drawable.lahview5, R.drawable.lahview6};
                    csa.addImages(files);
                    vp.setAdapter(csa);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

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
                //startActivity(new Intent(Page2v2.this, Page2v2.class).putExtra("trains", trainInfo));
                break;
            case R.id.contact2_id:
                //startActivity(new Intent(Page3.this, Page3.class));
                startActivity(new Intent(Page2v2.this, Page3v2.class).putExtra("trains", trainInfo));
                break;
            case R.id.home_id:
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page2v2.this, Home.class).putExtra("trains", trainInfo));
                break;
            case R.id.logout_id:
                startActivity(new Intent(Page2v2.this, Logo.class).putExtra("key", "no"));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
