package tr.gov.adalet.demo.model.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.gov.adalet.demo.mappers.EnAzBirDeger;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnAzBirDeger(fields = {"mahkemeAd", "mahkemeIlKod"})
public class MahkemeInsertRequest {

    private String mahkemeAd;
    @NotNull
    @Min(value=1, message="Il kodu hatalı")
    @Max(value=81, message="Il kodu 81den büyük olamaz")
    private int mahkemeIlKod;

    @NotNull
    @Min(value=1, message="Mahkeme tipi 1 den küçük olamaz")
    private int mahkemeTip;

}
