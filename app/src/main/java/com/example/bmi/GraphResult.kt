package com.example.bmi

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidplot.xy.*
import kotlinx.android.synthetic.main.activity_graph_result.*
import java.text.DecimalFormat
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition

class GraphResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_result)

        val db = DatabaseHandler(this)
        val list = db.allData()


        /*
         * filter, map, sort
         * map -> zmapować i zwrócić listę elementów po konkretnych zmianach
         */

//        for(bmi in list) {
//            domainLabels += bmi.date;
//        }

        val domainLabels: List<String> = list.map {it.date;}
        //val domainLabels = list.map { it.id }
        val series1Number =  list.map { it.weight };

        val series1: XYSeries = SimpleXYSeries(
            series1Number, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Waga"
        )

        val series1Format = LineAndPointFormatter(Color.BLUE, Color.BLACK, null, null)

        series1Format.interpolationParams = CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal)

        series1Format.linePaint.strokeWidth = 10f
        series1Format.vertexPaint.strokeWidth = 30f



        plot.addSeries(series1, series1Format)
        plot.setRangeBoundaries(0, 150, BoundaryMode.FIXED)
        plot.setRangeStep(StepMode.INCREMENT_BY_VAL,10.0)
        plot.setDomainStep(StepMode.SUBDIVIDE, 3.0)


        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.LEFT).format = DecimalFormat("#")

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

        //PanZoom.attach(plot)
    }
}