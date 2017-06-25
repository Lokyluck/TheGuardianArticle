package com.example.punichi.theguardianarticle;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import static android.view.View.GONE;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Article>>{
    //variable
    //String JsonString = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":22959,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":2296,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"us-news/2016/sep/26/presidential-debates-nixon-kennedy-1960\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-26T15:57:34Z\",\"webTitle\":\"The Nixon-Kennedy presidential debates: from the archive, 1960\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/26/presidential-debates-nixon-kennedy-1960\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/26/presidential-debates-nixon-kennedy-1960\",\"isHosted\":false},{\"id\":\"commentisfree/2016/sep/23/presidential-debates-real-time-reactions-notifications-mobile\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2016-09-23T21:43:23Z\",\"webTitle\":\"Get real-time reactions during the presidential debates | Guardian Mobile Innovation Lab\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2016/sep/23/presidential-debates-real-time-reactions-notifications-mobile\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2016/sep/23/presidential-debates-real-time-reactions-notifications-mobile\",\"isHosted\":false},{\"id\":\"us-news/2016/sep/25/us-presidential-debates-famous-moments\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-25T10:00:31Z\",\"webTitle\":\"Make or break: the defining moments of presidential debates\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/25/us-presidential-debates-famous-moments\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/25/us-presidential-debates-famous-moments\",\"isHosted\":false},{\"id\":\"us-news/2016/sep/02/presidential-debate-moderators-martha-raddatz-anderson-cooper\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-02T16:53:02Z\",\"webTitle\":\"The Clinton-Trump presidential debates: who are the moderators?\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/02/presidential-debate-moderators-martha-raddatz-anderson-cooper\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/02/presidential-debate-moderators-martha-raddatz-anderson-cooper\",\"isHosted\":false},{\"id\":\"science/political-science/2016/oct/24/hinkley-c-shows-the-value-of-social-science-in-the-most-toxic-public-debates\",\"type\":\"article\",\"sectionId\":\"science\",\"sectionName\":\"Science\",\"webPublicationDate\":\"2016-10-24T06:30:07Z\",\"webTitle\":\"Hinkley C shows the value of social science in the most toxic public debates\",\"webUrl\":\"https://www.theguardian.com/science/political-science/2016/oct/24/hinkley-c-shows-the-value-of-social-science-in-the-most-toxic-public-debates\",\"apiUrl\":\"https://content.guardianapis.com/science/political-science/2016/oct/24/hinkley-c-shows-the-value-of-social-science-in-the-most-toxic-public-debates\",\"isHosted\":false},{\"id\":\"us-news/2016/oct/19/where-is-climate-change-in-the-trump-v-clinton-presidential-debates\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-10-19T12:00:07Z\",\"webTitle\":\"Why has climate change been ignored in the US election debates?\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/oct/19/where-is-climate-change-in-the-trump-v-clinton-presidential-debates\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/oct/19/where-is-climate-change-in-the-trump-v-clinton-presidential-debates\",\"isHosted\":false},{\"id\":\"us-news/2016/oct/22/clinton-trump-debate-analysis-foreign-policy-economy-scandals\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-10-22T11:00:15Z\",\"webTitle\":\"What did Clinton and Trump talk about in the debates – and for how long?\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/oct/22/clinton-trump-debate-analysis-foreign-policy-economy-scandals\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/oct/22/clinton-trump-debate-analysis-foreign-policy-economy-scandals\",\"isHosted\":false},{\"id\":\"politics/2016/jun/02/eu-referendum-tv-debates-when-where-watch-them\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2016-06-09T12:53:46Z\",\"webTitle\":\"EU referendum debates: when and where to watch them\",\"webUrl\":\"https://www.theguardian.com/politics/2016/jun/02/eu-referendum-tv-debates-when-where-watch-them\",\"apiUrl\":\"https://content.guardianapis.com/politics/2016/jun/02/eu-referendum-tv-debates-when-where-watch-them\",\"isHosted\":false},{\"id\":\"uk-news/2016/mar/04/slough-debates-whether-to-change-its-name\",\"type\":\"article\",\"sectionId\":\"uk-news\",\"sectionName\":\"UK news\",\"webPublicationDate\":\"2016-03-04T17:54:54Z\",\"webTitle\":\"Slough debates whether to change its name\",\"webUrl\":\"https://www.theguardian.com/uk-news/2016/mar/04/slough-debates-whether-to-change-its-name\",\"apiUrl\":\"https://content.guardianapis.com/uk-news/2016/mar/04/slough-debates-whether-to-change-its-name\",\"isHosted\":false},{\"id\":\"us-news/2016/sep/27/clinton-trump-debate-analysis\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2016-09-27T09:07:22Z\",\"webTitle\":\"Hillary Clinton shows strength over Trump in one of history's weirdest, wildest debates\",\"webUrl\":\"https://www.theguardian.com/us-news/2016/sep/27/clinton-trump-debate-analysis\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2016/sep/27/clinton-trump-debate-analysis\",\"isHosted\":false}]}}";
    String stringUrl = "http://content.guardianapis.com/search?sections=world&api-key=3332cb85-086e-43d7-93d0-e0bd4e9d03c2&order-by=newest&show-fields=thumbnail&show-blocks=body";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int ARTICLE_LOADER_ID = 1;
    private ArticleAdapter adapter;
    private TextView mEmptyTextView;
    private ProgressBar progressBar;

    //method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //write your code here
        //create articles data
        ArrayList<Article> articles = new ArrayList<Article>();
        //articles = Utils.Extract_Article_Data_FromUrl(stringUrl);

        ListView listView = (ListView)findViewById(R.id.list);
        //Create ArrayAdapter and inflate articles to it
        adapter = new ArticleAdapter(
                MainActivity.this, 0, articles);
        listView.setAdapter(adapter);

        //progressBar = (ProgressBar)findViewById(R.id.loading_spinner);
        mEmptyTextView = (TextView)findViewById(R.id.empty_view);
        listView.setEmptyView(mEmptyTextView);

        //Click on item to see full article
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postition, long l) {
                Article currentArticle = (Article)adapter.getItem(postition);
                //Uri UrlOfArticle = Uri.parse(currentArticle.getmUrlOfArticle());
                String UrlOfArticle = currentArticle.getmUrlOfArticle();
                Intent intent = new Intent(getBaseContext(), BrowserActivity.class);
                intent.putExtra("UrlOfArticle_ID", UrlOfArticle);
                startActivity(intent);
            }
        });

        //check the network connection
        ConnectivityManager connManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
        {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, MainActivity.this);
        }
        else noInternet();
    }

    //Loader Callback methods

    @Override
    public Loader<ArrayList<Article>> onCreateLoader(int i, Bundle bundle) {
        return new ArticleLoader(this, stringUrl);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Article>> loader, ArrayList<Article> articles) {
        adapter.clear();
        if (articles != null && !articles.isEmpty()) {
            adapter.addAll(articles);
        }
        mEmptyTextView.setText("No Articles Found!");
        progressBar = (ProgressBar)findViewById(R.id.loading_spinner);
        progressBar.setVisibility(GONE);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Article>> loader)
    {
        adapter.clear();
    }

    private void noInternet(){
        progressBar = (ProgressBar)findViewById(R.id.loading_spinner);
        progressBar.setVisibility(GONE);
        mEmptyTextView.setText("No Internet Connection!");
    }
}
