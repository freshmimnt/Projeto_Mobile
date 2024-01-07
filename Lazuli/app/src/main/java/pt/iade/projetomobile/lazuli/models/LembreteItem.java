package pt.iade.projetomobile.lazuli.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import pt.iade.projetomobile.lazuli.adapters.CalendarJsonAdapter;
import pt.iade.projetomobile.lazuli.utilities.WebRequest;

public class LembreteItem implements Serializable {

    private int id;

    private String name;
    @JsonAdapter(CalendarJsonAdapter.class)
    private Calendar date;

    private Date time;

    private String desc;

    private boolean isFinished;

    private Agenda agenda;

    public LembreteItem(){
        this(0, false, "", new GregorianCalendar(),new Date() ,"");
    }

    public LembreteItem(int id, boolean isFinished, String name, Calendar date,
                        Date time, String desc) {
        this.id = id;
        this.isFinished = isFinished;
        this.name = name;
        this.date = date;
        this.time = time;
        this.desc = desc;

    }

    public static ArrayList<LembreteItem> List(){

        ArrayList<LembreteItem> items = new ArrayList<LembreteItem>();

        return items;
    }

    public static LembreteItem GetById(int id){
        return new LembreteItem(id, false, "Alloy", new GregorianCalendar(), new Date(), "Shine");
    }

    public void save(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    if (id == 0) {
                        WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/lembrete/save"));
                        String response = request.performPostRequest(LembreteItem.this);

                        LembreteItem responseItem = new Gson().fromJson(response, LembreteItem.class);
                        id = responseItem.getId();
                    } else {
                        WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/lembrete/update/" + id));
                        request.performPostRequest(LembreteItem.this);
                    }
                } catch (Exception e) {
                    Log.e("LembreteItem", e.toString());
                }
            }
        });
        thread.start();
    }

    public void delete(){

    }

    public int getId() {
        return id;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        this.isFinished = finished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
