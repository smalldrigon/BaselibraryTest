package com.example.baselibrarytest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.jessyan.autosize.internal.CancelAdapt

class MainActivity : AppCompatActivity(),CancelAdapt {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
