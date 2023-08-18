package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Vino;
import FinalTest.zavrsniback.web.dto.VinoDTO;

@Component
public class VinoToVinoDTO implements Converter<Vino, VinoDTO> {

	@Override
	public VinoDTO convert(Vino vino) {
		VinoDTO vinoDTO = new VinoDTO();

		vinoDTO.setId(vino.getId());
		vinoDTO.setIme(vino.getIme());
		vinoDTO.setCena(vino.getCena());
		vinoDTO.setDostupneFlase(vino.getDostupneFlase());
		vinoDTO.setGodinaProizvodnje(vino.getGodinaProizvodnje());
		vinoDTO.setOpis(vino.getOpis());
		vinoDTO.setTipVinaId(vino.getTipVina().getId());
		vinoDTO.setNazivtipaVina(vino.getTipVina().getIme());
		vinoDTO.setVinarijaId(vino.getVinarija().getId());
		vinoDTO.setNazivVinarije(vino.getVinarija().getIme());

		return vinoDTO;
	}

	public List<VinoDTO> convert(List<Vino> vina) {
		List<VinoDTO> VinaDTOS = new ArrayList<>();

		for (Vino vino : vina) {
			VinaDTOS.add(convert(vino));
		}
		return VinaDTOS;
	}

}
