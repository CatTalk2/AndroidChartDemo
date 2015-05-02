package com.coder.androidchart;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by QiWangming on 2015/5/2.
 */
public class ScatterChartActivity extends Activity {

    private ScatterChart chart;
    private ScatterData data;
    private ScatterDataSet dataSet;
    private ArrayList<String> xVals;
    private ArrayList<Entry> yVals;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chart=new ScatterChart(this);
        setContentView(chart);
        xVals=new ArrayList<>();
        yVals=new ArrayList<>();
        random=new Random();
        for(int i=0;i<12;i++){
            float profix=random.nextFloat()*1000;
            yVals.add(new Entry(profix,i));
            xVals.add((i+1)+"月");
        }
        dataSet=new ScatterDataSet(yVals,"公司年度利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data=new ScatterData(xVals,dataSet);
        chart.setData(data);
        chart.animateY(3000);
        chart.setDescription("公司年度利润");
    }
}
