package com.example.myfirstactivity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class MySecondActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_second)
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "Segunda ACTIVITY", Toast.LENGTH_LONG).show()
    }
}