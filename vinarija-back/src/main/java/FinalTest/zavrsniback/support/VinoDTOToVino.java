package FinalTest.zavrsniback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Vino;
import FinalTest.zavrsniback.service.TipVinaService;
import FinalTest.zavrsniback.service.VinarijaService;
import FinalTest.zavrsniback.service.VinoService;
import FinalTest.zavrsniback.web.dto.VinoDTO;

@Component
public class VinoDTOToVino implements Converter<VinoDTO, Vino> {

	@Autowired
	private VinoService vinoService;

	@Autowired
	private TipVinaService tipVinaService;

	@Autowired
	private VinarijaService vinarijaService;

	@Override
	public Vino convert(VinoDTO vinoDTO) {
		Vino entity = null;

		if (vinoDTO.getId() == null) {
			entity = new Vino();
		} else {
			Vino VinoOptional = vinoService.findOne(vinoDTO.getId());
			if (VinoOptional != null) {
				entity = VinoOptional;
			}
		}

		if (entity != null) {
			entity.setIme(vinoDTO.getIme());
			entity.setCena(vinoDTO.getCena());
			entity.setGodinaProizvodnje(vinoDTO.getGodinaProizvodnje());
			entity.setDostupneFlase(vinoDTO.getDostupneFlase());
			entity.setOpis(vinoDTO.getOpis());
			entity.setTipVina(tipVinaService.findOne(vinoDTO.getTipVinaId()));
			entity.setVinarija(vinarijaService.findOne(vinoDTO.getVinarijaId()));

		}

		return entity;
	}

}
