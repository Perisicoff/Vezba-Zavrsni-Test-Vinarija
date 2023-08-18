package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.TipVina;
import FinalTest.zavrsniback.repository.TipVinaRepository;
import FinalTest.zavrsniback.service.TipVinaService;

@Service
public class JPATipVinaService implements TipVinaService {

	@Autowired
	private TipVinaRepository tipVinaRepository;

	@Override
	public List<TipVina> findAll() {
		return tipVinaRepository.findAll();
	}

	@Override
	public TipVina findOne(Long id) {
		Optional<TipVina> opcijaTipVina = tipVinaRepository.findById(id);
		if (opcijaTipVina.isPresent()) {
			return opcijaTipVina.get();
		}
		return null;
	}

}
