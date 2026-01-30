package com.example.studentmanagement;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private DatabaseHelper databaseHelper;
    private List<Student> studentList;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAdd = findViewById(R.id.fabAdd);
        
        databaseHelper = new DatabaseHelper(this);
        studentList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentAdapter(this, studentList, new StudentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Student student) {
                // Open update activity
                Intent intent = new Intent(MainActivity.this, UpdateStudentActivity.class);
                intent.putExtra("student_id", student.getId());
                intent.putExtra("student_name", student.getName());
                intent.putExtra("student_email", student.getEmail());
                intent.putExtra("student_phone", student.getPhone());
                intent.putExtra("student_course", student.getCourse());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(Student student) {
                // Show delete confirmation
                showDeleteDialog(student);
            }
        });
        recyclerView.setAdapter(adapter);

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });

        loadStudents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadStudents();
    }

    private void loadStudents() {
        studentList = databaseHelper.getAllStudents();
        adapter.updateList(studentList);
        
        if (studentList.isEmpty()) {
            Toast.makeText(this, "No students found. Add a new student!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDeleteDialog(Student student) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Student")
                .setMessage("Are you sure you want to delete " + student.getName() + "?")
                .setPositiveButton("Delete", (dialog, which) -> {
                    databaseHelper.deleteStudent(student.getId());
                    loadStudents();
                    Toast.makeText(MainActivity.this, "Student deleted", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
