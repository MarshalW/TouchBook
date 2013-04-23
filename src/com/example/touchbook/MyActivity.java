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
import android.widget.Button;
import android.widget.ExpandableListView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final WebView webView = new WebView(this);
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

        ViewGroup rootView = (ViewGroup) findViewById(R.id.rootView);
        rootView.addView(webView);

        TouchView touchView = new TouchView(this);
        touchView.setBackgroundColor(Color.TRANSPARENT);
        rootView.addView(touchView);

        View commandView = View.inflate(this, R.layout.command, rootView);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (button.getText().equals("下一页")) {
                    webView.loadUrl("javascript:nextPage();");
                } else {
                    webView.loadUrl("javascript:beforePage();");
                }
            }
        };

        commandView.findViewById(R.id.beforeButton).setOnClickListener(onClickListener);
        commandView.findViewById(R.id.afterButton).setOnClickListener(onClickListener);
    }
}
