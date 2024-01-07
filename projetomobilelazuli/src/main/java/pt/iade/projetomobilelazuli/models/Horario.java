package pt.iade.projetomobilelazuli.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hor_id", nullable = false)
    private int id;

    @Column(name = "hor_data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Column(name = "hor_hora_inicio")
    private LocalTime time1;

    @Column(name = "hor_hora_fim")
    private LocalTime time2;

    @Column(name = "hor_desc")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "hor_UC_id", referencedColumnName = "UC_id")
    private UC uc;

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

    public UC getUC() {
        return uc;
    }

    public void setUc(UC uc) {
        this.uc = uc;
    }

}

