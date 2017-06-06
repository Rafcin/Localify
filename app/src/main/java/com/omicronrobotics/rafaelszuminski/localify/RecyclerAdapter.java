package com.omicronrobotics.rafaelszuminski.localify;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dkfrayne on 6/5/17.
 */

public class RecyclerAdapter extends Adapter{
    private String[] eventNames;
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public ViewHolder(TextView v) {
            super(v);
            titleView = v;
        }
    }
    
    public RecyclerAdapter(String[] events) {
        eventNames = events;
    }
    
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //holder.titleView.setText(eventNames[position]);
    }
    
    @Override
    public int getItemCount() {
        return 0;
    }
}
