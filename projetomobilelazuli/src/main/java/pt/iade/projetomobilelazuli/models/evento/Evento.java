package pt.iade.projetomobilelazuli.models.evento;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.user.Utilizador;

import java.time.LocalDateTime;

@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "even_id")
    private int id;

    @Column(name = "even_name")
    private String name;

    @Column(name = "even_date")
    private LocalDateTime dateTime;

    @Column(name = "even_participante")
    private int parti;

    @Column(name = "even_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "even_user_id", insertable=false, updatable=false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "even_user_id", referencedColumnName = "user_id")
    private Utilizador utilizador;

    public Evento(){

    }

    public Evento(int id, String name, LocalDateTime dateTime, int parti, String desc, boolean isFinished, Utilizador utilizador) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.parti = parti;
        this.desc = desc;
        this.isFinished = isFinished;
        this.utilizador = utilizador;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
