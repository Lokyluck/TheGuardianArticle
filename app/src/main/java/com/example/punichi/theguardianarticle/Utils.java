package com.example.punichi.theguardianarticle;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlContext;
import java.util.ArrayList;

import static android.R.string.no;
import static java.security.AccessController.getContext;

/**
 * Created by nguye on 12/24/2016.
 * This class help connecting to internet and parse JSON
 */

public final class Utils {
    //variable
    private static final String LOG_TAG = Utils.class.getSimpleName();

    //
    public static ArrayList<Article> Extract_Article_Data_FromUrl(String stringUrl){
        URL url = CreateUrl(stringUrl);
        String jsonResponse = null;
        try {
            jsonResponse = MakeHttpRequest(url);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG, "Error call MakeHttpRequest()");
        }
        ArrayList<Article> articles = ParseJsonObject(jsonResponse);
        return articles;
    }
    //methods
    //create url
    private static URL CreateUrl(String stringUrl){
        URL url = null;
        try
        {
            url = new URL(stringUrl);
        }
        catch(MalformedURLException e){
            Log.e(LOG_TAG, "can not create url", e);
        }
        return url;
    }

    //connect to network
    private static String MakeHttpRequest(URL url) throws IOException{
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        //check if url is null
        if (url == null)
        {
            return null;
        }

        //try to create HttpConnection
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.connect();
            //get Response
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
            else Log.e(LOG_TAG, "Bad Request, code = " + urlConnection.getResponseCode());
        }
        catch(IOException e){
            Log.e(LOG_TAG, "can not create HttpConnection", e);
        }
        finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (inputStream != null)
                inputStream.close();
        }
        return jsonResponse;
    }


    //declare readFromStream() to read inputStream from connection
    private static String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if (inputStream != null)
        {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            catch (IOException e)
            {
                Log.e(LOG_TAG, "Error readFromStream()");
            }
        }
        return output.toString();
    }

    //parse JSON object
    private static ArrayList<Article> ParseJsonObject(String jsonResponse){
        ArrayList<Article> articles = new ArrayList<Article>();
        try {
            JSONObject JsonRootObject = new JSONObject(jsonResponse);
            JSONObject response = JsonRootObject.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");
            for(int i=0; i<results.length(); i++)
            {
                JSONObject ArticleObject = results.getJSONObject(i);
                String TitleOfArticle = ArticleObject.getString("webTitle");
                String NameOfSection = ArticleObject.getString("sectionName");
                String PublicationDate = ArticleObject.getString("webPublicationDate");
                String UrlOfArticle = ArticleObject.getString("webUrl");

                JSONObject Fields = ArticleObject.getJSONObject("fields");
                String stringThumbnail = Fields.getString("thumbnail");
                Bitmap Thumbnail = null;
                try {
                    URL url = new URL(stringThumbnail);
                    Thumbnail = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch(IOException e) {
                    System.out.println(e);
                }

                articles.add(new Article(TitleOfArticle, NameOfSection, PublicationDate, Thumbnail, UrlOfArticle));
            }
        }
        catch(JSONException e){
            Log.e(LOG_TAG, "Error JsonObject");
        }
        return articles;
    }
}
