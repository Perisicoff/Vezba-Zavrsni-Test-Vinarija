package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Vinarija;

public interface VinarijaService {

	Vinarija findOne(Long id);
	
	List<Vinarija> findAll();
}
