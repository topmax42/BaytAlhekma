package com.example.baytalhekma.ui.controluser;

import android.os.Binder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.baytalhekma.Adapters.OnBoardadapter;
import com.example.baytalhekma.Models.OnBoardItems;
import com.example.baytalhekma.R;
import com.example.baytalhekma.databinding.FragmentIntroductionBinding;

import java.util.ArrayList;
import java.util.List;


public class Introduction extends Fragment {

    FragmentIntroductionBinding binding;
    NavController navController;
    private OnBoardadapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIntroductionBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        setViewPager();
        okListener();
    }

    private void okListener() {
        binding.buttonOk.setOnClickListener(view -> a(binding.onBoardviewpager));
    }

    private void setViewPager() {
        setItems();
        binding.onBoardviewpager.setAdapter(adapter);
        setIndicator();
        setCurrentIndex(0);
        binding.onBoardviewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndex(position);
            }
        });
    }


    public void a(ViewPager2 v) {
        int p = v.getCurrentItem();
        if (p <= v.getChildCount()) {
            v.setCurrentItem(p + 1, true);

        } else {
            //Intent i = new Intent(getActivity(), loginsignup.class);
            //startActivity(i);
            navController.navigate(R.id.action_introduction_to_loginorRegister);
        }


    }


    private void setItems() {
        List<OnBoardItems> elitemss = new ArrayList<>();
        OnBoardItems i1 = new OnBoardItems();
        i1.setImage(R.drawable.mask_group_40);
        i1.setText1(getResources().getString(R.string.lorem));
        i1.setText2(getResources().getString(R.string.loremipsum));
        OnBoardItems i2 = new OnBoardItems();
        i2.setImage(R.drawable.mask_group_41);
        i2.setText1(getResources().getString(R.string.lorem));
        i2.setText2(getResources().getString(R.string.loremipsum));
        OnBoardItems i3 = new OnBoardItems();
        i3.setImage(R.drawable.mask_group_42);
        i3.setText1(getResources().getString(R.string.lorem));
        i3.setText2(getResources().getString(R.string.loremipsum));


        elitemss.add(i1);
        elitemss.add(i2);
        elitemss.add(i3);

        adapter = new OnBoardadapter(elitemss);

    }

    private void setIndicator() {
        ImageView[] indicators = new ImageView[adapter.getItemCount()];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 0, 10, 0);
        for (int c = 0; c < indicators.length; c++) {
            indicators[c] = new ImageView(getActivity().getApplicationContext());
            indicators[c].setImageDrawable(ContextCompat.getDrawable(
                    getActivity().getApplicationContext(), R.drawable.dotinactive));
            indicators[c].setLayoutParams(params);
            binding.bottomLayoutIndicator.addView(indicators[c]);
        }
    }

    private void setCurrentIndex(int index) {
        int ic = binding.bottomLayoutIndicator.getChildCount();
        for (int c = 0; c < ic; c++) {
            ImageView imageView = (ImageView) binding.bottomLayoutIndicator.getChildAt(c);
            if (c == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.dotactive)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.dotinactive)
                );
            }
        }
    }

}