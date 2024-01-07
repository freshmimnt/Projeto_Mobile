package pt.iade.projetomobile.lazuli.models;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import pt.iade.projetomobile.lazuli.adapters.CalendarJsonAdapter;
import pt.iade.projetomobile.lazuli.utilities.WebRequest;

public class TarefaItem implements Serializable {
    private int id;
    private boolean done;
    private String title;
    @JsonAdapter(CalendarJsonAdapter.class)
    private Calendar date;
    private Date time;
    private String description;
    Agenda agenda;

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

        return items;
    }

    public static TarefaItem GetById(int id){

        return new TarefaItem(id, false, "Fondue", new GregorianCalendar(), new Date(), "Slow");
    }

    public void save() {
        // TODO: Send the object's data to our web server and update the database there.

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    if (id == 0) {
                        WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/tarefa/save"));
                        String response = request.performPostRequest(TarefaItem.this);

                        TarefaItem responseItem = new Gson().fromJson(response, TarefaItem.class);
                        id = responseItem.getId();
                    } else {
                        WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/tarefa/update/" + id));
                        request.performPostRequest(TarefaItem.this);
                    }
                } catch (Exception e) {
                    Log.e("TarefaItem", e.toString());
                }
            }
        });
        thread.start();
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
