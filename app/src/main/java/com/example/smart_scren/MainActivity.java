package com.example.smart_scren;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout layout;
    SliderAdapter sliderAdapter;
    TextView[] dotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.pager);
        layout=findViewById(R.id.linear);
        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotes(0);
        viewPager.addOnPageChangeListener(listener);

    }
    public void addDotes(int position){
        dotes=new TextView[3];
        layout.removeAllViews();
        for(int i=0;i<dotes.length;i++) {
            dotes[i]=new TextView(this);
            dotes[i].setText(Html.fromHtml("&#8226;"));
            dotes[i].setTextSize(35);
            dotes[i].setTextColor(getResources().getColor(R.color.colorSecondary));
            layout.addView(dotes[i]);
        }
        if (dotes.length>0) {
            dotes[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
    ViewPager.OnPageChangeListener listener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotes(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}