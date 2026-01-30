package com.example.studentmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<Student> studentList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Student student);
        void onItemLongClick(Student student);
    }

    public StudentAdapter(Context context, List<Student> studentList, OnItemClickListener listener) {
        this.context = context;
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textName.setText(student.getName());
        holder.textDetails.setText(student.getCourse() + " - " + student.getPhone());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(student));
        holder.itemView.setOnLongClickListener(v -> {
            listener.onItemLongClick(student);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void updateList(List<Student> newList) {
        studentList = newList;
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textDetails;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(android.R.id.text1);
            textDetails = itemView.findViewById(android.R.id.text2);
        }
    }
}
