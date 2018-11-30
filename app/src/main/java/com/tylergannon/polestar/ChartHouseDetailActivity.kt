package com.tylergannon.polestar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chart_house_detail.*

class ChartHouseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_house_detail)
        val (branch, palace, stars) = intent.getParcelableExtra<ChartHouseView.Props>(DATA_BRANCH)
        title = palace.name
        stars.sorted().sortedBy { it.Rank }
    }
}
