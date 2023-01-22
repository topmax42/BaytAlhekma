package com.example.baytalhekma.ui.main.myaccount.accountpages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.baytalhekma.R;

public class AccountBenefits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_benefits);
        ImageButton back = findViewById(R.id.backAccountBen);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        Button reqs = findViewById(R.id.requirementsOfMembership);
        TextView req1 = findViewById(R.id.requirement1);
        TextView req2 = findViewById(R.id.requirement2);
        TextView req3 = findViewById(R.id.requirement3);

        Button benefits = findViewById(R.id.benefitsOfMembership);
        LinearLayout layout = findViewById(R.id.layoutBenefits);


        reqs.setOnClickListener(new View.OnClickListener() {
            int clicked=0;
            @Override
            public void onClick(View v) {
                if (clicked==0) {
                    req1.setVisibility(View.VISIBLE);
                    req2.setVisibility(View.VISIBLE);
                    req3.setVisibility(View.VISIBLE);
                    clicked=1;
                }
                else{
                    req1.setVisibility(View.GONE);
                    req2.setVisibility(View.GONE);
                    req3.setVisibility(View.GONE);
                    clicked=0;
                }
            }
        });

        benefits.setOnClickListener(new View.OnClickListener() {
            int clicked=0;
            @Override
            public void onClick(View v) {
                if (clicked==0) {
                    layout.setVisibility(View.VISIBLE);
                    clicked=1;
                }
                else{
                   layout.setVisibility(View.GONE);
                    clicked=0;
                }
            }
        });
    }
}