package com.tylergannon.polestar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tyler.fourPillars.*
import java.time.LocalDate

class ShowChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_chart)
        val lunarDate = LunarDate.forDate(LocalDate.of(1978, 4, 7))

        val chartParameters = ChartParameters(
            lunarDate.yearPillar,
            lunarDate.monthPillar,
            lunarDate.dayPillar,
            lunarDate.hourPillar(Branch.Monkey),
            lunarDate.dayOfMonth.toInt()
        )
        val chart = Chart(chartParameters, chartParameters.ming)

        chart.houses.forEach { house: House, stars: List<Star> ->
            val viewName = "house_" + house.branch.name.toLowerCase()
            findViewById<ChartHouseView>(resources.getIdentifier(viewName, "id", packageName))?.run {
                setData(house.palace, stars)
                layoutParams.height = layoutParams.width
            }
        }

    }
}
