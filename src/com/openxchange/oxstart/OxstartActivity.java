package com.openxchange.oxstart;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.webkit.WebStorage;
import android.webkit.WebSettings.RenderPriority;

public class OxstartActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        WebView engine = (WebView) findViewById(R.id.web_engine);  
        WebSettings engineSettings = engine.getSettings();

        
        
        // just open all urls in the webview
        engine.setWebViewClient(new WebViewClient()       
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) 
            {
                return false;
            }
        });
        engineSettings.setJavaScriptEnabled(true);  
        engineSettings.setDomStorageEnabled(true);
        engineSettings.setAppCacheMaxSize(1024*1024*64);
        String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
        engineSettings.setAppCachePath(appCachePath);
        engineSettings.setAllowFileAccess(true);
        engineSettings.setAppCacheEnabled(true);
        engineSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        
        engine.loadUrl("https://ox7-dev.open-xchange.com"); 
    }
}