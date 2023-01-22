package com.example.baytalhekma.ui.controluser;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baytalhekma.R;
import com.example.baytalhekma.databinding.FragmentLoginorRegisterBinding;


public class LoginorRegister extends Fragment {

    FragmentLoginorRegisterBinding binding;
    NavController navCon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginorRegisterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navCon = Navigation.findNavController(view);
        buttonsListener();
    }

    private void buttonsListener() {
        binding.buttonLoginlor.setOnClickListener(view -> {
            //Intent i = new Intent(loginsignup.this,LoginActivity.class);
            //startActivity(i);
            navCon.navigate(R.id.action_loginorRegister_to_loginnFragment);

        });
        binding.buttonRegisterlor.setOnClickListener(view -> {
            //Intent i = new Intent(getActivity(),RegisterActivity.class);
            //startActivity(i);
            navCon.navigate(R.id.action_loginorRegister_to_registerFragment);
        });
    }
}