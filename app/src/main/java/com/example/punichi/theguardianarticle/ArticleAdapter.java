package com.example.punichi.theguardianarticle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import static android.R.attr.thumb;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by nguye on 12/22/2016.
 * In ArticleAdapter: create methods which set value for each element of a view
 */

public class ArticleAdapter extends ArrayAdapter {
    //variable
    private String TitleOfArticle, NameOfSection, PublicationDate, PublicationDate_CutOff, UrlOfArticle;
    private Bitmap Thumbnail = null;

    //constructora
    public ArticleAdapter(Activity context, int resource, ArrayList<Article> articles){
        super(context, 0, articles);
    }

    //set value for each element of a view
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }

        //get current object
        Article article = (Article)getItem(position);

        //
        TitleOfArticle = article.getmTitleOfArticle();
        TextView TitleView = (TextView)listItemView.findViewById(R.id.Title_Of_Article);
        TitleView.setText(TitleOfArticle);

        //
        NameOfSection = article.getmNameOfSection();
        TextView SectionView = (TextView)listItemView.findViewById(R.id.Name_Of_Section);
        SectionView.setText(NameOfSection);

        //
        PublicationDate = article.getmPublicationDate();
        PublicationDate_CutOff = PublicationDate.substring(0,10);
        TextView DateView = (TextView)listItemView.findViewById(R.id.Publication_Date);
        DateView.setText(PublicationDate_CutOff);

        //
        Thumbnail = article.getmThumbnail();
        ImageView thumbnailView = (ImageView)listItemView.findViewById(R.id.thumbnail);
        thumbnailView.setImageBitmap(Thumbnail);

        return listItemView;

    }
}
