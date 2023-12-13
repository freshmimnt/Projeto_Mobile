package pt.iade.projetomobile.lazuli.models;
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


}
