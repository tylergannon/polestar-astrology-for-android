package com.tylergannon.polestar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.tyler.fourPillars.Palace
import com.tyler.fourPillars.Star


class ChartHouseView(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private val houseTextView get() = findViewById<TextView>(R.id.house_name)

    fun setData(palace: Palace, stars: List<Star>) {
        houseTextView?.text = palace.name

        findViewById<LinearLayout>(R.id.stars)?.run {
            stars.forEach { star ->
                val textView = TextView(context)
                textView.text = star.english
                textView.id = star.ordinal
                addView(textView)
            }
        }
    }

    init {
        View.inflate(context, R.layout.layout_chart_house_view, this)

        context?.obtainStyledAttributes(attrs, R.styleable.ChartHouseView)?.let { attributes ->
            findViewById<TextView>(R.id.branch).text = attributes.getString(R.styleable.ChartHouseView_branch)
        }
    }
}
