package com.hkcc.vaccinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private Calendar addYears(Calendar toDate, int years) {
        Calendar result = Calendar.getInstance();
        result.setTime(toDate.getTime());

        result.add(Calendar.YEAR, years);
        final Calendar result1 = result;
        return result1;
    }

    private Calendar addMonths(Calendar toDate, int months) {

            Calendar result = Calendar.getInstance();
            result.setTime(toDate.getTime());

            result.add(Calendar.MONTH,months);
            return result;
    }

    private static String formatDate(Calendar cal) {
        android.icu.text.SimpleDateFormat format = new android.icu.text.SimpleDateFormat("yyyy-MM-dd");
        Date dt = cal.getTime();
        String dateString = format.format(dt);
        return dateString;

    }

    private Calendar getCalendarFromStr(String dateStr)
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }


    public void vaccinate(View view) {

        EditText etDOB = (EditText) findViewById(R.id.txtDOB);
        String dob = etDOB.getText().toString();


        Calendar calDOB = getCalendarFromStr(dob);

        Calendar nextYear = addYears(calDOB, 1);

        LinearLayout llVaccineLayout = findViewById(R.id.vaccineTable);

        TextView tv = new TextView(MainActivity.this);
        tv.setText("DOB: " + formatDate(calDOB));
        llVaccineLayout.addView(tv);

        TextView tvOneYear = new TextView(MainActivity.this);
        tvOneYear.setText("1st year: " + formatDate(nextYear));
        llVaccineLayout.addView(tvOneYear);

        Toast.makeText(getApplicationContext(), "your date of birth is " + dob + " and 1 yr later is " + formatDate(nextYear), Toast.LENGTH_SHORT).show();

    }





}
