package com.omicronrobotics.rafaelszuminski.localify;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

    private String mPostImageadr = "https://thenextweb.com/wp-content/blogs.dir/1/files/2013/09/85807485.jpg";
    private String mUserIconadr = "https://lh6.googleusercontent.com/-0sRw6H119gw/AAAAAAAAAAI/AAAAAAAAAAA/wBS2KABxWnY/s128-c-k/photo.jpg";




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        ImageView imageFile;
        ImageView userIcon;
        ImageButton shareButton;
        Toolbar mTopToolBar;
        Toolbar mBottomToolBar;




        public MyViewHolder(View v) {
            super(v);

            eventName = (TextView) v.findViewById(R.id.eventName);
            imageFile = (ImageView)v.findViewById(R.id.img_thumbnail);
            userIcon = (ImageView)v.findViewById(R.id.userIcon);
            shareButton = (ImageButton) v.findViewById(R.id.shareColorButton);
            mTopToolBar = (Toolbar)v.findViewById(R.id.detailToolbar);

            mTopToolBar.setTitleTextColor(Color.WHITE);
            mTopToolBar.setBackgroundColor(Color.WHITE);
            mTopToolBar.setTitle("");

            mBottomToolBar = (Toolbar)v.findViewById(R.id.bottomBar);

            mBottomToolBar.setTitleTextColor(Color.WHITE);
            mBottomToolBar.setBackgroundColor(Color.WHITE);
            mBottomToolBar.setTitle("");

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
        vHolder.shareButton.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
        vHolder.eventName.setText(events.get(position));
        vHolder.mTopToolBar.setTitle(events.get(position));


        vHolder.userIcon.setAdjustViewBounds(true);
        Picasso
                .with(adapContext)
                .load(mUserIconadr)
                .resize(41,41) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .into(vHolder.userIcon);
        //Picasso.with(adapContext).load(mPostImageadr).into(vHolder.imageFile);
        vHolder.imageFile.setAdjustViewBounds(true);
        Picasso
                .with(adapContext)
                .load(mPostImageadr)
                .resize(3500,3500) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .into(vHolder.imageFile);


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
