package tr.gov.adalet.demo.services;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tr.gov.adalet.demo.entities.MahkemeDbo;
import tr.gov.adalet.demo.model.requests.MahkemeInsertRequest;
import tr.gov.adalet.demo.model.responses.Mahkeme;
import tr.gov.adalet.demo.repos.IMahkemeRepo;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MahkemeService {

    final IMahkemeRepo iMahkemeRepo;

    public MahkemeService(IMahkemeRepo iMahkemeRepo) {
        this.iMahkemeRepo = iMahkemeRepo;
    }


    public Mahkeme getMahkemeById(int id){
        var mahkeme = iMahkemeRepo.findByMahkemeId(id);
        if(mahkeme.isPresent()){
            return new Mahkeme(mahkeme.get());

        }
        return new Mahkeme();
    }

    public List<Mahkeme> getByIlKod(int ilkKod){
        var mahkemeler = iMahkemeRepo.findByMahkemeIlKod(ilkKod);
        var res = new ArrayList<Mahkeme>();
        for(MahkemeDbo dbo : mahkemeler){
            res.add(new Mahkeme(dbo));
        }
        return res;
    }

    public List<Mahkeme> getByIlKodAndTip(int ilkKod, int tip){
        var mahkemeler = iMahkemeRepo.findByMahkemeIlKodAndMahkemeTip(ilkKod, tip);
        var res = new ArrayList<Mahkeme>();
        for(MahkemeDbo dbo : mahkemeler){
            res.add(new Mahkeme(dbo));
        }
        return res;
    }

    public String add(MahkemeInsertRequest request){
        var mahkemeDbo = new MahkemeDbo();
        mahkemeDbo.setMahkemeAd(request.getMahkemeAd());
        mahkemeDbo.setMahkemeTip(request.getMahkemeTip());
        mahkemeDbo.setMahkemeIlKod(request.getMahkemeIlKod());
        mahkemeDbo.setMahkemeYil(LocalDate.now().getYear());
        iMahkemeRepo.save(mahkemeDbo);
        return "OK";
    }

}
