package com.example.punichi.theguardianarticle;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        //write your code here
        //set navigation up
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        String UrlOfArticle = getIntent().getStringExtra("UrlOfArticle_ID");
        WebView webView = (WebView)findViewById(R.id.webview);
        //
        webView.loadUrl(UrlOfArticle);
        //String htmtText = "<p>This is a simple HTML text</p>";
        //webView.loadData(htmtText, "text/html", null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
