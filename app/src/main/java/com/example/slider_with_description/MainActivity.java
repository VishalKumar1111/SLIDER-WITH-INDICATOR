package com.example.slider_with_description;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout slidedot;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.view_page);
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(this);
        viewPager.setAdapter(viewPageAdapter);
        slidedot=findViewById(R.id.linear);
        dotscount=viewPageAdapter.getCount();
        dots=new ImageView[dotscount];

        for (int i=0;i<dotscount;i++) {
        dots[i]=new ImageView(this);
        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_activedot));
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(8,0,8,0);
        slidedot.addView(dots[i],params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.dotshape));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            for (int i=0;i<dotscount;i++){
                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.dotshape));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_activedot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });


    }
}