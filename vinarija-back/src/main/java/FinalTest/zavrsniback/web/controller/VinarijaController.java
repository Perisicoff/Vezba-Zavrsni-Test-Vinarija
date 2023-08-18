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

import FinalTest.zavrsniback.model.Vinarija;
import FinalTest.zavrsniback.service.VinarijaService;
import FinalTest.zavrsniback.support.VinarijaToVinarijaDTO;
import FinalTest.zavrsniback.web.dto.VinarijaDTO;

@RestController
@RequestMapping(value = "/api/vinarije", produces = MediaType.APPLICATION_JSON_VALUE)
public class VinarijaController {

	@Autowired
	private VinarijaService vinarijaService;

	@Autowired
	private VinarijaToVinarijaDTO vinarijaDTO;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<VinarijaDTO>> get() {
		List<Vinarija> vinarije = vinarijaService.findAll();
		return new ResponseEntity<>(vinarijaDTO.convert(vinarije), HttpStatus.OK);
	}
}
