package com.example.baytalhekma.ui.main.myaccount.accountpages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baytalhekma.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountRate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_rate);

        ImageButton x = findViewById(R.id.xCloseRate);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        TextView word = findViewById(R.id.rateWord);

        ImageView emoji = findViewById(R.id.rateImg);

        ImageButton star1 = findViewById(R.id.star1);
        star1.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
        ImageButton star2 = findViewById(R.id.star2);
        star2.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
        ImageButton star3 = findViewById(R.id.star3);
        star3.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
        ImageButton star4 = findViewById(R.id.star4);
        star4.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
        ImageButton star5 = findViewById(R.id.star5);
        star5.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));

        ArrayList<ImageButton> imageButtons = new ArrayList<>(Arrays.asList(star1,star2,star3,star4,star5));

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star2.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                star3.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                star4.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                star5.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                word.setText("فظيع");
                emoji.setImageResource(R.drawable.rate1_sadface);
            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star2.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star3.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                star4.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                star5.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                word.setText("سيء");
                emoji.setImageResource(R.drawable.rate2_meh);
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star2.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star3.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star4.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                star5.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                word.setText("حسنًا");
                emoji.setImageResource(R.drawable.rate3_ok);
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star2.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star3.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star4.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star5.setColorFilter(getResources().getColor(R.color.colorAccent,getTheme()));
                word.setText("جيد");
                emoji.setImageResource(R.drawable.rate4_kdaa);
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star2.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star3.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star4.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                star5.setColorFilter(getResources().getColor(R.color.colorPrimary,getTheme()));
                word.setText("ممتاز");
                emoji.setImageResource(R.drawable.rate5_gamed);
            }
        });

    }


}