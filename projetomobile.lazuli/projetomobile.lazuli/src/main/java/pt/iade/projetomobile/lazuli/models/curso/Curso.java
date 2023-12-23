package pt.iade.projetomobile.lazuli.models.curso;
import jakarta.persistence.*;

@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cour_id")
    private int id;

    @Column(name = "cour_name", nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
