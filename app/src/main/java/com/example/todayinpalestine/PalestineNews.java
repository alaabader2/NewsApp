package com.example.todayinpalestine;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PalestineNews extends Fragment {
    RecyclerView recyclerView;
    NewsAdapter adapter;
    private ProgressDialog progressDialog;

    List<News> newsList;

    private static final String URL = " https://newsapi.org/v2/top-headlines?q=palestine&apiKey=4609aa78a3c046f891fd419ce8748125";

    public PalestineNews() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_palestine_news, container, false);

        recyclerView = view.findViewById(R.id.pal_news);
        newsList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        loadData();
        return view;
    }

    private void loadData() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");
                    for (int i = 0; 1 < jsonArray.length(); i++) {
                        JSONObject json0bject = jsonArray.getJSONObject(i);
                        String title = json0bject.getString("title");
                        String desc = json0bject.getString("description");
                        String url = json0bject.getString("url");
                        String imageUrl = json0bject.getString("urlToImage");
                        String publishedAt = json0bject.getString("publishedAt");
                        JSONObject source = json0bject.getJSONObject("source");
                        String name = source.getString("name");

                        adapter = new NewsAdapter(getContext(), newsList);
                        News news = new News(name, title, desc, url, imageUrl, publishedAt);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected void deliverResponse(JSONObject response) {
                super.deliverResponse(response);

            }

            @Override
            public void deliverError(VolleyError error) {
                super.deliverError(error);

            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {
                return super.parseNetworkError(volleyError);

            }

        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(jsonObjectRequest);
    }
}