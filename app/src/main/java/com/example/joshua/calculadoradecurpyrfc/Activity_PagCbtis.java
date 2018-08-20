package com.example.joshua.calculadoradecurpyrfc;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;

public class Activity_PagCbtis extends AppCompatActivity {

    String URL = "http://cbtis65.identaplus.net/servidor/alumnos/index.php";
    String Tag = Activity_PagCbtis.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pag_cbtis);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView consultaCalif = (WebView) findViewById(R.id.viewCbtis);
        consultaCalif.setWebViewClient(new clientView());
        consultaCalif.clearCache(true);
        consultaCalif.clearHistory();
        WebSettings config = consultaCalif.getSettings();
        config.setJavaScriptEnabled(true);
        config.setBuiltInZoomControls(true);
        consultaCalif.loadUrl(URL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class clientView extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String Url){
            view.loadUrl(URL);
            return true;
        }
    }
}
