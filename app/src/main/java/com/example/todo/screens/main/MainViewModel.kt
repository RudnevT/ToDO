package com.example.todo.screens.main

import androidx.lifecycle.ViewModel
import com.example.todo.App.Companion.instance
import java.text.SimpleDateFormat
import java.util.*


class MainViewModel: ViewModel() {

    val sdf = SimpleDateFormat("dd.MM.yyyy")
    var date = sdf.format(Date())

    val taskLiveData = instance!!.taskDao!!.getAllTasksLiveData()
    val taskTodayLiveData = instance!!.taskDao!!.getTodayTasksLiveData(date.toString())
}