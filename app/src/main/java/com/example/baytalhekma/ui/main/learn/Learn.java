package com.example.baytalhekma.ui.main.learn;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baytalhekma.Adapters.LearnTabAdapter;
import com.example.baytalhekma.databinding.FragmentLearnBinding;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.Nullable;


public class Learn extends Fragment {

    ViewPager2 learnViewPager;
    FragmentLearnBinding binding;


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLearnBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        setup();
        listenerAndCallback();


        return view;
    }

    private void listenerAndCallback() {
        binding.learnTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.learnTabsViewpager.setCurrentItem(tab.getPosition(),true);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        binding.learnTabsViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.learnTabs.selectTab(binding.learnTabs.getTabAt(position));
            }
        });
    }

    private void setup() {
        binding.learnTabs.addTab(binding.learnTabs.newTab().setText("كتب"));
        binding.learnTabs.addTab(binding.learnTabs.newTab().setText("دورات"));
        binding.learnTabsViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        LearnTabAdapter tabAdapter = new LearnTabAdapter(getParentFragmentManager(), this.getLifecycle());
        tabAdapter.addFragment(new LearnMyBooks());
        tabAdapter.addFragment(new LearnMyCourses());
        binding.learnTabsViewpager.setAdapter(tabAdapter);
    }


}