package com.coder.androidchart;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by QiWangming on 2015/5/2.
 */
public class BarChartActivity extends Activity {

    private Random random;//���ڲ��������

    private BarChart chart;
    private BarData data;
    private BarDataSet dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chart = new BarChart(getApplicationContext());
        setContentView(chart);


        //
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<String>();
        random=new Random();
        for(int i=0;i<12;i++){
            float profit= random.nextFloat()*1000;
            entries.add(new BarEntry(profit,i));
            xVals.add(i+"��");
        }
        dataSet = new BarDataSet(entries, "��˾�����󱨱�");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new BarData(xVals, dataSet);
        chart.setData(data);
        chart.animateY(3000);
        chart.setDescription("��˾ǰ������񱨱�(��λ����Ԫ)");

    }
}
