package com.ezcocoa.sharedexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri uri = intent.getData();
            String result = uri.getQueryParameter("result");
            TextView tv = (TextView)findViewById(R.id.activity_second_resultTv);
            tv.setText("result->" + result);
        }
    }

    public void onAction(View v) {
        switch (v.getId()) {
            case R.id.activity_second_callbackBtn:
                Log.d(TAG, "Call back");
                Intent i = getIntent();
                i.putExtra("result","Good job");
                setResult(Activity.RESULT_OK, i);
                finish();
                break;
        }
    }
}
