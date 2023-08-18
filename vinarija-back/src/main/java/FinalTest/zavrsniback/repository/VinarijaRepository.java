package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Vinarija;

@Repository
public interface VinarijaRepository extends JpaRepository<Vinarija, Long> {

}
