package com.coder.androidchart;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by QiWangming on 2015/5/2.
 */
public class HorizontalChart extends Activity {

    private HorizontalBarChart chart;
    private BarData data;
    private ArrayList<String> xVals;
    private BarDataSet dataSet;
    private ArrayList<BarEntry> yVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chart=new HorizontalBarChart(this);
        setContentView(chart);
        xVals=new ArrayList<>();
        yVals=new ArrayList<>();

        for(int i=0;i<12;i++){
            float profix=new Random().nextFloat();
            yVals.add(new BarEntry(profix,i));
            xVals.add((i+1)+"月");
        }

        dataSet=new BarDataSet(yVals,"前半年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data=new BarData(xVals,dataSet);
        chart.setData(data);
        chart.setDescription("前半年利润");

    }
}
