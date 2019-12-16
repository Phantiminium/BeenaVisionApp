package com.example.joseph.beenavisionapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static android.R.string.yes;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;
import static com.example.joseph.beenavisionapp.R.id.passwordTxt;
import static com.example.joseph.beenavisionapp.R.id.submitBtn;
import static com.example.joseph.beenavisionapp.R.id.usernameTxt;

public class Home extends AppCompatActivity implements Serializable{


    /*
    public void init() {
        TableLayout ll = (TableLayout) findViewById(R.id.table_main);


        for (int i = 0; i < 2; i++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            checkBox = new CheckBox(this);
            tv = new TextView(this);
            addBtn = new ImageButton(this);
            addBtn.setImageResource(R.drawable.add);
            minusBtn = new ImageButton(this);
            minusBtn.setImageResource(R.drawable.minus);
            qty = new TextView(this);
            checkBox.setText("hello");
            qty.setText("10");
            row.addView(checkBox);
            row.addView(minusBtn);
            row.addView(qty);
            row.addView(addBtn);
            ll.addView(row, i);
        }
    }

    */

    public String getID(int ID) {
        switch (ID) {
            case 1:
                return "Coupler Cross";
            case 2:
                return "Wheel View";
            case 3:
                return "Wedge View";
            case 4:
                return "Coupler Pin";
            case 5:
                return "Brake View";
            case 6:
                return "Train View";
            case 7:
                return "Truck View";
            case 9:
                return "Tread View";
            case 13:
                return "Low Air Hose";
            default:
                return "";
        }
    }

    public String findValue(int i, int id) {
        String returnV = "-";
        int length = trainInfo.siteStatuses.get(i).SystemStatuses.size();
        for (int j = 0; j < length; j++) {
            if (id == trainInfo.siteStatuses.get(i).SystemStatuses.get(j).BVComponentID) {
                returnV = Integer.toString(trainInfo.siteStatuses.get(i).SystemStatuses.get(j).NumberOfTrain);
            }
        }
        return returnV;
    }

    public int exists(String siteName) {
        for (int i = 0; i < trainInfo.alarms.size(); i++) {
            if (trainInfo.alarms.get(i).SiteName.equals(siteName)) return i;
        }
        return -1;
    }

    public void set4(int position) {
        TableRow tr1 = new TableRow(this);
        TextView tv1 = new TextView(this);
        tv1.setTextSize(TextSize);
        tv1.setTextColor(Color.parseColor("#777777"));
        tv1.setText(trainInfo.siteStatuses.get(position).SiteName);
        tr1.addView(tv1);
        tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        int index = exists(trainInfo.siteStatuses.get(position).SiteName);
        if (index > -1) {
            for (int i = 0; i < 2; i++) {
                TableRow tr = new TableRow(this);
                TextView cv = new TextView(this);
                TextView tv = new TextView(this);
                cv.setTextSize(TextSize);
                tv.setTextSize(TextSize);
                cv.setTextColor(Color.parseColor("#DDDDDD"));
                tv.setTextColor(Color.parseColor("#DDDDDD"));
                tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                switch (i + 1) {
                    case 1:
                        cv.setText("  Component:");
                        tv.setText(getID(trainInfo.alarms.get(index).BVCompID));
                        break;
                    case 2:
                        cv.setText("  Count:");
                        tv.setText("  " + Integer.toString(trainInfo.alarms.get(index).Count));
                        cv.setTextColor(Color.BLACK);
                        tv.setTextColor(Color.BLACK);
                        break;
                /*
                case 3:
                    cv.setText("Max Priority:");
                    tv.setText("  " + Integer.toString(trainInfo.alarms.get(position).MaxPriority));
                    break;
                    */
                    default:
                        break;
                }
                tr.addView(cv);
                tr.addView(tv);

                //tr.addView(tv);
                if (i == 1) {
                    int color = trainInfo.alarms.get(index).MaxPriority;
                    if (color == 3) tr.setBackgroundColor(Color.YELLOW);
                    else if (color == 2) tr.setBackgroundColor(Color.RED);
                    else tr.setBackgroundColor(Color.GREEN);
                }
                else if (i % 2 == 0) tr.setBackgroundColor(Color.parseColor("#222222"));
                else tr.setBackgroundColor(Color.parseColor("#444444"));
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }
        else {
            TableRow tr2 = new TableRow(this);
            TextView tv2 = new TextView(this);
            tv2.setTextSize(TextSize);
            tv2.setTextColor(Color.parseColor("#777777"));
            tv2.setText("No Alarms");
            tr2.addView(tv2);
            tl.addView(tr2, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    public void set2(int position) {
        TableRow tr1 = new TableRow(this);
        TextView tv1 = new TextView(this);
        tv1.setTextSize(TextSize);
        tv1.setTextColor(Color.parseColor("#777777"));
        tv1.setText(trainInfo.siteStatuses.get(position).SiteName);
        tr1.addView(tv1);
        tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        if (trainInfo.siteStatuses.get(position).LastTrain.AlxeCount != 0) {
            for (int i = 0; i < 7; i++) {
                TableRow tr = new TableRow(this);
                TextView cv = new TextView(this);
                TextView tv = new TextView(this);
                cv.setTextSize(TextSize);
                if (i == 1) {
                    tv.setTextSize(TextSize);
                }
                else {
                    tv.setTextSize(TextSize);
                }
                cv.setTextColor(Color.parseColor("#DDDDDD"));
                tv.setTextColor(Color.parseColor("#DDDDDD"));
                tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                switch (i + 1) {
                    case 1:
                        cv.setText("  ID:");
                        tv.setText("  " + Long.toString(trainInfo.siteStatuses.get(position).LastTrain.ID));
                        break;
                    case 2:
                        cv.setText("  Pass Time:");
                        String temp = trainInfo.siteStatuses.get(position).LastTrain.TrainArrivalLocal_Display;
                        tv.setText("  " + temp);
                        break;
                    case 3:
                        cv.setText("  Direction:");
                        tv.setText("  " + trainInfo.siteStatuses.get(position).LastTrain.Direction);
                        break;
                    case 4:
                        cv.setText("  Train Length:");
                        tv.setText("  " + Float.toString(trainInfo.siteStatuses.get(position).LastTrain.TrainLength));
                        break;
                    case 5:
                        cv.setText("  Average Speed:");
                        tv.setText("  " + Float.toString(trainInfo.siteStatuses.get(position).LastTrain.AvgTrainSpeed));
                        break;
                    case 6:
                        cv.setText("  Total Locos:");
                        tv.setText("  " + Integer.toString(trainInfo.siteStatuses.get(position).LastTrain.NumberOfLocos));
                        break;
                    case 7:
                        cv.setText("  Total Vehicles:");
                        tv.setText("  " + Integer.toString(trainInfo.siteStatuses.get(position).LastTrain.NumberOfCars));
                        break;
                    default:
                        break;
                }
                tr.addView(cv);
                tr.addView(tv);

                //tr.addView(tv);
                if (i % 2 == 0) tr.setBackgroundColor(Color.parseColor("#222222"));
                else tr.setBackgroundColor(Color.parseColor("#444444"));
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }
        else {
            TableRow tr2 = new TableRow(this);
            TextView tv2 = new TextView(this);
            tv2.setTextSize(TextSize);
            tv2.setTextColor(Color.parseColor("#777777"));
            tv2.setText("Information not available");
            tr2.addView(tv2);
            tl.addView(tr2, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    public void set3(int position) {
        TableRow tr1 = new TableRow(this);
        TextView tv1 = new TextView(this);
        tv1.setTextSize(TextSize);
        tv1.setTextColor(Color.parseColor("#777777"));
        tv1.setText("  " + trainInfo.alarms.get(position).SiteName);
        tr1.addView(tv1);
        tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        for (int i = 0; i < 2; i++) {
            TableRow tr = new TableRow(this);
            TextView cv = new TextView(this);
            TextView tv = new TextView(this);
            cv.setTextSize(TextSize);
            tv.setTextSize(TextSize);
            cv.setTextColor(Color.parseColor("#DDDDDD"));
            tv.setTextColor(Color.parseColor("#DDDDDD"));
            tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            switch (i + 1) {
                case 1:
                    cv.setText("  Component:");
                    tv.setText(getID(trainInfo.alarms.get(position).BVCompID));
                    break;
                case 2:
                    cv.setText("  Count:");
                    tv.setText("  " + Integer.toString(trainInfo.alarms.get(position).Count));
                    cv.setTextColor(Color.BLACK);
                    tv.setTextColor(Color.BLACK);
                    break;
                /*
                case 3:
                    cv.setText("Max Priority:");
                    tv.setText("  " + Integer.toString(trainInfo.alarms.get(position).MaxPriority));
                    break;
                    */
                default:
                    break;
            }
            tr.addView(cv);
            tr.addView(tv);

            //tr.addView(tv);
            if (i == 1) {
                int color = trainInfo.alarms.get(position).MaxPriority;
                if (color == 3) tr.setBackgroundColor(Color.YELLOW);
                else if (color == 2) tr.setBackgroundColor(Color.RED);
                else tr.setBackgroundColor(Color.GREEN);
            }
            else if (i % 2 == 0) tr.setBackgroundColor(Color.parseColor("#222222"));
            else tr.setBackgroundColor(Color.parseColor("#444444"));
            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    public void set(int position) {
        //tl.removeAllViews();
        TableRow tr1 = new TableRow(this);
        TextView tv1 = new TextView(this);
        tv1.setTextSize(TextSize);
        tv1.setTextColor(Color.parseColor("#777777"));
        tv1.setText(trainInfo.siteStatuses.get(position).SiteName);
        tr1.addView(tv1);
        tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        for (int i = 0; i < 10; i++) {
            TableRow tr = new TableRow(this);
            TextView cv = new TextView(this);
            TextView tv = new TextView(this);
            cv.setTextSize(TextSize);
            tv.setTextSize(TextSize);
            cv.setTextColor(Color.parseColor("#DDDDDD"));
            tv.setTextColor(Color.parseColor("#DDDDDD"));
            tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            switch (i + 1) {
                case 1:
                    cv.setText("  Train Passes:");
                    tv.setText(Integer.toString(trainInfo.siteStatuses.get(position).TotalTrain));
                    break;
                case 2:
                    cv.setText("  BrakeView:");
                    tv.setText("  " + findValue(position, 5));
                    break;
                case 3:
                    cv.setText("  CouplerCross:");
                    tv.setText("  " + findValue(position, 1));
                    break;
                case 4:
                    cv.setText("  CouplerPin:");
                    tv.setText("  " + findValue(position, 4));
                    break;
                case 5:
                    cv.setText("  LowAirHose:");
                    tv.setText("  " + findValue(position, 13));
                    break;
                case 6:
                    cv.setText("  TrainView:");
                    tv.setText("  " + findValue(position, 6));
                    break;
                case 7:
                    cv.setText("  TreadView:");
                    tv.setText("  " + findValue(position, 9));
                    break;
                case 8:
                    cv.setText("  TruckView:");
                    tv.setText("  " + findValue(position, 7));
                    break;
                case 9:
                    cv.setText("  WedgeView:");
                    tv.setText("  " + findValue(position, 3));
                    break;
                case 10:
                    cv.setText("  WheelView:");
                    tv.setText("  " + findValue(position, 2));
                    break;
                default:
                    break;
            }
            tr.addView(cv);
            tr.addView(tv);

            //tr.addView(tv);
            if (i % 2 == 0) tr.setBackgroundColor(Color.parseColor("#222222"));
            else tr.setBackgroundColor(Color.parseColor("#444444"));
            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    int TextSize;
    ViewPager pager;
    TabLayout tabLayout;
    TableLayout tl;
    Spinner spinner;
    Button button;
    //Switch swap;

    List<String> items;

    TrainInfo trainInfo;

    public void createAll() {
        for (int i = 0; i < trainInfo.siteStatuses.size(); i++) {
            set(i);
            TableRow tr1 = new TableRow(this);
            TextView tv1 = new TextView(this);
            tv1.setTextSize(TextSize);
            tv1.setTextColor(Color.parseColor("#777777"));
            tv1.setText(" ");
            tr1.addView(tv1);
            tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    public void createAll2() {
        for (int i = 0; i < trainInfo.siteStatuses.size(); i++) {
            if (trainInfo.siteStatuses.get(i).LastTrain.AlxeCount != 0) {
                set2(i);
                TableRow tr1 = new TableRow(this);
                TextView tv1 = new TextView(this);
                tv1.setTextSize(TextSize);
                tv1.setTextColor(Color.parseColor("#777777"));
                tv1.setText(" ");
                tr1.addView(tv1);
                tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }
    }

    public void createAll3() {

        if(trainInfo.alarms.size() == 0) {
            TableRow tr1 = new TableRow(this);
            TextView tv1 = new TextView(this);
            tv1.setTextSize(TextSize);
            tv1.setTextColor(Color.parseColor("#777777"));
            tv1.setText("No Alarms");
            tr1.addView(tv1);
            tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
        else {
            for (int i = 0; i < trainInfo.alarms.size(); i++) {
                set3(i);
                TableRow tr1 = new TableRow(this);
                TextView tv1 = new TextView(this);
                tv1.setTextSize(TextSize);
                tv1.setTextColor(Color.parseColor("#777777"));
                tv1.setText(" ");
                tr1.addView(tv1);
                tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //val1 = (TextView) (findViewById(R.id.textb1));
        trainInfo = (TrainInfo) getIntent().getSerializableExtra("trains");
        //val1.setText(trainInfo.siteStatuses.get(3).SiteName);

        //items = new String[trainInfo.siteStatuses.size()];
        spinner = (Spinner) (findViewById(R.id.spinner));
        //text1 = (TextView) (findViewById(R.id.txt1));
        //swap = (Switch) (findViewById(R.id.switch1)) ;
        Button homeBtn = (Button) (findViewById(R.id.btn2));

        /*
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        */

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Sites"));
        tabLayout.addTab(tabLayout.newTab().setText("Last Train"));
        tabLayout.addTab(tabLayout.newTab().setText("Alarms"));

        TextSize = 20;
        items = new ArrayList<String>();


        tl = (TableLayout) findViewById(R.id.table_main);
        /*
        for (int i = 0; i < trainInfo.siteStatuses.size(); i++) {
            TableRow tr = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setText(trainInfo.siteStatuses.get(i).SiteName);
            tv.setTextSize(24);
            tv.setTextColor(Color.parseColor("#DDDDDD"));
            tr.addView(tv);
            if (i % 2 == 0) tr.setBackgroundColor(Color.parseColor("#222222"));
            else tr. setBackgroundColor(Color.parseColor("#444444"));
            tl.addView(tr, new3 TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
        */

        items.add("All");

        for (int i = 0; i < trainInfo.siteStatuses.size(); i++) {
            items.add(trainInfo.siteStatuses.get(i).SiteName);
        }



        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, items);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (tabLayout.getSelectedTabPosition() == 0) {
                    if (position > 0) {
                        tl.removeAllViews();
                        set(position - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll();
                        return;
                    }
                }
                else if (tabLayout.getSelectedTabPosition() == 1){
                    if (position > 0) {
                        tl.removeAllViews();
                        set2(position - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll2();
                        return;
                    }
                }
                else if (tabLayout.getSelectedTabPosition() == 2){
                    if (position > 0) {
                        tl.removeAllViews();
                        set4(position - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll3();
                        return;
                    }
                }
                else {
                    return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    if (spinner.getSelectedItemPosition() > 0) {
                        tl.removeAllViews();
                        set(spinner.getSelectedItemPosition() - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll();
                        return;
                    }
                }
                else if (tab.getPosition() == 1){
                    if (spinner.getSelectedItemPosition() > 0) {
                        tl.removeAllViews();
                        set2(spinner.getSelectedItemPosition()- 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll2();
                        return;
                    }
                }
                else if (tabLayout.getSelectedTabPosition() == 2){
                    if (spinner.getSelectedItemPosition() > 0) {
                        tl.removeAllViews();
                        set4(spinner.getSelectedItemPosition() - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll3();
                        return;
                    }
                }
                else {
                    tl.removeAllViews();
                    createAll3();
                    return;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                return;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                return;
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                Intent home = new Intent(Home.this,
                        MainActivity2.class).putExtra("key", trainInfo.combo);
                //Intent home = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(home);
            }
        });

        /*
        swap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    int position = spinner.getSelectedItemPosition();
                    if (position > 0) {
                        tl.removeAllViews();
                        set(position - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll();
                        return;
                    }
                }
                else {
                    int position = spinner.getSelectedItemPosition();
                    if (position > 0) {
                        tl.removeAllViews();
                        set2(position - 1);
                        return;
                    }
                    else {
                        tl.removeAllViews();
                        createAll2();
                        return;
                    }
                }
            }
        });
        */
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
                startActivity(new Intent(Home.this, Page2v2.class).putExtra("trains", trainInfo));
                break;
            case R.id.contact2_id:
                //startActivity(new Intent(Page3.this, Page3.class));
                startActivity(new Intent(Home.this, Page3v2.class).putExtra("trains", trainInfo));
                break;
            case R.id.home_id:
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(Page2.this, Logo.class).putExtra("trains", trainInfo));
                break;
            case R.id.logout_id:
                startActivity(new Intent(Home.this, Logo.class).putExtra("key", "1"));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}
