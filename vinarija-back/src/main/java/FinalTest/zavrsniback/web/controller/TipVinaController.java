package FinalTest.zavrsniback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.TipVina;
import FinalTest.zavrsniback.service.TipVinaService;
import FinalTest.zavrsniback.support.TipVinaToTipVinaDTO;
import FinalTest.zavrsniback.web.dto.TipVinaDTO;

@RestController
@RequestMapping(value = "/api/tipovi", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipVinaController {

	@Autowired
	private TipVinaService tipVinaService;

	@Autowired
	private TipVinaToTipVinaDTO tipVinaDTO;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<TipVinaDTO>> get() {
		List<TipVina> tipoviVina = tipVinaService.findAll();
		return new ResponseEntity<>(tipVinaDTO.convert(tipoviVina), HttpStatus.OK);
	}
}
