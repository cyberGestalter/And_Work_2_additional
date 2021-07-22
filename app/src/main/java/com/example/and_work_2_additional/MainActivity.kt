package com.example.and_work_2_additional

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var count = 0
    private val COUNT = "count"
    private lateinit var showCountView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCountView = findViewById(R.id.show_count)
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNT)
        }
        showCountView.text = combineCountWithLions()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (count != 0) {
            outState.putInt(COUNT, count)
        }
    }

    fun countUp(view: View) {
        count++
        showCountView.text = combineCountWithLions()
    }

    private fun combineCountWithLions(): String {
        return if (count == 1) {
            String.format(getString(R.string.combine_count_and_lion_template),
                count, getString(R.string.one_lion))
        } else {
            String.format(getString(R.string.combine_count_and_lion_template),
                count, getString(R.string.many_lions))
        }
    }

    fun showCounted(view: View) {
        val intent = Intent(this, ShowCountActivity::class.java)
        intent.putExtra(ShowCountActivity.COUNTED_TEXT, showCountView.text.toString())
        startActivity(intent)
    }
}