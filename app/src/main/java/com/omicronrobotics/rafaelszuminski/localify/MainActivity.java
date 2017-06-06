package com.omicronrobotics.rafaelszuminski.localify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mEventAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //Add to adapter
    ArrayList<String> currentPostsARL;


    //ListView
    RecyclerView feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        currentPostsARL = new ArrayList<>();

        feed = (RecyclerView) findViewById(R.id.view_feed);


        String[] currentPosts = LocalEvents.getFakeLocalEvents(30);

        for (String post : currentPosts) {
            currentPostsARL.add(post);
        }

        mEventAdapter = new RecyclerAdapter(currentPosts);


        feed.setBackgroundColor(Color.WHITE);

        //choose file location
        //sdcardChooser();

        
        feed.setAdapter(mEventAdapter);


    }


}
