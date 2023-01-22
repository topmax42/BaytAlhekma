package com.example.baytalhekma.ui.controluser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.baytalhekma.R;

public class loginsignup extends AppCompatActivity {

    Button buttonLogin ;
    Button buttonRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsignup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        buttonLogin = findViewById(R.id.buttonlos);
        buttonRegister = findViewById(R.id.buttonlos2);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loginsignup.this,LoginActivity.class);
                startActivity(i);

            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loginsignup.this,RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}