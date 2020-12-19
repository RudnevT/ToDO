package com.example.todo_2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_2.model.Task

@Database(entities = [Task::class], version = 6, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}