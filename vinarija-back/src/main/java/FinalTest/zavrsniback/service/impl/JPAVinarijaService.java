package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Vinarija;
import FinalTest.zavrsniback.repository.VinarijaRepository;
import FinalTest.zavrsniback.service.VinarijaService;

@Service
public class JPAVinarijaService implements VinarijaService {

	@Autowired
	private VinarijaRepository vinarijaRepository;

	@Override
	public List<Vinarija> findAll() {
		return vinarijaRepository.findAll();
	}

	@Override
	public Vinarija findOne(Long id) {
		Optional<Vinarija> opcijaVinarija = vinarijaRepository.findById(id);
		if (opcijaVinarija.isPresent()) {
			return opcijaVinarija.get();
		}
		return null;
	}

}
