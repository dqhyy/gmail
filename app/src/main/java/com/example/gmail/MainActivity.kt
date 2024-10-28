package com.example.gmail

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.StudentAdapter
import com.example.myapplication.StudentModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val students = mutableListOf<StudentModel>()
        repeat(28) {
            students.add(
                StudentModel("Sender$it", "19 Only (First 10 spots) - Best...",
                    "Are you looking for Learn Web Designing...", "12:34 PM")
            )
        }

        val adapter = StudentAdapter(students)

        val listStudents = findViewById<ListView>(R.id.list_students)
        listStudents.adapter = adapter
    }
}