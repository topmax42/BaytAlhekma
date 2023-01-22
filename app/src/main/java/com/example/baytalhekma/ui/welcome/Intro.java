package com.example.baytalhekma.ui.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.baytalhekma.Adapters.OnBoardadapter;
import com.example.baytalhekma.Models.OnBoardItems;
import com.example.baytalhekma.R;
import com.example.baytalhekma.ui.controluser.loginsignup;

import java.util.ArrayList;
import java.util.List;

public class Intro extends AppCompatActivity {

    private OnBoardadapter adapter;
    private LinearLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        ViewPager2 viewPager = findViewById(R.id.OBviewpager);
//        Button myButton = findViewById(R.id.buttonok);
//        setitems();
//        viewPager.setAdapter(adapter);
//
//
//        indicator = findViewById(R.id.bottomlayoutindicator);
//        setIndicator();
//        setcurrentindex(0);
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                setcurrentindex(position);
//            }
//        });
//
//
//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                a(viewPager);
//            }
//        });


    }



    public void a(ViewPager2 v) {
        int p = v.getCurrentItem();
        if (p <= v.getChildCount()) {
            v.setCurrentItem(p + 1, true);

        } else {
            Intent i = new Intent(this, loginsignup.class);
            startActivity(i);
        }


    }


    private void setitems() {
        List<OnBoardItems> elitemss = new ArrayList<>();
        OnBoardItems i1 = new OnBoardItems();
        i1.setImage(R.drawable.mask_group_40);
        i1.setText1(getResources().getString(R.string.lorem));
        i1.setText2(getResources().getString(R.string.loremipsum));
        OnBoardItems i2 = new OnBoardItems();
        i2.setImage(R.drawable.mask_group_41);
        i2.setText1(getResources().getString(R.string.lorem));
        i2.setText2(getResources().getString(R.string.loremipsum));
        OnBoardItems i3 = new OnBoardItems();
        i3.setImage(R.drawable.mask_group_42);
        i3.setText1(getResources().getString(R.string.lorem));
        i3.setText2(getResources().getString(R.string.loremipsum));


        elitemss.add(i1);
        elitemss.add(i2);
        elitemss.add(i3);

        adapter = new OnBoardadapter(elitemss);

    }

    private void setIndicator() {
        ImageView[] indicators = new ImageView[adapter.getItemCount()];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 0, 10, 0);
        for (int c = 0; c < indicators.length; c++) {
            indicators[c] = new ImageView(getApplicationContext());
            indicators[c].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.dotinactive));
            indicators[c].setLayoutParams(params);
            indicator.addView(indicators[c]);
        }
    }

    private void setcurrentindex(int index) {
        int ic = indicator.getChildCount();
        for (int c = 0; c < ic; c++) {
            ImageView imageView = (ImageView) indicator.getChildAt(c);
            if (c == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.dotactive)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.dotinactive)
                );
            }
        }
    }

}