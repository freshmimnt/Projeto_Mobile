package pt.iade.projetomobile.lazuli.models.agenda;

import jakarta.persistence.*;
import pt.iade.projetomobile.lazuli.models.user.Utilizador;

@Entity
@Table(name = "Agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agen_id")
    private int id;

    @Column(name = "agen_name")
    private String name;

    @Column(name = "agen_user_id", insertable = false, updatable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "agen_user_id", referencedColumnName = "user_id")
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

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.userId = utilizador.getId();
    }

}
