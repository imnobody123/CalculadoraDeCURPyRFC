package com.example.joshua.calculadoradecurpyrfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityPagConsultaCurp extends AppCompatActivity {

    String URL = "https://consultas.curp.gob.mx/CurpSP/inicio2_2.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_consulta_curp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView consultaCurp = (WebView) findViewById(R.id.webView);
        consultaCurp.setWebViewClient(new clientView());
        consultaCurp.clearCache(true);
        consultaCurp.setLongClickable(true);
        WebSettings config = consultaCurp.getSettings();
        config.setJavaScriptEnabled(true);
        config.setBuiltInZoomControls(true);
        consultaCurp.loadUrl(URL);
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

    public class clientView extends WebViewClient{
        public boolean shouldOverideUrlLoading(WebView view, String Url){
            view.loadUrl(URL);
            return true;
        }
    }
}
