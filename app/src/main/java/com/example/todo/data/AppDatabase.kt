package com.example.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.model.Task

@Database(entities = [Task::class], version = 5, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}