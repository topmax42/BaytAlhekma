package com.example.baytalhekma.ui.main.myaccount;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.baytalhekma.Adapters.LoginManagement;
import com.example.baytalhekma.Models.User;
import com.example.baytalhekma.R;
import com.example.baytalhekma.ui.controluser.LoginActivity;
import com.example.baytalhekma.ui.controluser.RegisterActivity;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountBenefits;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountFAQ;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountHelp;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountMembership;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountPrivacy;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountRate;
import com.example.baytalhekma.ui.main.myaccount.accountpages.AccountSettings;
import com.google.gson.Gson;


public class MyAccount extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle b = getArguments();
        SharedPreferences userPref = getActivity().getSharedPreferences("userprefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userPref.edit();
//        User u = (User) b.getSerializable("a");

        /*if(!b.isEmpty())
        {
            u = (User) b.getSerializable("a");
        }
        else
        {
            if(!userPref.getString("user","").isEmpty())
            u = new Gson().fromJson(userPref.getString("user",""),User.class);
        }*/

        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        Button accountSettings = view.findViewById(R.id.accountSettings);
        Button accountMembership = view.findViewById(R.id.accountMembership);
        Button accountFAQ = view.findViewById(R.id.accountFAQ);
        Button accountHelp = view.findViewById(R.id.accountHelp);
        Button accountPrivacy = view.findViewById(R.id.accountPrivacyPolicy);
        Button accountRate = view.findViewById(R.id.accountAppRate);
        Button accountBenefits = view.findViewById(R.id.accountMemberBenefits);
        Button logout = view.findViewById(R.id.buttonLogout);

        TextView mainName = view.findViewById(R.id.accountNameMain);
//        mainName.setText(u.getName());

        accountSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountSettings.class);
                startActivity(i);

            }
        });

        accountMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountMembership.class);
                startActivity(i);

            }
        });

        accountFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountFAQ.class);
                startActivity(i);

            }
        });

        accountHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountHelp.class);
                startActivity(i);

            }
        });

        accountPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountPrivacy.class);
                startActivity(i);

            }
        });

        accountRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountRate.class);
                startActivity(i);

            }
        });

        accountBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AccountBenefits.class);
                startActivity(i);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManagement lm = new LoginManagement(getActivity());
                lm.removeSession();
                Intent i = new Intent(getActivity(),LoginActivity.class);
                getActivity().finish();

            }
        });


        return view;

    }

    @Override
    public void setInitialSavedState(@Nullable SavedState state) {
        super.setInitialSavedState(null);
    }
}