package com.omicronrobotics.rafaelszuminski.localify;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by rafaelszuminski on 6/4/17.
 */

public class EventViewAdapter extends RecyclerView.Adapter{
    ArrayList<String> events; //Array
    public static Context adapContext;
    LayoutInflater layoutInflater;

    private static String mPostImageadr = "https://scontent.cdninstagram.com/t51.2885-15/e35/18949510_151178825425531_218754023098941440_n.jpg";
    private static String mUserIconadr = "https://pbs.twimg.com/profile_images/606585229034135553/2NqZJYQI.png";




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        ImageView imageFile;
        CircleImageView mCircleUserIcon;
        ImageButton shareButton;
        Toolbar mTopToolBar;
        Toolbar mBottomToolBar;
        TextView mEventInfo;




        public MyViewHolder(View v) {
            super(v);

//            eventName = (TextView) v.findViewById(R.id.eventName);
//            imageFile = (ImageView)v.findViewById(R.id.img_thumbnail);
            mCircleUserIcon = (CircleImageView)v.findViewById(R.id.profile_image);
//            shareButton = (ImageButton) v.findViewById(R.id.shareColorButton);
            mTopToolBar = (Toolbar)v.findViewById(R.id.detailToolbar);
            mEventInfo = (TextView)v.findViewById(R.id.eventInfo);

            imageFile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            //Static, will never change
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
        vHolder.mEventInfo.setText("brassmashbandWe have posters! Where should we put them up? #slo #slobrew #downtownslo #livemusic #pintnight #shareslo #calpoly #sanluisobispo #slocounty");

        Pattern tagMatcher = Pattern.compile("[#]+[A-Za-z0-9-_]+\\b");

        String url = "https://www.google.com/";
        //Attach Linkify to TextView
        vHolder.mEventInfo.setLinkTextColor(Color.argb(255,68,136,226));
        Linkify.addLinks(vHolder.mEventInfo, tagMatcher, url);

        /*
        https://github.com/hdodenhof/CircleImageView
        --------------------------------------------
        The ScaleType is always CENTER_CROP and you'll get an exception if you try to change it. This is (currently) by design as it's perfectly fine for profile images.
        Enabling adjustViewBounds is not supported as this requires an unsupported ScaleType
        If you use an image loading library like Picasso or Glide, you need to disable their fade animations to avoid messed up images. For Picasso use the noFade() option, for Glide use dontAnimate(). If you want to keep the fadeIn animation, you have to fetch the image into a Target and apply a custom animation yourself when receiving the Bitmap.
        Using a TransitionDrawable with CircleImageView doesn't work properly and leads to messed up images.
         */

        Picasso
                .with(adapContext)
                .load(mUserIconadr)
                .fit()
                .noFade()
                .into(vHolder.mCircleUserIcon);
        //Picasso.with(adapContext).load(mPostImageadr).into(vHolder.imageFile);
        vHolder.imageFile.setAdjustViewBounds(true);
        Picasso
                .with(adapContext)
                .load(mPostImageadr)
                .resize(700, 700) // seems like these values should be in res/values/dimens.xml file
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
