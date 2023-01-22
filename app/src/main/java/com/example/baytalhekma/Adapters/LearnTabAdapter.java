package com.example.baytalhekma.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class LearnTabAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> fragmentList = new ArrayList<>();

    public LearnTabAdapter(@NonNull FragmentManager fragmentActivity , Lifecycle lifecycle) {
        super(fragmentActivity,lifecycle);
    }
    public void addFragment(Fragment f){
        fragmentList.add(f);
    }

    @NonNull @Override public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }
    @Override public int getItemCount() {
        return fragmentList.size();
    }
}