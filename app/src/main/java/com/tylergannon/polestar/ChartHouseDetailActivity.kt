package com.tylergannon.polestar

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_chart_house_detail.*
import org.joda.time.DateTimeZone

class ChartHouseDetailActivity : AppCompatActivity() {
    private val ids = DateTimeZone.getAvailableIDs().toTypedArray()
    private val spinnerItem = R.layout.spinner_item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_house_detail)
        val (_, palace, stars) = intent.getParcelableExtra<ChartHouseView.Props>(DATA_BRANCH)
        title = palace.name
        stars.sorted().sortedBy { it.Rank }.forEach { star ->
            stars_list.addView(TextView(applicationContext).also { textView ->
                textView.text = star.english
                textView.setTextColor(Color.BLACK)
                textView.textSize = 30.0f - (2f * star.Rank)
            })
        }

//        ArrayAdapter<String>(applicationContext, spinnerItem, ids).also { adapter ->
//
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            select_time_zone.adapter = adapter
//        }
    }
}
