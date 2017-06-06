package com.omicronrobotics.rafaelszuminski.localify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rafaelszuminski on 6/4/17.
 */

public class EventViewAdapter extends RecyclerView.Adapter{
    ArrayList<String> events; //Array
    Context adapContext;
    LayoutInflater layoutInflater;




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        ImageView imageFile;
        public MyViewHolder(View v) {
            super(v);

            eventName = (TextView) v.findViewById(R.id.event_name);
            imageFile = (ImageView)v.findViewById(R.id.listImage);


            //eventName.setGravity(View.TEXT_ALIGNMENT_CENTER);
            //eventName.setTextColor(Color.rgb(33,33,33));   //BlueColor -- Color.rgb(46,68,159)
            //eventName.setHeight(220);
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
        vHolder.imageFile.setImageResource(R.drawable.ic_placeholder);
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


    /*
     * BaseAdapter Overrides, we are now using a RecyclerView.Adapter instead
     */
//    @Override
//    public int getCount() {
//        if(events == null) {
//            return 0;
//        }
//        return events.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        if(events == null) {
//            return null;
//        }
//        return events.get(i);
//    }
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View layout = layoutInflater.inflate(R.layout.list_item,null);
//
//        TextView eventName = (TextView) layout.findViewById(R.id.event_name);
//        ImageView imageFile = (ImageView)layout.findViewById(R.id.listImage);
//
//        eventName.setGravity(View.TEXT_ALIGNMENT_CENTER);
//        eventName.setText(events.get(i));
//        eventName.setTextColor(Color.rgb(33,33,33));   //BlueColor -- Color.rgb(46,68,159)
//        eventName.setHeight(220);
//
//        imageFile.setImageResource(R.drawable.ic_placeholder);
//
//
//        return layout;
//    }
}
