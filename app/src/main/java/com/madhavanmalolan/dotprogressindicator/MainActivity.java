package com.madhavanmalolan.dotprogressindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.madhavanmalolan.dotfillprogress.DotFillProgressbar;

public class MainActivity extends AppCompatActivity {

    DotFillProgressbar dotProgressIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotProgressIndicator = (DotFillProgressbar) findViewById(R.id.test);
        dotProgressIndicator.setFilled(3);
    }
}
