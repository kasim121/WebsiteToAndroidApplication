package com.example.newspaperandmagazine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myNewWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myNewWebView=(WebView) findViewById(R.id.myWebView);
        myNewWebView.setWebViewClient(new WebViewClient());
        myNewWebView.loadUrl("https://cobwebfreenewspaper.com/");
        WebSettings webSettings=myNewWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(myNewWebView.canGoBack()) {
            myNewWebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}