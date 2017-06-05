package com.omicronrobotics.rafaelszuminski.localify;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    TextView mContentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        
        mContentView = (TextView) findViewById(R.id.content_post);
        
        String[] currentPosts = LocalEvents.getFakeLocalEvents(30);
        
        for(String post : currentPosts) {
            mContentView.append(post);
        }
        
    }


}
