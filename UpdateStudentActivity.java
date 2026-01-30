package com.example.studentmanagement;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateStudentActivity extends AppCompatActivity {

    private EditText editName, editEmail, editPhone, editCourse;
    private Button btnUpdate;
    private DatabaseHelper databaseHelper;
    private int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editCourse = findViewById(R.id.editCourse);
        btnUpdate = findViewById(R.id.btnUpdate);

        databaseHelper = new DatabaseHelper(this);

        // Get student data from intent
        studentId = getIntent().getIntExtra("student_id", -1);
        String name = getIntent().getStringExtra("student_name");
        String email = getIntent().getStringExtra("student_email");
        String phone = getIntent().getStringExtra("student_phone");
        String course = getIntent().getStringExtra("student_course");

        // Set data to fields
        editName.setText(name);
        editEmail.setText(email);
        editPhone.setText(phone);
        editCourse.setText(course);

        btnUpdate.setOnClickListener(v -> updateStudent());
    }

    private void updateStudent() {
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

        Student student = new Student(studentId, name, email, phone, course);
        int result = databaseHelper.updateStudent(student);

        if (result > 0) {
            Toast.makeText(this, "Student updated successfully!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to update student", Toast.LENGTH_SHORT).show();
        }
    }
}
