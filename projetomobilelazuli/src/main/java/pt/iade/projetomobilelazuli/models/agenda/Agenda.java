package pt.iade.projetomobilelazuli.models.agenda;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.user.Utilizador;

@Entity
@Table(name = "Agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agen_id", nullable = false)
    private int id;

    @Column(name = "agen_name", nullable = false)
    private String name;

    @Column(name = "agen_user_id", insertable=false, updatable=false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "agen_user_id", referencedColumnName = "user_id")
    private Utilizador utilizador;

    public Agenda(){
    }

    public Agenda(int id, String name, Utilizador utilizador) {
        this.id = id;
        this.name = name;
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

    public int getUserId() {
        return userId;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.userId = utilizador.getId();
    }
}
