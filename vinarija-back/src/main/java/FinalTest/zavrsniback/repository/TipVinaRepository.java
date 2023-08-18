package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.TipVina;

@Repository
public interface TipVinaRepository extends JpaRepository<TipVina, Long> {

}
