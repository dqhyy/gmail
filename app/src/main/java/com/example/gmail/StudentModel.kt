package com.example.gmail

data class StudentModel(var name: String, val subject: String, val body: String, val time: String) {
    var selected: Boolean = false
}