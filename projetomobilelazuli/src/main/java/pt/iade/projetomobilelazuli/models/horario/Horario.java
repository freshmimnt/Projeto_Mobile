package pt.iade.projetomobilelazuli.models.horario;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import pt.iade.projetomobilelazuli.models.uc.UC;

@Entity
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hor_id")
    private int id;

    @Column(name = "hor_date")
    private Date date;

    @Column(name = "hor_hora_inicio")
    private LocalTime time1;

    @Column(name = "hor_hora_fim")
    private LocalTime time2;

    @Column(name = "hor_desc")
    private String desc;

    @Column(name = "hor_UC_id", insertable=false, updatable=false)
    private int UCId;



    @ManyToOne
    @JoinColumn(name = "hor_UC_id", referencedColumnName = "UC_id")
    private UC uc;

    public Horario(){

    }

    public Horario(int id, Date date, LocalTime time1, LocalTime time2, String desc, int UCId, UC uc) {
        this.id = id;
        this.date = date;
        this.time1 = time1;
        this.time2 = time2;
        this.desc = desc;
        this.uc = uc;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public void setUtilizador(UC uc) {
        this.uc = uc;
        this.UCId = uc.getId();
    }
}

