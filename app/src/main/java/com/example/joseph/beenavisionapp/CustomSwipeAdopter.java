package com.example.joseph.beenavisionapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.joseph.beenavisionapp.R.id.textView30;
import static com.example.joseph.beenavisionapp.R.layout.activity_page2;
import static com.example.joseph.beenavisionapp.R.layout.spinner_item;

/**
 * Created by Mo on 8/3/2017.
 */

class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources;
    //= {R.drawable.brake, R.drawable.partner, R.drawable.address, R.drawable.back, R.drawable.back2, R.drawable.background1};
    private Context ctx;
    private LayoutInflater layoutInflater;


    public CustomSwipeAdapter(Context ctx){
        //this.image_resources = images;
        this.ctx=ctx;
    }

    public void addImages(int[] images) {
        this.image_resources = images;
    }

    @Override
    public int getCount() {

        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView = (TextView) item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
