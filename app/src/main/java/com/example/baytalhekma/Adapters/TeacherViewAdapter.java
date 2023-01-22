package com.example.baytalhekma.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baytalhekma.Models.OnBoardItems;
import com.example.baytalhekma.Models.TeacherItem;
import com.example.baytalhekma.R;

import java.util.List;

public class TeacherViewAdapter extends RecyclerView.Adapter<TeacherViewAdapter.TeacherVH>{

    private List<TeacherItem> teacherItemList;

    public TeacherViewAdapter(List<TeacherItem> lista)
    {
        this.teacherItemList = lista;
    }

    @NonNull
    @Override
    public TeacherVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeacherVH(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.teachergrid,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull TeacherVH holder, int position) {
        holder.setData(teacherItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return teacherItemList.size();
    }

    class TeacherVH extends RecyclerView.ViewHolder
    {
        private ImageView face;
        private TextView name;
        private TextView description;

        public TeacherVH(@NonNull View itemView) {
            super(itemView);
            face = itemView.findViewById(R.id.teacherfaceimg);

            name = itemView.findViewById(R.id.teacherName);
            description = itemView.findViewById(R.id.teacherDescription);


        }
        void setData(TeacherItem item) {
            face.setImageResource(item.getFaceImage());
            name.setText(item.getTeacherName());
            description.setText(item.getTeacherDescription());
        }
    }
}
