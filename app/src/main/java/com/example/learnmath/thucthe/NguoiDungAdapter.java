package com.example.learnmath.thucthe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnmath.R;

import java.util.List;

public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungAdapter.ViewHolder> {

    private List<NguoiDungTable> nguoiDungList;

    public NguoiDungAdapter(List<NguoiDungTable> nguoiDungList) {
        this.nguoiDungList = nguoiDungList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.danh_sach_nguoi_dung, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NguoiDungTable nguoiDung = nguoiDungList.get(position);
        holder.nameTextView.setText(nguoiDung.name);
        holder.scoreTextView.setText(String.valueOf(nguoiDung.score));
        holder.timeTextView.setText(nguoiDung.time); // Set the time value
    }

    @Override
    public int getItemCount() {
        return nguoiDungList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView scoreTextView;
        public TextView timeTextView; // Add a TextView for time

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            scoreTextView = itemView.findViewById(R.id.score_text_view);
            timeTextView = itemView.findViewById(R.id.time_text_view); // Initialize the time TextView
        }
    }
}