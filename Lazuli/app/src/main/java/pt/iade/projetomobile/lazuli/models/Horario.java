package pt.iade.projetomobile.lazuli.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {

    public static ArrayList<Horario> horarioArrayList = new ArrayList<>();

    public static ArrayList<Horario> horariosPorDia(LocalDate date){
        ArrayList<Horario> horarios = new ArrayList<>();
        for(Horario horario : horarioArrayList){
            if (horario.getHoraData().equals(date))
                horarios.add(horario);
        }
        return horarios;
    }

    private int id;
    private LocalDate horaData;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String desc;

    public Horario(int id, LocalDate horaData, LocalTime horaInicio, LocalTime horaFim, String desc) {
        this.id = id;
        this.horaData = horaData;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public LocalDate getHoraData() {
        return horaData;
    }

    public void setHoraData(LocalDate horaData) {
        this.horaData = horaData;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
