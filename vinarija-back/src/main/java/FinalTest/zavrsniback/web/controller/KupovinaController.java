package FinalTest.zavrsniback.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Vino;
import FinalTest.zavrsniback.service.VinoService;
import FinalTest.zavrsniback.web.dto.KolicinaDTO;
import FinalTest.zavrsniback.web.dto.VinoDTO;

@RestController
@RequestMapping(value = "/api/kupovina", produces = MediaType.APPLICATION_JSON_VALUE)
public class KupovinaController {

	@Autowired
	private VinoService vinoService;

	@PreAuthorize("hasRole('ROLE_KORISNIK')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDTO> nabavkaVina(@PathVariable Long id, @Valid @RequestBody KolicinaDTO kolicinaDTO) {
		Vino vino = vinoService.findOne(id);

		if (vino == null || vino.getVinarija() == null || vino.getTipVina() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		int kolicina = kolicinaDTO.getKolicinaZaIzmenu();
		vinoService.kupovina(vino, kolicina);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
