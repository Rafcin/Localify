package com.omicronrobotics.rafaelszuminski.localify;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rafaelszuminski on 6/4/17.
 */

public class EventViewAdapter extends RecyclerView.Adapter{
    ArrayList<String> events; //Array
    Context adapContext;
    LayoutInflater layoutInflater;

    private String mURL = "https://lh3.googleusercontent.com/proxy/A6pVXalBNZtPf_Og75YROwW1cOJwaPKebBzAerfWw9y2mqBSoezvfjtac5tUg9IJS_46AXuRJQNswlAx-mj3EmMRZOqzCkNvUNIOcMoSQMchCPhPc_-teg=s1060-p-rw";




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        ImageView imageFile;
        public MyViewHolder(View v) {
            super(v);

            eventName = (TextView) v.findViewById(R.id.eventName);
            imageFile = (ImageView)v.findViewById(R.id.img_thumbnail);


            eventName.setTextColor(Color.rgb(33,33,33));   //BlueColor -- Color.rgb(46,68,159)
        }
    }
    
    public EventViewAdapter(ArrayList<String> arrevents, Context c){
        events = arrevents;
        adapContext = c;
        layoutInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View layout = layoutInflater.inflate(R.layout.list_item,null);


        MyViewHolder vh = new MyViewHolder(layout);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vHolder = (MyViewHolder) holder;
        vHolder.eventName.setText(events.get(position));
        //vHolder.imageFile.setImageResource();
        Picasso.with(adapContext).load(mURL).into(vHolder.imageFile);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    public ArrayList<String> getEventData(){
        return events;
    }
    
    
    @Override
    public int getItemCount() {
        return getEventData().size();
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);

    }

}
