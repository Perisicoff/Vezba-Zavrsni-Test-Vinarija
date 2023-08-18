package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.TipVina;

public interface TipVinaService {

	TipVina findOne(Long id);
	
	List<TipVina> findAll();
}
