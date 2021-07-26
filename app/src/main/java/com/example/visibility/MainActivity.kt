package com.example.visibility

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var imageOn: Boolean = true
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("visibility", imageOn)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: androidx.appcompat.widget.Toolbar? = findViewById(R.id.tool)
        if (toolbar != null){
            setSupportActionBar(toolbar)
        }
//
        savedInstanceState?.let {
            imageOn = it.getBoolean("visibility")
        }


        showBtn.setOnClickListener {
            if (imageOn){
                showImage.visibility = View.VISIBLE
                showBtn.text = "Hide Image"
                imageOn = false
            }else{
                showImage.visibility = View.INVISIBLE
                showBtn.text = "Show Image"
                imageOn = true
            }

        }

        val fragmentOne = FirstFragment()
        val fragmentTwo = SecondFragment()

        firstFragBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fllayout, fragmentOne).commit()
            }
        }

        secondFragBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fllayout, fragmentTwo).commit()
            }
        }

        englishBtn.setOnClickListener {
            translatedText.text = "This is English"
        }

        frenchBtn.setOnClickListener {
            translatedText.text = "c'est du français"
        }

        spanishBtn.setOnClickListener {
            translatedText.text = "C'est de l'espagnol"
        }
    }
}