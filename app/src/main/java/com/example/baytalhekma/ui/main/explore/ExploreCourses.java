package com.example.baytalhekma.ui.main.explore;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baytalhekma.Adapters.ExploreViewAdapter;
import com.example.baytalhekma.Models.Course;
import com.example.baytalhekma.Models.SelectListener;
import com.example.baytalhekma.R;

import java.util.ArrayList;
import java.util.List;


public class ExploreCourses extends Fragment implements SelectListener {
    private ExploreViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore_courses, container, false);

        RecyclerView courseRecycler = view.findViewById(R.id.expcoursesRV);
        courseRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        setItems();
        courseRecycler.setAdapter(adapter);


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





        adapter = new ExploreViewAdapter(courseList,this);

    }

    @Override
    public void onItemClicked(Course course) {
        Intent i = new Intent(getActivity(),CoursePreview.class);
        i .putExtra("course", course);
        startActivity(i);
    }
}