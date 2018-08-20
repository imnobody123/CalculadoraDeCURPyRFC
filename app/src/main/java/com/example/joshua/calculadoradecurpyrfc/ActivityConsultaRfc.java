package com.example.joshua.calculadoradecurpyrfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityConsultaRfc extends AppCompatActivity {

    String URL = "https://www.mi-rfc.com.mx/consulta-rfc-homoclave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_rfc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView consultaRfc = (WebView) findViewById(R.id.viewRfc);
        consultaRfc.setWebViewClient(new clientView());
        consultaRfc.clearCache(true);
        consultaRfc.setLongClickable(true);
        WebSettings config = consultaRfc.getSettings();
        config.setJavaScriptEnabled(true);
        config.setBuiltInZoomControls(true);
        consultaRfc.loadUrl(URL);
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
