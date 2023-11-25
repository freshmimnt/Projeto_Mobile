package pt.iade.projetomobile.lazuli.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgendaItem implements Serializable {
    private int id;
    private boolean done;
    private String title;
    private Calendar date;
    private Date time;
    private String description;
    public AgendaItem(){
        this(0, false, "", new GregorianCalendar(),new Date() ,"");
    }
    public AgendaItem(int id, boolean done, String title, Calendar date, Date time, String description){
        this.id = id;
        this.done = done;
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public static ArrayList<AgendaItem> List(){
        ArrayList<AgendaItem> items = new ArrayList<>();
        items.add(new AgendaItem(1, false, "First", new GregorianCalendar(), new Date(), "Second"));

        return items;
    }

    public static AgendaItem GetById(int id){

        return new AgendaItem(id, false, "Fondue", new GregorianCalendar(), new Date(), "Slow");
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
