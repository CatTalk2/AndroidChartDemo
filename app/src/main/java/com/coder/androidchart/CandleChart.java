package com.coder.androidchart;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by QiWangming on 2015/5/2.
 */
public class CandleChart extends Activity {

    private CandleStickChart chart;
    private CandleData data;
    private ArrayList<String> xVals;
    private CandleDataSet dataSet;
    private ArrayList<CandleEntry> yVals;
    private Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chart=new CandleStickChart(this);
        setContentView(chart);

        xVals=new ArrayList<>();
        yVals=new ArrayList<>();
        random=new Random();
        for(int i=0;i<12;i++){
            float close=random.nextFloat();
            yVals.add(new CandleEntry(i,2f,1.5f,1.0f,close));
            xVals.add((i+1)+"月");
        }
        dataSet=new CandleDataSet(yVals,"公司年度利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data=new CandleData(xVals,dataSet);
        chart.setData(data);
        chart.setDescription("公司年度利润");
        chart.animateY(5000);

    }
}
