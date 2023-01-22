package com.example.baytalhekma.ui.controluser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baytalhekma.Adapters.LoginManagement;
import com.example.baytalhekma.BuildConfig;
import com.example.baytalhekma.Models.RegisterModel;
import com.example.baytalhekma.Models.User;
import com.example.baytalhekma.api.RetrofitClientS;
import com.example.baytalhekma.api.Userclient;
import com.example.baytalhekma.databinding.ActivityLoginBinding;

import com.example.baytalhekma.R;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences userPref;
    SharedPreferences.Editor editor;
    ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initial();
        login();
        buttonsPressed();
        textValidation();
    }

    private void initial() {
        //sharedprefs
        userPref = getSharedPreferences("userprefs", Context.MODE_PRIVATE);
        editor = userPref.edit();
    }
    private void textValidation() {
        binding.editTextEmailLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!binding.loginNameValidation.getText().toString().contains("@"))
                {
                    binding.loginNameValidation.setText("ادخل بريد اليكتروني صحيح");
                }
                else
                {
                    binding.loginNameValidation.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.editTextPasswordLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
                Matcher m = p.matcher(binding.editTextPasswordLogin.getText().toString());


                if (binding.editTextPasswordLogin.getText().toString() != null
                && !(m.matches())) {


                    binding.loginPassValidation.setText("ادخل كلمة مرور صحيحة");

                }
                else
                {
                    binding.loginPassValidation.setText("");
                }



            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

    }
    private void buttonsPressed() {
        binding.gotoRegister.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
            finish();
        });
        binding.backlogin.setOnClickListener(view -> onBackPressed());

        binding.forgotpw.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this,ForgotPassword.class);
            startActivity(i);
        });
    }
    private void login() {
        binding.loginbutton.setOnClickListener(view -> {
            //if (API login valid)
            //Intent i = new Intent(LoginActivity.this, MainActivity.class);
            //startActivity(i);

            String username = binding.editTextEmailLogin.getText().toString();
            String password = binding.editTextPasswordLogin.getText().toString();

            if (username.contains("@") && password.length() > 0)
            {
//                Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(i);

                Call<RegisterModel> call = RetrofitClientS.getInstance().getMyApi().login(username,password);
                call.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, retrofit2.Response<RegisterModel> response) {



                        Log.e("WWS",new Gson().toJson(response.body()));

                        if(response.isSuccessful() ) {

                            Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
                            LoginManagement lm = new LoginManagement(LoginActivity.this);
                            Toast.makeText(LoginActivity.this, response.body().getData().getName()
                                    , Toast.LENGTH_SHORT).show();



                            RegisterModel r = response.body();
//                            User u = new User(r.getData().getName(),r.getData().getEmail(),
//                                    r.getData().getMobile(),r.getData().getId());
//
                            User.setInstace(new User(r.getData().getName(),r.getData().getEmail(),
                                    r.getData().getMobile(),r.getData().getId()));
                            Toast.makeText(LoginActivity.this, User.getInstance().getMobile()
                                    , Toast.LENGTH_SHORT).show();
//
//
//
//                            Toast.makeText(LoginActivity.this,User.getInstance().getName(),Toast.LENGTH_SHORT).show();
//                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                            i.putExtra("obj", User.getInstance());
//                            lm.keepSession(User.getInstance());
//                            editor.putString("user",new Gson().toJson(User.getInstance())).commit();
//                            startActivity(i);
                        }
                        else if (response.code() == 500 || response.code() == 404) {

                            Toast.makeText(LoginActivity.this,"server error",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"incorrect info",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {

                        Log.e("Err",new Gson().toJson(t.getMessage()));
                        Toast.makeText(LoginActivity.this,"internet issue",Toast.LENGTH_SHORT).show();

                    }
                });
            }
            else
            {Toast.makeText(LoginActivity.this,"incorrect credentials",Toast.LENGTH_SHORT).show();}
        });
    }
}