package com.omicronrobotics.rafaelszuminski.localify; /**
 * Created by dkfrayne on 6/4/17.
 */

import android.location.Location;
import android.widget.TextView;
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
            fakeEvents[i] = "Event " + (i+1) + "\n\n";
        }
        return fakeEvents;
    }
    
    public static void post(String eventName) {
        eventList.add(eventName);
    }
    
    
}
