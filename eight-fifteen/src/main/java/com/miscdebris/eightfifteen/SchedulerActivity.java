package com.miscdebris.eightfifteen;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SchedulerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduler_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scheduler, menu);
        return true;
    }
    
}
