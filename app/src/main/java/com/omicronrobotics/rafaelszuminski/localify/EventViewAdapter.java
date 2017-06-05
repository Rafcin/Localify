package com.omicronrobotics.rafaelszuminski.localify;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rafaelszuminski on 6/4/17.
 */

public class EventViewAdapter extends BaseAdapter {
    ArrayList<String> events; //Array
    Context adapContext;
    LayoutInflater layoutInflater;

    public EventViewAdapter(ArrayList<String> arrevents, Context c){
        events = arrevents;
        adapContext = c;
        layoutInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(events == null) {
            return 0;
        }
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        if(events == null) {
            return null;
        }
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void setEventData(ArrayList<String> eventsArray){
        events = eventsArray;
        //Data set to new Data to update it.
        notifyDataSetChanged();
        //Updates The Current Info

    }
    public ArrayList<String> getEventData(){
        return events;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View layout = layoutInflater.inflate(R.layout.list_item,null);

        TextView eventName = (TextView) layout.findViewById(R.id.fileItem);
        ImageView imageFile = (ImageView)layout.findViewById(R.id.listImage);

        eventName.setGravity(View.TEXT_ALIGNMENT_CENTER);
        eventName.setText(events.get(i));
        eventName.setTextColor(Color.rgb(33,33,33));   //BlueColor -- Color.rgb(46,68,159)
        eventName.setHeight(220);

        imageFile.setImageResource(R.drawable.ic_placeholder);


        return layout;

    }
}
