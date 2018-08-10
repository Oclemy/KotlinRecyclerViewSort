package com.devosha.kotlin_recyclerview_sort

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import java.util.*


class MainActivity : AppCompatActivity() {

    internal lateinit var rv: RecyclerView
    internal lateinit var sortBtn: Button
    internal lateinit var adapter: MyAdapter
    private var ascending = true
    companion object {
        private val spacecrafts = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initializeViews()
        this.fillSpacecrafts()
    }

    private fun initializeViews() {
        rv = findViewById(R.id.rv)
        rv.setLayoutManager(LinearLayoutManager(this))
        sortBtn = findViewById(R.id.sortBtn)
        sortBtn.setOnClickListener {
            sortData(ascending)
            ascending = !ascending
        }
    }


    private fun sortData(asc: Boolean) {
        //SORT ARRAY ASCENDING AND DESCENDING
        if (asc) {
            spacecrafts.sort()
        } else {
            spacecrafts.reverse()
        }
        adapter = MyAdapter(this, spacecrafts)
        rv.adapter = adapter
    }

    
    private fun fillSpacecrafts() {

        spacecrafts.clear()
        spacecrafts.add("Kepler")
        spacecrafts.add("Casini")
        spacecrafts.add("Voyager")
        spacecrafts.add("New Horizon")
        spacecrafts.add("James Web")
        spacecrafts.add("Apollo 15")
        spacecrafts.add("WMAP")
        spacecrafts.add("Enterprise")
        spacecrafts.add("Spitzer")
        spacecrafts.add("Galileo")
        spacecrafts.add("Challenger")
        spacecrafts.add("Atlantis")
        spacecrafts.add("Apollo 19")
        spacecrafts.add("Huygens")
        spacecrafts.add("Hubble")
        spacecrafts.add("Juno")
        spacecrafts.add("Aries")
        spacecrafts.add("Columbia")

        //ADAPTER
        adapter = MyAdapter(this, spacecrafts)
        rv.setAdapter(adapter)
    }


}

//end