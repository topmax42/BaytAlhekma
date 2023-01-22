package com.example.baytalhekma.ui.main.teacher;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baytalhekma.Adapters.OnBoardadapter;
import com.example.baytalhekma.Adapters.TeacherViewAdapter;
import com.example.baytalhekma.Models.OnBoardItems;
import com.example.baytalhekma.Models.TeacherItem;
import com.example.baytalhekma.R;
import com.example.baytalhekma.databinding.FragmentTeachersBinding;

import java.util.ArrayList;
import java.util.List;


public class Teachers extends Fragment {

    private TeacherViewAdapter adapter;
    FragmentTeachersBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTeachersBinding.inflate(inflater, container, false);

        setupRecycler();
        setItems();
        return binding.getRoot();
    }

    private void setupRecycler() {
        binding.teacherRV.setLayoutManager(new GridLayoutManager(getActivity(),2));
        binding.teacherRV.setAdapter(adapter);
    }

    private void setItems() {

        List<TeacherItem> teacherList = new ArrayList<>();
        TeacherItem teacherItem = new TeacherItem();
        teacherItem.setFaceImage(R.drawable.face);
        teacherItem.setTeacherName("احمد اسماعيل");
        teacherItem.setTeacherDescription(getResources().getString(R.string.executive));



        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);
        teacherList.add(teacherItem);



        adapter = new TeacherViewAdapter(teacherList);

    }
}