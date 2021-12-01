package tr.gov.adalet.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Mahkeme")
public class MahkemeDbo {

    @Id
    @Column(name="MahkemeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mahkemeId;
    @Column(name="MahkemeAd")
    private String mahkemeAd;
    @Column(name="MahkemeIlKod")
    private int mahkemeIlKod;
    @Column(name="MahkemeTip")
    private int mahkemeTip;
    @Column(name="MahkemeTarih")
    private int mahkemeYil;


}
