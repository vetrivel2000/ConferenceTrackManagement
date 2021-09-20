package event;

import pojo.Event;
import pojo.Track;

import java.util.ArrayList;

public class EventHandler {
    ArrayList<String> unFilled=new ArrayList<>();

    int hour=9;
    int minute=0;
    String session="AM";
    public void scheduleEvent(ArrayList<String> list)
    {
        Track track = new Track();
        int h=9;
        int mm=0;
        for (String eventName : list) {
            int mins=calculateMinute(eventName);
            h+=mins/60;
            mm+=mins%60;
            if(mm>=60)
            {
                mm-=60;
                h+=1;
            }
            if (h < 12) {
                Event object=setEvent(eventName);
                track.getMorning().add(object);
            }
            else if(h==12)
            {
                unFilled.add(eventName);
                h=hour;
                mm=minute;
            }
        }
        h=13;
        mm=0;
        hour=1;
        minute=0;
        session="PM";
        for (String s : unFilled) {
            int mins=calculateMinute(s);
            h+=mins/60;
            mm+=mins%60;
            if(mm>=60)
            {
                mm-=60;
                h+=1;
            }
            System.out.println(h+"hoursssss");
            if (h < 17) {
                Event object=setEvent(s);
                track.getEvening().add(object);
            }
            //                h=hour;
            //                mm=minute;

        }
        System.out.println();
        System.out.println();
        ArrayList<Event> morning=track.getMorning();
        ArrayList<Event> evening= track.getEvening();
        for (Event event : morning) {
            System.out.println(event);
        }
        System.out.println("12:0PM Lunch 60mins");
        for (Event event : evening) {
            System.out.println(event);
        }
        System.out.println("5:0PM NetworkingEvent");
        hour=9;
        minute=0;
        session="AM";
        scheduleEvent(unFilled);
    }
    public Event setEvent(String eventName)
    {
        int minutes;
        Event object = new Event();
        object.setEventName(eventName);
        minutes=calculateMinute(eventName);
        System.out.println(minutes+"mins");
        object.setMinute(minutes);
        String time = hour + ":" + minute + session;
        object.setTime(time);
        timeCheck(minutes);
        return object;
    }
    public void timeCheck(int min)
    {
        hour += min / 60;
        minute += min % 60;
        if (minute >= 60) {
            minute -= 60;
            hour += 1;
        }
        if(hour>12)
        {
            hour-=12;
        }
    }
    public int calculateMinute(String eventName)
    {
        int m=0;
        String[] events = eventName.split(" ");
        char[] timeArray = events[events.length - 1].toCharArray();
        if (events[events.length - 1].equals("lightning")) {
            m = 5;
        } else {
            for (char c : timeArray) {
                if (c >= '0' && c <= '9') {
                    m =  (m * 10) + (c - '0') ;
                }
            }
        }
        return m;
    }
}