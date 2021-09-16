import event.EventHandler;
import pojo.Event;
import pojo.Track;

import java.util.ArrayList;
import java.util.Scanner;

public class EventRunner {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        EventHandler handler= new EventHandler();
        ArrayList<String> events= new ArrayList<>();
        String eventName="";
        do{
            eventName=scan.nextLine();
            if(!(eventName.equals("end"))) {
                events.add(eventName);
            }
        }while (!(eventName.equals("end")));
        handler.scheduleEvent(events);
    }
}
