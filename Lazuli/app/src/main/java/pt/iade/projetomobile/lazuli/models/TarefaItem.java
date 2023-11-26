package pt.iade.projetomobile.lazuli.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class TarefaItem implements Serializable {
    private int id;
    private boolean done;
    private String title;
    private Calendar date;
    private Date time;
    private String description;
    public TarefaItem(){

        this(0, false, "", new GregorianCalendar(),new Date() ,"");
    }
    public TarefaItem(int id, boolean done, String title, Calendar date, Date time, String description){
        this.id = id;
        this.done = done;
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public static ArrayList<TarefaItem> List(){
        ArrayList<TarefaItem> items = new ArrayList<>();
        items.add(new TarefaItem(1, true, "First", new GregorianCalendar(), new Date(), "Second"));

        return items;
    }

    public static TarefaItem GetById(int id){

        return new TarefaItem(id, false, "Fondue", new GregorianCalendar(), new Date(), "Slow");
    }

    public void save() {
        // TODO: Send the object's data to our web server and update the database there.

        if (id == 0) {

            id = new Random().nextInt(1000) + 1;

        } else {

        }
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
