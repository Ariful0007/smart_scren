package com.example.smart_scren;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;

    }
    //arrays
    public int[] slide_images={
            R.drawable.icon1,
            R.drawable.icon_2,
            R.drawable.icon_3

    };
    //another array
    public String[] slide_headings={
            "Imahe",
            "Image2"
            ,"Image3"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View  view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView imageView=view.findViewById(R.id.image);
        TextView textView=view.findViewById(R.id.text1);
        imageView.setImageResource(slide_images[position]);
        textView.setText(slide_headings[position]);
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);

    }
}
