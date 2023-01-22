package com.example.baytalhekma.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baytalhekma.Models.Course;
import com.example.baytalhekma.R;

import java.util.List;

public class LearnViewAdapter extends RecyclerView.Adapter<LearnViewAdapter.CourseVH>{

    private List<Course> courseList;

    public LearnViewAdapter(List<Course> lista)
    {
        this.courseList = lista;
    }

    @NonNull
    @Override
    public CourseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CourseVH(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.learnslider,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull CourseVH holder, int position) {
        holder.setData(courseList.get(position));
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    class CourseVH extends RecyclerView.ViewHolder
    {
        private ImageView cover;
        private TextView name;
        private TextView description;

        public CourseVH(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.learnImg);

            name = itemView.findViewById(R.id.learntext1);
            description = itemView.findViewById(R.id.learntext2);


        }
        void setData(Course item) {
            cover.setImageResource(item.getImage());
            name.setText(item.getName());
            description.setText(item.getDescription());
        }
    }
}
