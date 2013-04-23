package com.example.touchbook;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView webView = new WebView(this);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage message) {
                Log.d("touchbook", message.message() + " -- From line "
                        + message.lineNumber() + " of "
                        + message.sourceId());
                return true;
            }
        });

        webView.loadUrl("file:///android_asset/index.html");

        ViewGroup rootView=(ViewGroup)findViewById(R.id.rootView);
        rootView.addView(webView);

        TouchView touchView=new TouchView(this);
        touchView.setBackgroundColor(Color.TRANSPARENT);
        rootView.addView(touchView);
    }
}
