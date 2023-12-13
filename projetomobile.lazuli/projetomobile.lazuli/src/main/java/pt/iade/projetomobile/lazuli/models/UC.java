package pt.iade.projetomobile.lazuli.models;
import jakarta.persistence.*;

@Entity
@Table(name = "UC")
public class UC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uc_ic")
    private int id;

    @Column(name = "uc_name", nullable = false)
    private String name;

    @Column(name = "uc_sala")
    private String sala;

    @Column(name = "uc_prof")
    private String prof;

    @Column(name = "uc_desc")
    private String desc;

    @Column(name = "media_nota")
    private String media;
}
