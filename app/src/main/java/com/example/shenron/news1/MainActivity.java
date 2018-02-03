package com.example.shenron.news1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


RecyclerView recycler;
RecyclerViewAdapter adapter;
RequestQueue queue;
StringRequest request;

    List<News> news = new ArrayList<>();
String url_key = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=b5bdfca10f754dfaadf885d3feb9214d";
String LOG_TAG = "news_activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView)findViewById(R.id.main_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        getNews();
    }

   public void getNews(){
        queue = Volley.newRequestQueue(this);
        request = new StringRequest(Request.Method.GET, url_key, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(LOG_TAG,response);
                try{


                    JSONObject responseObject = new JSONObject(response);
                    JSONArray articlesArray = responseObject.optJSONArray("articles");

                    for(int i=0;i<articlesArray.length();i++){
                        JSONObject articlesObject = articlesArray.optJSONObject(i);
                        String newsTitle = articlesObject.optString("title");
                        String newsDescription = articlesObject.optString("description");
                        String newsPublished = articlesObject.optString("publishedAt");
                        String newsImage = articlesObject.optString("urlToImage");
                        news.add(new News(newsTitle,newsDescription,newsPublished,newsImage));
                    }
                    adapter = new RecyclerViewAdapter(news, MainActivity.this);
                    recycler.setAdapter(adapter);
                }

                catch (Exception e){
                }
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(LOG_TAG,"Error");
            }
        });
        queue.add(request);
    }
}
