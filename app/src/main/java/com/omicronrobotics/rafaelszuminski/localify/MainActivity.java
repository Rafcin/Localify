package com.omicronrobotics.rafaelszuminski.localify;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v13.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

        feed.setLayoutManager(new LinearLayoutManager(this));

        feed.setAdapter(mEventAdapter);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.INTERNET},
                1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}
