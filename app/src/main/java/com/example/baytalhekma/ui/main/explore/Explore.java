package com.example.baytalhekma.ui.main.explore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baytalhekma.Adapters.ExploreTabAdapter;
import com.example.baytalhekma.Adapters.LearnTabAdapter;
import com.example.baytalhekma.R;
import com.example.baytalhekma.databinding.FragmentExploreBinding;
import com.example.baytalhekma.databinding.FragmentLearnBinding;
import com.example.baytalhekma.ui.main.learn.LearnMyBooks;
import com.example.baytalhekma.ui.main.learn.LearnMyCourses;
import com.google.android.material.tabs.TabLayout;


public class Explore extends Fragment {

    ExploreTabAdapter tabAdapter;
    FragmentExploreBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExploreBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        setup();
        listenerAndCallback();


        return view;
    }

    private void listenerAndCallback() {
        binding.exploreTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.exploreTabsViewpager.setCurrentItem(tab.getPosition(),true);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        binding.exploreTabsViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.exploreTabs.selectTab(binding.exploreTabs.getTabAt(position));
            }
        });
    }

    private void setup() {
        binding.exploreTabs.addTab(binding.exploreTabs.newTab().setText("كتب"));
        binding.exploreTabs.addTab(binding.exploreTabs.newTab().setText("دورات"));
        binding.exploreTabsViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        LearnTabAdapter tabAdapter = new LearnTabAdapter(getParentFragmentManager(), this.getLifecycle());
        tabAdapter.addFragment(new ExploreBooks());
        tabAdapter.addFragment(new ExploreCourses());
        binding.exploreTabsViewpager.setAdapter(tabAdapter);
    }
}
