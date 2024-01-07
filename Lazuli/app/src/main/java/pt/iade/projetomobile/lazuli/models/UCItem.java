package pt.iade.projetomobile.lazuli.models;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.utilities.WebRequest;

public class UCItem implements Serializable{

    private int id;
    private String name;
    private String sala;
    private String prof;
    private String desc;
    private Curso curso;
    private User user;

    public UCItem(){
        this(0, "","","","");
    }

    public UCItem(int id, String name, String sala, String prof, String desc){
        this.id = id;
        this.name = name;
        this.sala = sala;
        this.prof = prof;
        this.desc = desc;
    }


    public static ArrayList<UCItem> List(){
        ArrayList<UCItem> items = new ArrayList<UCItem>();
        return items;
    }

    public static void GetById(int id, GetByIdResponse response){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/uc/get/" + id));
                    String rep = request.performGetRequest();

                    UCItem item = new Gson().fromJson(rep, UCItem.class);
                    response.response(item);
                }catch (Exception e){
                    Log.e("UcItem", e.toString());
                }
            }
        });

    }

    public void save(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (id == 0) {
                        WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/uc/save"));
                        String response = request.performPostRequest(UCItem.this);

                        UCItem responseItem = new Gson().fromJson(response, UCItem.class);
                        id = responseItem.getId();
                    } else {

                        WebRequest request = new WebRequest(new URL(WebRequest.LOCALHOST + "/uc/update/" + id));
                        request.performPostRequest(UCItem.class);

                    }
                }catch (Exception e){
                    Log.e("UcItem", e.toString());
                }
            }
        });
        thread.start();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUcName() {
        return name;
    }

    @NonNull
    @Override
    public String toString(){
        return name;
    }

    public interface GetByIdResponse{
        public void response(UCItem ucItem);
    }


}
