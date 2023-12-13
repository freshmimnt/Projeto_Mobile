package pt.iade.projetomobile.lazuli.models;

import java.sql.Time;
import java.util.Date;

public class Horario {
    private int id;
    private Date horaData;
    private Time horaInicio;
    private Time horaFim;
    private String desc;

    public Horario(int id, Date horaData, Time horaInicio, Time horaFim, String desc) {
        this.id = id;
        this.horaData = horaData;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public Date getHoraData() {
        return horaData;
    }

    public void setHoraData(Date horaData) {
        this.horaData = horaData;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
