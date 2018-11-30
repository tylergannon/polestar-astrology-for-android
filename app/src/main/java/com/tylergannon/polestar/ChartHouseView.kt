package com.tylergannon.polestar

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.parcel.Parcelize
import com.tyler.fourPillars.Branch
import com.tyler.fourPillars.Palace
import com.tyler.fourPillars.Star

class ChartHouseView(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private var _stars: List<Star> = listOf()
    private var _palace: Palace = Palace.Ancestors
    private var _branch: Branch = Branch.Snake

    @Parcelize data class Props(val branch: Branch, val palace: Palace, val stars: List<Star>) : Parcelable

    var palace: Palace get() = _palace
        set(it) {
            _palace = it
            findViewById<TextView>(R.id.house_name).run { text = it.name }
        }

    var branch: Branch get() = _branch
        set(it) {
            _branch = it
            findViewById<TextView>(R.id.branch).text = it.name
        }

    var stars: List<Star>
        get() = _stars
        set(them) { _stars = them
                    findViewById<LinearLayout>(R.id.stars)?.run {
                        _stars.forEach { star ->
                            val textView = TextView(context)
                            textView.text = star.english
                            textView.id = star.ordinal
                            addView(textView)
                        }
                    }
                }

    init {
        View.inflate(context, R.layout.layout_chart_house_view, this)
        branch = context?.obtainStyledAttributes(attrs, R.styleable.ChartHouseView)
                        ?.getString(R.styleable.ChartHouseView_branch)?.let { Branch.valueOf(it) }
                        ?: Branch.Snake
    }
}
