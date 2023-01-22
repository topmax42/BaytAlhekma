package com.example.baytalhekma.ui.controluser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.baytalhekma.Adapters.LoginManagement;
import com.example.baytalhekma.Models.RegisterModel;
import com.example.baytalhekma.Models.User;
import com.example.baytalhekma.R;
import com.example.baytalhekma.api.RetrofitClientS;
import com.example.baytalhekma.databinding.FragmentLoginnBinding;

import com.example.baytalhekma.ui.main.MainActivity;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;


public class LoginnFragment extends Fragment {

    FragmentLoginnBinding binding;
    NavController navCon;
    SharedPreferences userPref;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginnBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navCon = Navigation.findNavController(view);

        initial();
        login();
        buttonsPressed();
        textValidation();
    }

    private void initial() {
        //sharedprefs
        userPref = getActivity().getSharedPreferences("userprefs", Context.MODE_PRIVATE);
        editor = userPref.edit();
    }
    private void textValidation() {
        binding.editTextEmailLoginn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!binding.loginnNameValidation.getText().toString().contains("@"))
                {
                    binding.loginnNameValidation.setText("ادخل بريد اليكتروني صحيح");
                }
                else
                {
                    binding.loginnNameValidation.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.editTextPasswordLoginn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
                Matcher m = p.matcher(binding.editTextPasswordLoginn.getText().toString());


                if (binding.editTextPasswordLoginn.getText().toString() != null
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
        binding.gotoRegistering.setOnClickListener(view -> {
            //Intent i = new Intent(getActivity(),RegisterActivity.class);
            //startActivity(i);
            //finish();
            navCon.navigate(R.id.action_loginnFragment_to_registerFragment);
        });
        binding.backLogin.setOnClickListener(view -> navCon.popBackStack());

        binding.forgotPW.setOnClickListener(view -> {
            //Intent i = new Intent(LoginActivity.this,ForgotPassword.class);
            //startActivity(i);
        });
    }
    private void login() {
        binding.loginButton.setOnClickListener(view -> {
            //if (API login valid)
            //Intent i = new Intent(LoginActivity.this, MainActivity.class);
            //startActivity(i);

            String username = binding.editTextEmailLoginn.getText().toString();
            String password = binding.editTextPasswordLoginn.getText().toString();

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

                            Toast.makeText(getActivity(), "login success", Toast.LENGTH_SHORT).show();
                            LoginManagement lm = new LoginManagement(getActivity());
//                            Toast.makeText(getActivity(), response.body().getData().getName()
//                                    , Toast.LENGTH_SHORT).show();

//                            RegisterModel r = response.body();
//                            User u = new User(r.getData().getName(),r.getData().getEmail(),
//                                    r.getData().getMobile(),r.getData().getId());
//
//                            User.setInstace(new User(r.getData().getName(),r.getData().getEmail(),
//                                    r.getData().getMobile(),r.getData().getId()));
//                            Toast.makeText(getActivity(), User.getInstance().getMobile()
//                                    , Toast.LENGTH_SHORT).show();
//
//
//
//                            Toast.makeText(LoginActivity.this,User.getInstance().getName(),Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getActivity(), MainActivity.class);
                            //i.putExtra("obj", User.getInstance());
                            //lm.keepSession(User.getInstance());
                            //editor.putString("user",new Gson().toJson(User.getInstance())).commit();
                            startActivity(i);

                            getActivity().finish();
                        }
                        else if (response.code() == 500 || response.code() == 404) {

                            Toast.makeText(getActivity(),"server error",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"incorrect info",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {

                        Log.e("Err",new Gson().toJson(t.getMessage()));
                        Toast.makeText(getActivity(),"internet issue",Toast.LENGTH_SHORT).show();

                    }
                });
            }
            else
            {Toast.makeText(getActivity(),"incorrect credentials",Toast.LENGTH_SHORT).show();}
        });
    }
}