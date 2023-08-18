package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Vinarija;
import FinalTest.zavrsniback.web.dto.VinarijaDTO;

@Component
public class VinarijaToVinarijaDTO implements Converter<Vinarija, VinarijaDTO> {

	@Override
	public VinarijaDTO convert(Vinarija vinarija) {
		VinarijaDTO vinarijaDTO = new VinarijaDTO();

		vinarijaDTO.setId(vinarija.getId());
		vinarijaDTO.setIme(vinarija.getIme());
		vinarijaDTO.setGodinaOsnivanja(vinarija.getGodinaOsnivanja());

		return vinarijaDTO;
	}

	public List<VinarijaDTO> convert(List<Vinarija> vinarije) {
		List<VinarijaDTO> vinarijaDTOS = new ArrayList<>();

		for (Vinarija vinarija : vinarije) {

			vinarijaDTOS.add(convert(vinarija));
		}

		return vinarijaDTOS;
	}
}
