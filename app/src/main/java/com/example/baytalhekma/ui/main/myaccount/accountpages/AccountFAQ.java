package com.example.baytalhekma.ui.main.myaccount.accountpages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.baytalhekma.R;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class AccountFAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_faq);

        LinearLayout.LayoutParams paramsInitial = new LinearLayout.LayoutParams(-1, 120);
        paramsInitial.setMargins(0, 20, 0, 20);

        CardView expandable1 = findViewById(R.id.cardFAQ1);
        expandable1.setLayoutParams(paramsInitial);
        expandable1.setCardBackgroundColor(getResources().getColor(R.color.box_fill, getTheme()));
        TextView title1 = findViewById(R.id.faqTitle1);
        title1.setTextColor(getResources().getColor(R.color.text_black,getTheme()));
        TextView body1 = findViewById(R.id.faqBody1);
        ImageView arrow1 = findViewById(R.id.arrowexpand1);

        CardView expandable2 = findViewById(R.id.cardFAQ2);
        expandable2.setLayoutParams(paramsInitial);
        expandable2.setCardBackgroundColor(getResources().getColor(R.color.box_fill, getTheme()));
        TextView title2 = findViewById(R.id.faqTitle2);
        title2.setTextColor(getResources().getColor(R.color.text_black,getTheme()));
        TextView body2 = findViewById(R.id.faqBody2);
        ImageView arrow2 = findViewById(R.id.arrowexpand2);

        CardView expandable3 = findViewById(R.id.cardFAQ3);
        TextView title3 = findViewById(R.id.faqTitle3);
        expandable3.setCardBackgroundColor(getResources().getColor(R.color.box_fill, getTheme()));
        title3.setTextColor(getResources().getColor(R.color.text_black,getTheme()));
        TextView body3 = findViewById(R.id.faqBody3);
        expandable3.setLayoutParams(paramsInitial);
        ImageView arrow3 = findViewById(R.id.arrowexpand3);






        expandable1.setOnClickListener(new View.OnClickListener() {
            int clicked = 0;
            @Override
            public void onClick(View v) {

                switch (clicked) {
                    case 0:{

                    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, ViewGroup.LayoutParams
                            .WRAP_CONTENT);
                    p.setMargins(0, 20, 0, 20);

                    expandable1.setLayoutParams(p);
                    expandable1.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary, getTheme()));
                    expandable1.setCardElevation(5);
                    expandable1.setPadding(18, 10, 18, 10);
                    arrow1.setImageResource(R.drawable.chevron_up_collapse);
                    arrow1.setColorFilter(getResources().getColor(R.color.white, getTheme()));
                    title1.setTextColor(getResources().getColor(R.color.white,getTheme()));
                    body1.setTextColor(getResources().getColor(R.color.white,getTheme()));
                    clicked = 1;
                    break;

                }
                    case 1:{

                        expandable1.setCardBackgroundColor(getResources().getColor(R.color.box_fill, getTheme()));
                        expandable1.setCardElevation(5);
                        expandable1.setPadding(18,10,18,10);
                        arrow1.setImageResource(R.drawable.chevron_bottom_expand);
                        arrow1.setColorFilter(getResources().getColor(R.color.text_black, getTheme()));
                        title1.setTextColor(getResources().getColor(R.color.text_black,getTheme()));
                        body1.setTextColor(getResources().getColor(R.color.colorAccent,getTheme()));
                        expandable1.setLayoutParams(paramsInitial);
                        clicked = 0;
                        break;
                    }
                }



            }
        });


        expandable2.setOnClickListener(new View.OnClickListener() {
            int clicked = 0;
            @Override
            public void onClick(View v) {

                switch (clicked) {
                    case 0:{

                        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, ViewGroup.LayoutParams
                                .WRAP_CONTENT);
                        p.setMargins(0, 20, 0, 20);

                        expandable2.setLayoutParams(p);
                        expandable2.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary, getTheme()));
                        expandable2.setCardElevation(5);
                        expandable2.setPadding(18, 10, 18, 10);
                        arrow2.setImageResource(R.drawable.chevron_up_collapse);
                        arrow2.setColorFilter(getResources().getColor(R.color.white, getTheme()));
                        title2.setTextColor(getResources().getColor(R.color.white,getTheme()));
                        body2.setTextColor(getResources().getColor(R.color.white,getTheme()));
                        title2.setTextColor(getResources().getColor(R.color.white,getTheme()));
                        body2.setTextColor(getResources().getColor(R.color.white,getTheme()));
                        clicked = 1;
                        break;

                    }
                    case 1:{

                        expandable2.setCardBackgroundColor(getResources().getColor(R.color.box_fill, getTheme()));
                        expandable2.setCardElevation(5);
                        expandable2.setPadding(18,10,18,10);
                        arrow2.setImageResource(R.drawable.chevron_bottom_expand);
                        arrow2.setColorFilter(getResources().getColor(R.color.black, getTheme()));
                        expandable2.setLayoutParams(paramsInitial);
                        title2.setTextColor(getResources().getColor(R.color.text_black,getTheme()));
                        body2.setTextColor(getResources().getColor(R.color.colorAccent,getTheme()));
                        clicked = 0;
                        break;
                    }
                }



            }
        });

        expandable3.setOnClickListener(new View.OnClickListener() {
            int clicked = 0;
            @Override
            public void onClick(View v) {

                switch (clicked) {
                    case 0:{

                        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, ViewGroup.LayoutParams
                                .WRAP_CONTENT);
                        p.setMargins(0, 20, 0, 20);

                        expandable3.setLayoutParams(p);
                        expandable3.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary, getTheme()));
                        expandable3.setCardElevation(5);
                        expandable3.setPadding(18, 10, 18, 10);
                        arrow3.setImageResource(R.drawable.chevron_up_collapse);
                        arrow3.setColorFilter(getResources().getColor(R.color.white, getTheme()));
                        title3.setTextColor(getResources().getColor(R.color.white,getTheme()));
                        body3.setTextColor(getResources().getColor(R.color.white,getTheme()));
                        clicked = 1;
                        break;

                    }
                    case 1:{

                        expandable3.setCardBackgroundColor(getResources().getColor(R.color.box_fill, getTheme()));
                        expandable3.setCardElevation(5);
                        expandable3.setPadding(18,10,18,10);
                        arrow3.setImageResource(R.drawable.chevron_bottom_expand);
                        arrow3.setColorFilter(getResources().getColor(R.color.black, getTheme()));
                        expandable3.setLayoutParams(paramsInitial);
                        title3.setTextColor(getResources().getColor(R.color.text_black,getTheme()));
                        body3.setTextColor(getResources().getColor(R.color.colorAccent,getTheme()));
                        clicked = 0;
                        break;
                    }
                }



            }
        });

        ImageButton back = findViewById(R.id.backAccountfaq);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



    }
}