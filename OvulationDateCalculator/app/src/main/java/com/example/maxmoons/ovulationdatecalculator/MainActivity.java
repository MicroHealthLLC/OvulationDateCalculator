package com.example.maxmoons.ovulationdatecalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    //int months[] = {1,2,3,4,5,6,7,8,9,10,11,12};
    //int day28[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
    //int day30[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    //int day31[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    //int year[] = {17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
    public int day = 4;
    public int days = 30;
    public int month = 7;
    public int year = 17;
    public boolean holder = false;
    public boolean euFormat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar DayBar = (SeekBar) findViewById(R.id.DayBar);
        final SeekBar DaysBar = (SeekBar) findViewById(R.id.DaysBar);
        final SeekBar MonthBar = (SeekBar) findViewById(R.id.MonthBar);
        final SeekBar YearBar = (SeekBar) findViewById(R.id.YearBar);
        final TextView DateMenstrual = (TextView) findViewById(R.id.DateMenstrual);
        final TextView Days = (TextView) findViewById(R.id.Days);
        final Button Calculate = (Button) findViewById(R.id.button);
        final TextView textview = (TextView) findViewById(R.id.textView);
        final TextView textview2 = (TextView) findViewById(R.id.textView2);
        final TextView textview3 = (TextView) findViewById(R.id.textView3);
        final TextView textview5 = (TextView) findViewById(R.id.textView5);
        final CheckBox EUFormat = (CheckBox) findViewById(R.id.checkbox);

        EUFormat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                euFormat = b;

                DatechangeM();
            }
        });

        DayBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                day = progress;
                    day+=1;
                DatechangeM();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        DaysBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                days = progress;
                Days.setText(""+days);
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        MonthBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                    progress+=1;
                month = progress;
                if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
                    DayBar.setMax(30);
                else if(month!=2)
                    DayBar.setMax(29);
                else if(year%4==0)
                    DayBar.setMax(28);
                else
                    DayBar.setMax(27);

                DatechangeM();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        YearBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                year = progress;
                    year+=1;
                if(year%4==0&&month==2)
                    DayBar.setMax(28);
                DatechangeM();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });
    }

    public void DatechangeM()
    {
        final TextView DateMenstrual = (TextView) findViewById(R.id.DateMenstrual);
        if(!euFormat)
            DateMenstrual.setText("Date of next expected menstrual period to start:\n"+month+"/"+day+"/"+year);
        else
            DateMenstrual.setText("Date of next expected menstrual period to start:\n"+day+"/"+month+"/"+year);
    }

    public void Calculate(View v)
    {
        holder=!holder;
        int monthHolder=month;
        int dayHolder= day;
        int yearholder = year;
        final SeekBar DayBar = (SeekBar) findViewById(R.id.DayBar);
        final SeekBar DaysBar = (SeekBar) findViewById(R.id.DaysBar);
        final SeekBar MonthBar = (SeekBar) findViewById(R.id.MonthBar);
        final SeekBar YearBar = (SeekBar) findViewById(R.id.YearBar);
        final TextView DateMenstrual = (TextView) findViewById(R.id.DateMenstrual);
        final TextView Days = (TextView) findViewById(R.id.Days);
        final Button Calculate = (Button) findViewById(R.id.button);
        final TextView textview = (TextView) findViewById(R.id.textView);
        final TextView textview2 = (TextView) findViewById(R.id.textView2);
        final TextView textview3 = (TextView) findViewById(R.id.textView3);
        final TextView textview5 = (TextView) findViewById(R.id.textView5);
        final TextView textview8 = (TextView) findViewById(R.id.textView8);
        final TextView OvulDate = (TextView) findViewById(R.id.OvulDate);
        final TextView textview10 = (TextView) findViewById(R.id.textView10);
        final TextView textview11 = (TextView) findViewById(R.id.textView11);
        final CheckBox EUFormat = (CheckBox) findViewById(R.id.checkbox);
        if(holder)
        {
            DayBar.setVisibility(View.INVISIBLE);
            DaysBar.setVisibility(View.INVISIBLE);
            MonthBar.setVisibility(View.INVISIBLE);
            YearBar.setVisibility(View.INVISIBLE);
            DateMenstrual.setVisibility(View.INVISIBLE);
            Days.setVisibility(View.INVISIBLE);
            Calculate.setText("Back");
            textview.setVisibility(View.INVISIBLE);
            textview2.setVisibility(View.INVISIBLE);
            textview3.setVisibility(View.INVISIBLE);
            textview5.setVisibility(View.INVISIBLE);
            textview8.setVisibility(View.VISIBLE);
            while((dayHolder+days/2)>30)
            {
                dayHolder-=30;
                monthHolder+=1;
            }
            if(monthHolder==2&&(dayHolder+days/2)>28)
            {monthHolder+=1; dayHolder-=28;}
            if(monthHolder>=13)
            {yearholder+=1; monthHolder-=12;}
            if(!euFormat)
                OvulDate.setText(monthHolder+"/"+(dayHolder+days/2)+"/"+yearholder);
            else
                OvulDate.setText((dayHolder+days/2)+"/"+monthHolder+"/"+yearholder);
            OvulDate.setVisibility(View.VISIBLE);
            textview10.setVisibility(View.VISIBLE);
            textview11.setVisibility(View.VISIBLE);
        }
        else
        {
            DayBar.setVisibility(View.VISIBLE);
            DaysBar.setVisibility(View.VISIBLE);
            MonthBar.setVisibility(View.VISIBLE);
            YearBar.setVisibility(View.VISIBLE);
            DateMenstrual.setVisibility(View.VISIBLE);
            Days.setVisibility(View.VISIBLE);
            Calculate.setText("Calculate");
            textview.setVisibility(View.VISIBLE);
            textview2.setVisibility(View.VISIBLE);
            textview3.setVisibility(View.VISIBLE);
            textview5.setVisibility(View.VISIBLE);
            textview8.setVisibility(View.INVISIBLE);
            OvulDate.setVisibility(View.INVISIBLE);
            textview10.setVisibility(View.INVISIBLE);
            textview11.setVisibility(View.INVISIBLE);

        }
    }

    public void Terms(View v)
    {
        Uri uri = Uri.parse("https://microhealthllc.com/about/terms-of-use/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
