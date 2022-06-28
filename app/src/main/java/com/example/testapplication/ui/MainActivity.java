package com.example.testapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import com.example.testapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private BarChart chart;
    private String title;
    private Button buttonPlayGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = findViewById(R.id.chart1);
        buttonPlayGame = findViewById(R.id.btn_play_game);

        setBarChartProperties();

        /*final Handler handler = new Handler(Looper.getMainLooper());

        showProgressBar(true);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showProgressBar(false);
                setBarChart();
            }
        }, 3000);*/


        setBarChart();

        buttonPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });



    }

    private void setBarChartProperties() {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setPinchZoom(true);
        chart.getDescription().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        /*Description description = new Description();
        description.setEnabled(false);
        chart.setDescription(description);*/
        chart.setDrawGridBackground(false);
        XAxis xAxis = chart.getXAxis();

        title = "Loan Scheme Stats";

        ArrayList<String> year = new ArrayList();
        year.add("Applied");
        year.add("In-Process");
        year.add("Eligible");
        year.add("Disapproved");
        year.add("Disbursed");
        year.add("Jobs");

        xAxis.setValueFormatter(new IndexAxisValueFormatter(year));
        xAxis.setTextSize(8f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelRotationAngle(45f);
        xAxis.setDrawGridLines(false);
        YAxis yAxis1 = chart.getAxis(YAxis.AxisDependency.LEFT);
        yAxis1.setAxisMinimum(0f);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.CIRCLE);
        l.setFormSize(9f);
        l.setTextSize(11f);


    }

    private void setBarChart() {



        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(0, 50000));
        entries.add(new BarEntry(1, 20000));
        entries.add(new BarEntry(2, 2000));
        entries.add(new BarEntry(3, 40000));
        entries.add(new BarEntry(4, 3000));
        entries.add(new BarEntry(5, 80000));



        //xAxis.setDrawGridLinesBehindData(true);




        BarDataSet barDataSet = new BarDataSet(entries, title);
        barDataSet.setColor( getResources().getColor(R.color.green_700));
        barDataSet.setValueTextSize(7f);

        BarData data = new BarData( barDataSet);
        chart.setData(data);
        chart.invalidate();
    }
}