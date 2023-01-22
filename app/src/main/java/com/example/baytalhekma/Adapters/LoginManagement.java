package com.example.baytalhekma.Adapters;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.baytalhekma.Models.User;

public class LoginManagement {

    SharedPreferences pref ;
    SharedPreferences.Editor edit;

    private String prefName = "name",prefKey = "key";

    public LoginManagement(Context c) {
        pref = c.getSharedPreferences(prefName,Context.MODE_PRIVATE);
        edit = pref.edit();

    }

    public void keepSession(User user)
    {
        edit.putInt(prefKey,user.getId()).commit();
    }

    public int getSession(){return pref.getInt(prefKey,-1);}

    public void removeSession(){edit.putInt(prefKey,-1).commit();}

}

