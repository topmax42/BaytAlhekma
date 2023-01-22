package com.example.baytalhekma.ui.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.baytalhekma.Adapters.LoginManagement;
import com.example.baytalhekma.Models.User;
import com.example.baytalhekma.R;
import com.example.baytalhekma.ui.controluser.LoginActivity;
import com.example.baytalhekma.ui.controluser.loginsignup;

import com.google.gson.Gson;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                LoginManagement lm = new LoginManagement(SplashActivity.this);
                int id = lm.getSession();
                String a = String.valueOf(id);
                //Toast.makeText(SplashActivity.this,a, Toast.LENGTH_SHORT).show();
                SharedPreferences userPref = getSharedPreferences("userprefs", Context.MODE_PRIVATE);
                User u = new Gson().fromJson(userPref.getString("user",""),User.class);
                //Toast.makeText(SplashActivity.this,u.getName(), Toast.LENGTH_SHORT).show();



                if(!(id == -1))
                {

//                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
//                    mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//                    mainIntent.putExtra("obj",u);
//                    startActivity(mainIntent);

                }
                else
                {
                    Intent mainIntent = new Intent(SplashActivity.this, Intro.class);
                    startActivity(mainIntent);
                    finish();
                }

            }
        }, 1000);
    }
}