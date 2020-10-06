package com.hkcc.vaccinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void vaccinate(View view) {
        Toast.makeText(getApplicationContext(),"You have clicked me",Toast.LENGTH_SHORT).show();
    }

}
