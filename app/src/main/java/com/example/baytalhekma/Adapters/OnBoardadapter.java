package com.example.baytalhekma.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baytalhekma.Models.OnBoardItems;
import com.example.baytalhekma.R;

import java.util.List;

public class OnBoardadapter extends RecyclerView.Adapter<OnBoardadapter.VH>{

    private List<OnBoardItems> itemlist;

    public OnBoardadapter(List<OnBoardItems> lista)
    {
        this.itemlist = lista;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.onboardingslider,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.setdata(itemlist.get(position));
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    class VH extends RecyclerView.ViewHolder
    {
        private ImageView img;
        private TextView txt1;
        private TextView txt2;

        public VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView2);
            txt1 = itemView.findViewById(R.id.textView);
            txt2 = itemView.findViewById(R.id.textView2);


        }
        void setdata(OnBoardItems item) {
            img.setImageResource(item.getImage());
            txt1.setText(item.getText1());
            txt2.setText(item.getText2());
        }
    }
}
