package pt.iade.projetomobile.lazuli.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {

    public static ArrayList<Horario> horarioArrayList = new ArrayList<>();

    public static ArrayList<Horario> horariosPorDia(LocalDate date){
        ArrayList<Horario> horarios = new ArrayList<>();
        for(Horario horario : horarioArrayList){
            if (horario.getDate().equals(date))
                horarios.add(horario);
        }
        return horarios;
    }

    private int id;
    private LocalDate date;
    private LocalTime time1;
    private LocalTime time2;
    private String desc;

    public Horario(int id, LocalDate date, LocalTime time1, LocalTime time2, String desc) {
        this.id = id;
        this.date = date;
        this.time1 = time1;
        this.time2 = time2;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime1() {
        return time1;
    }

    public void setTime1(LocalTime time1) {
        this.time1 = time1;
    }

    public LocalTime getTime2() {
        return time2;
    }

    public void setTime2(LocalTime time2) {
        this.time2 = time2;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
