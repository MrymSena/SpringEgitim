package tr.gov.adalet.demo.controllers;

import org.springframework.web.bind.annotation.*;
import tr.gov.adalet.demo.model.requests.MahkemeInsertRequest;
import tr.gov.adalet.demo.model.requests.TestRequest;
import tr.gov.adalet.demo.model.responses.Mahkeme;
import tr.gov.adalet.demo.model.responses.MahkemeResponse;
import tr.gov.adalet.demo.services.MahkemeService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/mahkeme")
public class MahkemeController {

    final MahkemeService mahkemeService;

    public MahkemeController(MahkemeService mahkemeService) {
        this.mahkemeService = mahkemeService;
    }

    @GetMapping("")
    private String get(){
        return "OK";
    }


    private List<String> getIller(){
        var result = new ArrayList<String>();
        result.add("Ankara");
        result.add("İstanbul");
        return result;
    }

    @GetMapping("/list")
    private List<String> getIllist(){
        return getIller();
    }

    @GetMapping("/{id}")
    private String getIlDetay(@PathVariable  int id){
        return getIller().get(id);
    }

    @GetMapping("/{id}/")
    private String getIlDetayMultiple(@PathVariable  int id, @RequestParam String mesaj){
        return getIller().get(id)+ " "+mesaj;
    }

    @GetMapping("/isim")   //bu şekilde çalışmaz. getler object almıyor.
    private String getIsim(@RequestParam  TestRequest request){
        return "Hoşgeldiniz" + request.getKod()+" "+request.getMesaj();
    }
    @PostMapping("/isim")
    private String getIsimPost(@RequestBody TestRequest request){
        return "Hoşgeldiniz " + request.getKod()+" "+request.getMesaj();
    }

    @PostMapping("/mahkemeler")
    private MahkemeResponse getMahkemeList(){
        MahkemeResponse mahkemeResponse = new MahkemeResponse();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        mahkemeResponse.setMahkemeler(list);
        mahkemeResponse.setBasari(true);
        return mahkemeResponse;
    }

    @GetMapping("/detay")
    private MahkemeResponse getMahkemeList(@RequestParam int id){
        MahkemeResponse mahkemeResponse = new MahkemeResponse();
        var mahkeme = mahkemeService.getMahkemeById(id);

        mahkemeResponse.setBasari(true);
        mahkemeResponse.setHataMesaj("");
        mahkemeResponse.setMahkeme(mahkeme);
        return mahkemeResponse;
    }

    @GetMapping("/ilkKod")
    private List<Mahkeme> getByIlKod(@RequestParam int ilKod){
        return mahkemeService.getByIlKod(ilKod);
    }

    @GetMapping("ilKodAndTip")
    private List<Mahkeme> getByIlkKodAndTip(@RequestParam int ilKod, @RequestParam int tip){
        return mahkemeService.getByIlKodAndTip(ilKod,tip);
    }

    @PostMapping("addMahkeme")
    private String addMahkeme(@Valid @RequestBody MahkemeInsertRequest mahkemeInsertRequest){
        return mahkemeService.add(mahkemeInsertRequest);
    }
}
