package tr.gov.adalet.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.gov.adalet.demo.entities.MahkemeDbo;

import java.util.List;
import java.util.Optional;

public interface IMahkemeRepo extends JpaRepository<MahkemeDbo, Integer> {


    Optional<MahkemeDbo> findByMahkemeId(int id);

    List<MahkemeDbo> findByMahkemeIlKod(int mahkemeIlKod);

    List<MahkemeDbo> findByMahkemeIlKodAndMahkemeTip(int mahkemeIlKod, int mahkemeTip);

    List<MahkemeDbo> findBy();

    @Query("FROM MahkemeDbo WHERE mahkemeYil > 2020")  //hibernate
  //  @Query(value = "Select * from Mahkeme where MahkemeTarih> 2020", nativeQuery = true) //normal sql
    List<MahkemeDbo> findYeniMahkemeler();

}
