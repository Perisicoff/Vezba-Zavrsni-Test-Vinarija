package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.TipVina;
import FinalTest.zavrsniback.web.dto.TipVinaDTO;

@Component
public class TipVinaToTipVinaDTO implements Converter<TipVina, TipVinaDTO> {

	@Override
	public TipVinaDTO convert(TipVina tipVina) {
		TipVinaDTO tipVinaDTO = new TipVinaDTO();

		tipVinaDTO.setId(tipVina.getId());
		tipVinaDTO.setIme(tipVina.getIme());

		return tipVinaDTO;
	}

	public List<TipVinaDTO> convert(List<TipVina> tipoviVina) {
		List<TipVinaDTO> TipVinaDTOS = new ArrayList<>();

		for (TipVina tipVina : tipoviVina) {
			TipVinaDTOS.add(convert(tipVina));
		}
		return TipVinaDTOS;
	}

}
