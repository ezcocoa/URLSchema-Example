package com.ezcocoa.sharedexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAction(View v) {
        switch(v.getId()) {
            case R.id.activity_main_secondBtn:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
