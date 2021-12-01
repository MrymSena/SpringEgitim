package tr.gov.adalet.demo.model.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.gov.adalet.demo.entities.MahkemeDbo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mahkeme {

    private int mahkemeId;
    private String mahkemeAd;


    public Mahkeme(MahkemeDbo mahkemeDbo){
        this.mahkemeId= mahkemeDbo.getMahkemeId();
        this.mahkemeAd= mahkemeDbo.getMahkemeAd();
    }
}
