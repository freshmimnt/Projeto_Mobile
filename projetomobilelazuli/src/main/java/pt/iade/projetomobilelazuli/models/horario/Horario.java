package pt.iade.projetomobilelazuli.models.horario;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hor_id")
    private int id;

    @Column(name = "hor_date")
    private Date dateTime;

    @Column(name = "hor_hora_inicio")
    private LocalDateTime dateTime;

    @Column(name = "hor_hora_fim")
    private LocalDateTime dateTime;

    @Column(name = "hor_desc")
    private String desc;

    @Column(name = "hor_UC_id", insertable=false, updatable=false)
    private int UCId;

    @ManyToOne
    @JoinColumn(name = hor_UC_id", referencedColumnName = "UC_id")
    private UC uc;

    public Horario(){

    }

    public Horario(int id, Date dateTime, LocalDateTime dateTime, LocalDateTime dateTime, String desc, UC uc) {
        this.id = id;
        this.dateTime = dateTime;
        this.dateTime = dateTime;
        this.dateTime = dateTime;
        this.desc = desc;
        this.uc = uc;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
        this.UC = uc;
        this.UCId = uc.getId();
    }
}

