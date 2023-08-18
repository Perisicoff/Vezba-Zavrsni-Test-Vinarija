package FinalTest.zavrsniback.service;

import java.util.List;

import org.springframework.data.domain.Page;

import FinalTest.zavrsniback.model.Vino;

public interface VinoService {

	Vino findOne(Long id);

	List<Vino> findAll();

	Page<Vino> findAll(int brojStranice);
	
	Page<Vino> search(Long vinarijaId, String nazivVina, int brojStranice);

	Vino save(Vino vino);
	
	Vino update(Vino vino);
	
	Vino nabavka(Vino vino, int kolicina);
	
	Vino kupovina(Vino vino, int kolicina);

	Vino delete(Long id);
}
