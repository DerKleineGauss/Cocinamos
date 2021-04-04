package com.example.cocinamos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
    }

    fun on_edit_clicked(view: View) {}
    fun on_add_clicked(v: View) {
        val intent = Intent(v.context, AddRecipe::class.java)
        startActivity(intent)
    }
    fun on_remove_clicked(view: View) {}
    fun on_menue_clicked(view: View) {}
    fun on_filter_clicked(view: View) {}
}