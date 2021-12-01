package tr.gov.adalet.demo.model.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MahkemeResponse extends BaseResponse {

    private Mahkeme mahkeme;
    private List<String> mahkemeler;


}
