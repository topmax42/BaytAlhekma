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

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baytalhekma.Adapters.LoginManagement;
import com.example.baytalhekma.Models.User;
import com.example.baytalhekma.R;
import com.example.baytalhekma.databinding.FragmentSplashBinding;

import com.example.baytalhekma.ui.welcome.Intro;
import com.example.baytalhekma.ui.welcome.SplashActivity;
import com.google.gson.Gson;


public class SplashFragment extends Fragment {

    FragmentSplashBinding binding;
    NavController navCon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navCon = Navigation.findNavController(view);
        new Handler().postDelayed(() -> {
            LoginManagement lm = new LoginManagement(getActivity());
            int id = lm.getSession();
            String a = String.valueOf(id);
            //Toast.makeText(SplashActivity.this,a, Toast.LENGTH_SHORT).show();
            SharedPreferences userPref = getActivity().getSharedPreferences("userprefs", Context.MODE_PRIVATE);
            User u = new Gson().fromJson(userPref.getString("user",""),User.class);
            //Toast.makeText(SplashActivity.this,u.getName(), Toast.LENGTH_SHORT).show();



            if(!(id == -1))
            {

                navCon.navigate(R.id.action_splashFragment_to_introduction);
            }
            else
            {
                navCon.navigate(R.id.action_splashFragment_to_introduction);
            }


        }, 1500);
    }
}