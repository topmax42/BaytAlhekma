package com.example.baytalhekma.ui.main.explore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baytalhekma.Models.Course;
import com.example.baytalhekma.R;

public class CoursePreview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_preview);
        Course c = (Course) getIntent().getSerializableExtra("course");
        ImageView img = findViewById(R.id.courseprvimg);
        img.setImageResource(c.getImage());
        Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();


    }
}