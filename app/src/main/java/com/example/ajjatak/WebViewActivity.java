package com.example.ajjatak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    Toolbar mtoolbar;
    WebView mwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mtoolbar = findViewById(R.id.tool_bar);
        mwebview = findViewById(R.id.web_view);
        setSupportActionBar(mtoolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mwebview.setWebViewClient(new WebViewClient());
        mwebview.loadUrl(url);
    }
}