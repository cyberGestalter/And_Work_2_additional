package com.example.and_work_2_additional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowCountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_count)

        val countedView: TextView = findViewById(R.id.counted_text)
        val countedText = intent.getStringExtra(COUNTED_TEXT)
        countedView.text = String.format(getString(R.string.we_have_counted_lions_template), countedText)
    }

    companion object {
        const val COUNTED_TEXT = "counted_text"
    }
}