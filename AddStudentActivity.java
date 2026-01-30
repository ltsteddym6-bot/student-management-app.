package com.example.studentmanagement;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText editName, editEmail, editPhone, editCourse;
    private Button btnSave;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editCourse = findViewById(R.id.editCourse);
        btnSave = findViewById(R.id.btnSave);

        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> saveStudent());
    }

    private void saveStudent() {
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();
        String course = editCourse.getText().toString().trim();

        if (name.isEmpty()) {
            editName.setError("Name is required");
            editName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            editPhone.setError("Phone is required");
            editPhone.requestFocus();
            return;
        }

        if (course.isEmpty()) {
            editCourse.setError("Course is required");
            editCourse.requestFocus();
            return;
        }

        Student student = new Student(name, email, phone, course);
        long id = databaseHelper.addStudent(student);

        if (id > 0) {
            Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to add student", Toast.LENGTH_SHORT).show();
        }
    }
}
