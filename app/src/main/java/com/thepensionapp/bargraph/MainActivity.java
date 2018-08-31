package com.thepensionapp.bargraph;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity implements IAxisValueFormatter {
    BarChart barChart;
    private  String[] mLabels={ "Jan", "Feb", "Mar","Apr","May","Jun" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart=(BarChart)findViewById(R.id.bargraph);


        ArrayList<BarEntry> entries=new ArrayList<>();//Y-axis data
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(4f, 70f));
        entries.add(new BarEntry(5f, 65f));
        BarDataSet barDataSet=new BarDataSet(entries,"Contributions");



        BarData barData=new BarData(barDataSet);//bargraph data
        barData.setBarWidth(0.9f);// set custom bar width

        barChart.setData(barData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mLabels));
        barChart.getDescription().setEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.RED);
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mLabels[(int) value];
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
