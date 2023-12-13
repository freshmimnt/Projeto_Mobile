package pt.iade.projetomobile.lazuli.models;
import jakarta.persistence.*;

@Entity
@Table(name = "UCC")
public class UCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ucc_id")
    private int id;

    @Column(name = "ucc_uc_id")
    private int uc_id;

    @Column(name = "ucc_cour_id")
    private int cour_id;

}
