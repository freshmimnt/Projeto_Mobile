package pt.iade.projetomobile.lazuli.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import pt.iade.projetomobile.lazuli.models.Curso;

public class TesteItem implements Serializable {

    private int id;
    private boolean done;
    private String title;
    private Calendar date;
    private Date time;
    private String description;
    Curso curso;

    public TesteItem(){

        this(0, false, "", new GregorianCalendar(),new Date() ,"");
    }

    public TesteItem(int id, boolean done, String title, Calendar date, Date time, String description){
        this.id = id;
        this.done = done;
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public static ArrayList<TesteItem> List(){
        ArrayList<TesteItem> items = new ArrayList<>();
        items.add(new TesteItem(1, false, "F", new GregorianCalendar(), new Date(), "S"));

        return items;
    }

    public static TesteItem GetById(int id){
        return new TesteItem(id,false, "Fan", new GregorianCalendar(), new Date(), "SlowMow");

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
