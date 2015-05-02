package com.coder.androidchart;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by QiWangming on 2015/5/2.
 */
public class PieChartActivity extends Activity {

    private PieChart chart;
    private PieData data;
    private ArrayList<String>  xVals;
    private ArrayList<Entry>  yVals;
    private PieDataSet dataSet;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chart=new PieChart(this);
        setContentView(chart);
        yVals=new ArrayList<>();
        xVals=new ArrayList<String>();
        random=new Random();
        for(int i=0;i<6;i++){
            float profix=random.nextFloat()*1000;
            yVals.add(new Entry(profix,i));
            xVals.add((i+1)+"月");
        }

        dataSet=new PieDataSet(yVals,"公司前半年利润报表");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data=new PieData(xVals,dataSet);
        chart.setDescription("公司前半年利润");
        chart.setData(data);
        chart.animateY(3000);
    }
}
