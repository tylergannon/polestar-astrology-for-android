package com.tylergannon.polestar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_show_chart.*
import com.tyler.fourPillars.*
import org.joda.time.LocalDate

val DATA_BRANCH = "com.tylergannon.polestar.BRANCH"

class ShowChartActivity : AppCompatActivity() {
    fun sendMessage(chartHouseView: ChartHouseView) = startActivity(Intent(this, ChartHouseDetailActivity::class.java).apply {
        putExtra(DATA_BRANCH, ChartHouseView.Props(chartHouseView.branch, chartHouseView.palace, chartHouseView.stars))
    })

    fun clickRat(view: View) = sendMessage(house_rat)
    fun clickOx(view: View) = sendMessage(house_ox)
    fun clickTiger(view: View) = sendMessage(house_tiger)
    fun clickRabbit(view: View) = sendMessage(house_rabbit)
    fun clickDragon(view: View) = sendMessage(house_dragon)
    fun clickSnake(view: View) = sendMessage(house_snake)
    fun clickHorse(view: View) = sendMessage(house_horse)
    fun clickGoat(view: View) = sendMessage(house_goat)
    fun clickMonkey(view: View) = sendMessage(house_monkey)
    fun clickRooster(view: View) = sendMessage(house_rooster)
    fun clickDog(view: View) = sendMessage(house_dog)
    fun clickPig(view: View) = sendMessage(house_pig)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_chart)
        val lunarDate = LunarDate.forDate(LocalDate(1978, 4, 7))

        val chartParameters = ChartParameters(
            lunarDate.yearPillar,
            lunarDate.monthPillar,
            lunarDate.dayPillar,
            lunarDate.hourPillar(Branch.Monkey),
            lunarDate.dayOfMonth.toInt()
        )
        val chart = Chart(chartParameters, chartParameters.ming)
        chart.houses.entries.forEach {
            val viewName = "house_" + it.key.branch.name.toLowerCase()
            val viewIdentifier = resources.getIdentifier(viewName, "id", packageName)
            findViewById<ChartHouseView>(viewIdentifier).run {
                palace = it.key.palace
                this.stars = it.value
                layoutParams.height = layoutParams.width
            }
        }
    }
}
