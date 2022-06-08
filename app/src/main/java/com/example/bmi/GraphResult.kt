package com.example.bmi

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidplot.xy.*
import kotlinx.android.synthetic.main.activity_graph_result.*
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition

class GraphResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_result)

        val db = DatabaseHandler(this)
        val list = db.allData()

        for (bmi in list) {

            val domainLabels = bmi.date.toString()
            val series1Number = bmi.weight.toString()


        }



        val domainLabels = arrayOf<Number>(1, 2, 3, 6, 7, 8, 9, 10, 13, 14)

        val series1Number = arrayOf<Number>(1, 4, 8, 12, 16, 32, 26, 29, 10, 13)
        val series2Number = arrayOf<Number>(2, 8, 4, 7, 32, 16, 64, 12, 7, 10)

        val series1: XYSeries = SimpleXYSeries(
            listOf(* series1Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series 1"
        )
        val series2: XYSeries = SimpleXYSeries(
            listOf(* series2Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series 1"
        )

        val series1Format = LineAndPointFormatter(Color.BLUE, Color.BLACK, null, null)
        val series2Format = LineAndPointFormatter(Color.DKGRAY, Color.LTGRAY, null, null)

        series1Format.interpolationParams = CatmullRomInterpolator.Params(
            10,
            CatmullRomInterpolator.Type.Centripetal
        )
        series2Format.interpolationParams = CatmullRomInterpolator.Params(
            10,
            CatmullRomInterpolator.Type.Centripetal
        )

        plot.addSeries(series1, series1Format)
        plot.addSeries(series2, series2Format)

        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = object : Format() {
            override fun format(
                obj: Any?,
                toAppendTo: StringBuffer,
                pos: FieldPosition
            ): StringBuffer {
                val i = Math.round((obj as Number).toFloat())
                return toAppendTo.append(domainLabels[i])
            }

            override fun parseObject(source: String?, pos: ParsePosition): Any? {
                return null
            }

        }
        PanZoom.attach(plot)
    }
}