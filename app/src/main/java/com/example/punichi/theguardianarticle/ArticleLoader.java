package com.example.punichi.theguardianarticle;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.net.URL;
import java.util.ArrayList;


/**
 * Created by nguye on 12/25/2016.
 */

public class ArticleLoader extends AsyncTaskLoader<ArrayList<Article>> {
    //variable
    //query url
    //private static final LOG_TAG = ArticleLoader.class.getName();
    private static final String LOG_TAG = ArticleLoader.class.getName();
    private String mUrl;

    //constructor
    public ArticleLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    //method
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Article> loadInBackground() {
        if (mUrl == null)
            return null;
        ArrayList<Article> articles = Utils.Extract_Article_Data_FromUrl(mUrl);
        return articles;
    }
}
