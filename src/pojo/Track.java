package pojo;

import java.util.ArrayList;

public class Track {
    private ArrayList<Event> morning = new ArrayList<>();
    private ArrayList<Event> evening = new ArrayList<>();

    public ArrayList<Event> getMorning() {
        return morning;
    }

    public void setMorning(ArrayList<Event> morning) {
        this.morning = morning;
    }

    public ArrayList<Event> getEvening() {
        return evening;
    }

    public void setEvening(ArrayList<Event> evening) {
        this.evening = evening;
    }

    @Override
    public String toString() {
        return "Track{" +
                "morning=" + morning +
                ", evening=" + evening +
                '}';
    }
}
