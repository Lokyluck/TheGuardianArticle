package com.example.punichi.theguardianarticle;

import android.graphics.Bitmap;

/**
 * Created by nguye on 12/22/2016.
 * Article object contain these values: title of article, name of section, Publication Date and url
 */

public class Article {
    //variable
    private String mTitleOfArticle, mNameOfSection, mPublicationDate, mUrlOfArticle;
    private Bitmap mThumbnail;

    //constructor
    public Article (String TitleOfArticle, String NameOfSection, String PublicationDate, Bitmap Thumbnail, String UrlOfArticle){
        mTitleOfArticle = TitleOfArticle;
        mNameOfSection = NameOfSection;
        mPublicationDate = PublicationDate;
        mThumbnail = Thumbnail;
        mUrlOfArticle = UrlOfArticle;
    }
    //
    public String getmTitleOfArticle(){
        return mTitleOfArticle;
    }
    public String getmNameOfSection(){
        return mNameOfSection;
    }
    public String getmPublicationDate(){
        return mPublicationDate;
    }
    public Bitmap getmThumbnail(){return mThumbnail;}
    public String getmUrlOfArticle(){
        return mUrlOfArticle;
    }
}
