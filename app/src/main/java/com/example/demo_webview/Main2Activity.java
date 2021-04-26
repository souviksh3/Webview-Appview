package com.example.demo_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {
    ProgressBar progressbar;
    WebView webview;
    String u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressbar = findViewById(R.id.progressbar);
        progressbar.setMax(100);
        webview = findViewById(R.id.webview);

        u =  getIntent().getStringExtra("url");
        webview.setWebViewClient(new HelpClient());
        webview.setWebChromeClient(new WebChromeClient() {

            public void onProgressChanged(WebView view, int progress) {

                progressbar.setProgress(progress);

                setTitle("Loading.....");

                if (progress == 100) {
                    setTitle(""+u);

                    progressbar.setProgress(0);

                }

                super.onProgressChanged(view, progress);
            }
        });

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webview.loadUrl("https://"+u);

    }

    private class HelpClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
    }
}



    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

}


