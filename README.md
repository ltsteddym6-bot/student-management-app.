# Student Management App - Android Project

## Overview
A complete Android application for managing student records with SQLite database integration.

## Features
- ✅ **Add Student**: Create new student records with name, email, phone, and course
- ✅ **View Students**: Display all students in a scrollable list
- ✅ **Update Student**: Edit existing student information
- ✅ **Delete Student**: Remove student records (with confirmation dialog)
- ✅ **SQLite Database**: Persistent local storage

## Technical Details
- **Language**: Java
- **Min SDK**: API 21 (Android 5.0 Lollipop)
- **Target SDK**: API 33 (Android 13)
- **Database**: SQLite
- **UI Components**: RecyclerView, Material Design components

## Project Structure
```
StudentManagementApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/studentmanagement/
│   │   │   ├── MainActivity.java           # Main screen with student list
│   │   │   ├── AddStudentActivity.java     # Add new student
│   │   │   ├── UpdateStudentActivity.java  # Update student details
│   │   │   ├── DatabaseHelper.java         # SQLite database operations
│   │   │   ├── Student.java                # Student data model
│   │   │   └── StudentAdapter.java         # RecyclerView adapter
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_add_student.xml
│   │   │   │   └── activity_update_student.xml
│   │   │   └── values/
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## How to Build and Run

### Prerequisites
- Android Studio (Arctic Fox or newer)
- JDK 8 or higher
- Android SDK (API 21-33)

### Steps
1. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the `StudentManagementApp` folder
   - Click "OK"

2. **Sync Gradle**
   - Android Studio will automatically sync Gradle files
   - Wait for the sync to complete

3. **Run the App**
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon)
   - Select your device/emulator
   - The app will install and launch

## Usage Guide

### Adding a Student
1. Tap the floating "+" button on the main screen
2. Fill in student details (Name, Email, Phone, Course)
3. Tap "Save Student"

### Viewing Students
- All students are displayed on the main screen
- Tap on any student to update their information

### Updating a Student
1. Tap on a student from the list
2. Modify the desired fields
3. Tap "Update Student"

### Deleting a Student
1. Long-press on a student in the list
2. Confirm deletion in the dialog

## Database Schema
```sql
Table: students
- id (INTEGER PRIMARY KEY AUTOINCREMENT)
- name (TEXT)
- email (TEXT)
- phone (TEXT)
- course (TEXT)
```

## Key Classes

### DatabaseHelper.java
- Manages SQLite database operations
- Methods: addStudent(), getAllStudents(), updateStudent(), deleteStudent(), getStudent()

### MainActivity.java
- Displays student list using RecyclerView
- Handles navigation to Add/Update screens
- Shows delete confirmation dialog

### Student.java
- Data model class representing a student
- Contains getters and setters for all fields

## Dependencies
```gradle
- androidx.appcompat:appcompat:1.6.1
- com.google.android.material:material:1.9.0
- androidx.constraintlayout:constraintlayout:2.1.4
- androidx.recyclerview:recyclerview:1.3.1
```

## Screenshots Features
- Material Design UI
- Blue color theme
- Floating Action Button for adding students
- Card-based layouts
- Form validation

## Troubleshooting

### Build Errors
- Make sure you have the correct Android SDK installed
- Sync Gradle files: File > Sync Project with Gradle Files
- Clean and rebuild: Build > Clean Project, then Build > Rebuild Project

### Runtime Issues
- Check that your device/emulator meets minimum SDK requirements (API 21+)
- Verify app permissions in device settings

## Future Enhancements
- Search functionality
- Student photo support
- Export to CSV/PDF
- Cloud sync
- Attendance tracking
- Grade management

## License
This is a student project for educational purposes.

## Author
Created as a practical exercise for Android development learning.
