package com.omicronrobotics.rafaelszuminski.localify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    RecyclerView.Adapter mEventAdapter;

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

        mEventAdapter = new EventViewAdapter(currentPostsARL, this);


        //feed.setBackgroundColor(Color.RED);

        //choose file location
        //sdcardChooser();

        feed.setLayoutManager(new LinearLayoutManager(this));

        feed.setAdapter(mEventAdapter);



    }


}
