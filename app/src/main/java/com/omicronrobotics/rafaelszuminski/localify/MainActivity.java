package com.omicronrobotics.rafaelszuminski.localify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView mContentView;
    EventViewAdapter mEventAdapter;
    MaterialViewPager mViewPager;


    //Add to adapter
    ArrayList<String> currentPostsARL;


    //ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        currentPostsARL = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listview);


        String[] currentPosts = LocalEvents.getFakeLocalEvents(30);

        for (String post : currentPosts) {
            currentPostsARL.add(post);
        }

        mEventAdapter = new EventViewAdapter(currentPostsARL, this);


        listView.setBackgroundColor(Color.WHITE);
        listView.setDividerHeight(0);

        //choose file location
        //sdcardChooser();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        listView.setAdapter(mEventAdapter);


    }


}
