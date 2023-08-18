package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Vino;
import FinalTest.zavrsniback.repository.VinoRepository;
import FinalTest.zavrsniback.service.VinoService;

@Service
public class JPAVinoService implements VinoService {

	@Autowired
	private VinoRepository vinoRepository;

	@Override
	public Vino findOne(Long id) {
		Optional<Vino> opcijaVino = vinoRepository.findById(id);
		if (opcijaVino.isPresent()) {
			return opcijaVino.get();

		}
		return null;
	}

	@Override
	public List<Vino> findAll() {
		return vinoRepository.findAll();
	}

	@Override
	public Page<Vino> findAll(int brojStranice) {
		return vinoRepository.findAll(PageRequest.of(brojStranice, 3));
	}

	@Override
	public Vino save(Vino vino) {
		return vinoRepository.save(vino);
	}

	@Override
	public Vino update(Vino vino) {
		return vinoRepository.save(vino);
	}

	@Override
	public Vino delete(Long id) {
		Vino vino = findOne(id);
		if (vino != null) {
			vinoRepository.deleteById(id);
			return vino;
		}

		return null;
	}

	@Override
	public Page<Vino> search(Long vinarijaId, String nazivVina, int brojStranice) {
		return vinoRepository.search(vinarijaId, nazivVina, PageRequest.of(brojStranice, 2));
	}

	@Override
	public Vino nabavka(Vino vino, int kolicina) {
		Vino vinoIzmena = findOne(vino.getId());
		if (vinoIzmena != null) {
			int staroStanje = vinoIzmena.getDostupneFlase();
			int novoStanje = staroStanje + kolicina;
			vinoIzmena.setDostupneFlase(novoStanje);
			vinoRepository.save(vinoIzmena);
			return vinoIzmena;
		}
		return null;
	}

	@Override
	public Vino kupovina(Vino vino, int kolicina) {
		Vino vinoIzmena = findOne(vino.getId());
		if (vinoIzmena != null) {
			int staroStanje = vinoIzmena.getDostupneFlase();
			int novoStanje = staroStanje - kolicina;
			vinoIzmena.setDostupneFlase(novoStanje);
			vinoRepository.save(vinoIzmena);
			return vinoIzmena;
		}
		return null;
	}

}
