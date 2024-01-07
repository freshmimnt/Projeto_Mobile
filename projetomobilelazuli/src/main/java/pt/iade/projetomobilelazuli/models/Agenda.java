package pt.iade.projetomobilelazuli.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agen_id", nullable = false)
    private int id;

    @Column(name = "agen_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "agen_user_id", referencedColumnName = "user_id")
    private User user;

    public Agenda(){
    }

    public Agenda(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
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

    public User getUtilizador() {
        return user;
    }

    public void setUtilizador(User user) {
        this.user = user;
    }
}
