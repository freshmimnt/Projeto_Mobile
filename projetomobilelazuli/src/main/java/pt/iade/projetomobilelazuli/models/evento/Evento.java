package pt.iade.projetomobilelazuli.models.evento;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.user.Utilizador;

import java.time.*;

@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "even_id", nullable = false)
    private int id;

    @Column(name = "even_name", nullable = false)
    private String name;

    @Column(name = "even_data", nullable = false)
    private LocalDate date;

    @Column(name = "even_time", nullable = false)
    private LocalTime time;

    @Column(name = "even_participante", nullable = false)
    private int parti;

    @Column(name = "even_desc")
    private String desc;

    @Column(name = "is_finished", nullable = false)
    private boolean isFinished;

    @Column(name = "even_user_id", insertable=false, updatable=false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "even_user_id", referencedColumnName = "user_id")
    private Utilizador utilizador;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getParti() {
        return parti;
    }

    public void setParti(int parti) {
        this.parti = parti;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.userId = utilizador.getId();
    }
}
