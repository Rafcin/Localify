package com.omicronrobotics.rafaelszuminski.localify; /**
 * Created by dkfrayne on 6/4/17.
 */

import android.location.Location;

import java.util.ArrayList;


public class LocalEvents {

    private static ArrayList<String> eventList;

    public static String[] getLocalEvents(Location location) {
        String[] events = new String[eventList.size()];
        for(int i = 0; i < events.length; i++) {
            events[i] = eventList.get(i);
        }
        return events;
    }

    public static String[] getFakeLocalEvents(int numOfEvents) {
        String[] fakeEvents = new String[numOfEvents];
        for(int i = 0; i < numOfEvents; i++) {
            fakeEvents[i] = "\nEvent " + (i+1) + "\n";
        }
        return fakeEvents;
    }

    public static String[] getImgURLs() {
        
        return null;
    }
    
    public static void addEvent(String eventName, String imgURL) {
        eventList.add(eventName);
    }


}