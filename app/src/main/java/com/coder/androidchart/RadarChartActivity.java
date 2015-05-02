package com.coder.androidchart;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by QiWangming on 2015/5/2.
 */
public class RadarChartActivity extends Activity {

    private RadarChart chart;
    private RadarData data;
    private ArrayList<String> xVals;
    private RadarDataSet dataSet;
    private ArrayList<Entry> yVals;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chart=new RadarChart(this);
        setContentView(chart);
        random=new Random();
        xVals=new ArrayList<>();
        yVals=new ArrayList<>();

        for (int i=0;i<6;i++){
            float profix=random.nextFloat()*1000;
            yVals.add(new Entry(profix,i));
            xVals.add(i+1+"月");
        }
        dataSet=new RadarDataSet(yVals,"公司前半年利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        data=new RadarData(xVals,dataSet);

        chart.setDescription("公司前半年利润");
        chart.animateX(3000);
        chart.setData(data);


    }
}
