package com.example.todo.screens.main

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.screens.create.TaskDetailsActivity

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        recyclerView = findViewById(R.id.list)
        recyclerView!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView!!.setBackgroundColor(1)

        val adapter = Adapter()
        recyclerView!!.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { TaskDetailsActivity.start(this@MainActivity, null) }
        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.taskTodayLiveData.observe(this, { tasks ->
            adapter.setItems(tasks)
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val adapter = Adapter()
        recyclerView!!.adapter = adapter

        return when (item.itemId) {
            R.id.action_settings -> true

            R.id.show_today -> {
                mainViewModel.taskTodayLiveData.observe(this, { tasks -> adapter.setItems(tasks) })
                true
            }
            R.id.show_all -> {
                mainViewModel.taskLiveData.observe(this, { tasks -> adapter.setItems(tasks) })
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}