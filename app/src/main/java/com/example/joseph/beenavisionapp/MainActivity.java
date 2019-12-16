package com.example.joseph.beenavisionapp;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.TimeUnit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        final Intent login = new Intent(MainActivity.this, Logo.class);
        login.putExtra("key", "2");

        thread =  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        wait(500);
                    }
                }
                catch(InterruptedException ex){
                }

                startActivity(login);
            }
        };

        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized(thread){
                thread.notifyAll();
            }
        }
        return true;
    }
}
