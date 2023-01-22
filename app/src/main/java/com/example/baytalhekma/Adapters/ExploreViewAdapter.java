package com.example.baytalhekma.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baytalhekma.Models.Course;
import com.example.baytalhekma.Models.SelectListener;
import com.example.baytalhekma.R;

import java.util.List;

public class ExploreViewAdapter extends RecyclerView.Adapter<ExploreViewAdapter.CourseVH>{

    private List<Course> courseList;
    private SelectListener listener;

    public ExploreViewAdapter(List<Course> lista, SelectListener listner)

    {
        this.courseList = lista;
        this.listener = listner;
    }

    @NonNull
    @Override
    public CourseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CourseVH(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.exploregrid,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull CourseVH holder, int position) {
        holder.setData(courseList.get(position));
        holder.lL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(courseList.get(holder.getAdapterPosition()));
            }
        });
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
        private LinearLayout lL;

        public CourseVH(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.expgridimg);

            name = itemView.findViewById(R.id.expgridtxt1);
            description = itemView.findViewById(R.id.expgridtxt2);
            lL = itemView.findViewById(R.id.exploreGrid);


        }
        void setData(Course item) {
            cover.setImageResource(item.getImage());
            name.setText(item.getName());
            description.setText(item.getDescription());
        }
    }
}
