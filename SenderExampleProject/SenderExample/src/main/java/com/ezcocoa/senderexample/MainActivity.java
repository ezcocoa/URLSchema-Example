package com.ezcocoa.senderexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wb = (WebView) findViewById(R.id.webview);
        wb.loadDataWithBaseURL(null,"<html><head></head><body><a href=\"ezcocoa://someaction?result=I was sent from other.\">Go to second display of another app.</a></body></html>","text/html", null, "");
        wb.setWebViewClient(new EZWebViewClient());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra("result");
            TextView tv = (TextView)findViewById(R.id.activity_main_btn);
            tv.setText("result->"+result);
        }
    }

    public void onAction(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("ezcocoa://someaction?result=I was sent from other."));
        startActivity(i);
    }

    protected class EZWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("ezcocoa:")) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;
            }
            return false;
        }
    }
}
