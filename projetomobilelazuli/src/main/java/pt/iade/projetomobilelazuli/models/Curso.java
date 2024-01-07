package pt.iade.projetomobilelazuli.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cour_id", nullable = false)
    private int id;

    @Column(name = "cour_name", nullable = false)
    private String name;

    public Curso() {
    }

    public Curso(int id, String name) {
        this.id = id;
        this.name = name;
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

}

