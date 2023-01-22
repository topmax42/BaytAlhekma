package com.example.baytalhekma.ui.main.learn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baytalhekma.Adapters.ExploreViewAdapter;
import com.example.baytalhekma.Adapters.LearnViewAdapter;
import com.example.baytalhekma.Adapters.TeacherViewAdapter;
import com.example.baytalhekma.Models.Course;
import com.example.baytalhekma.Models.TeacherItem;
import com.example.baytalhekma.R;

import java.util.ArrayList;
import java.util.List;


public class LearnMyBooks extends Fragment {

    private LearnViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_my_books, container, false);

        RecyclerView booksRecycler = (RecyclerView) view.findViewById(R.id.learnbooksRV);
        booksRecycler.setLayoutManager(new GridLayoutManager(getActivity(),1));
        setItems();
        booksRecycler.setAdapter(adapter);




        return view;
    }
    private void setItems() {

        List<Course> courseList = new ArrayList<>();
        Course course = new Course();
        course.setImage(R.drawable.hsk1);
        course.setName("HSK.1");
        course.setDescription(getResources().getString(R.string.loremipsum));



        courseList.add(course);
        courseList.add(course);
        courseList.add(course);
        courseList.add(course);
        courseList.add(course);
        courseList.add(course);
        courseList.add(course);










        adapter = new LearnViewAdapter(courseList);

    }
}