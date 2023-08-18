package FinalTest.zavrsniback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Vino;
import FinalTest.zavrsniback.service.VinoService;
import FinalTest.zavrsniback.support.VinoDTOToVino;
import FinalTest.zavrsniback.support.VinoToVinoDTO;
import FinalTest.zavrsniback.web.dto.KolicinaDTO;
import FinalTest.zavrsniback.web.dto.VinoDTO;

@RestController
@RequestMapping(value = "/api/vina", produces = MediaType.APPLICATION_JSON_VALUE)
public class VinoController {

	@Autowired
	private VinoService vinoService;

	@Autowired
	private VinoToVinoDTO toVinoDTO;

	@Autowired
	private VinoDTOToVino toVino;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<VinoDTO>> get(@RequestParam(required = false, defaultValue = "") String nazivVina,
			@RequestParam(required = false, defaultValue = "") Long vinarijaId,
			@RequestParam(value = "pageNo", defaultValue = "0") int page) {
		Page<Vino> vina = vinoService.search(vinarijaId, nazivVina, page);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(vina.getTotalPages()));

		return new ResponseEntity<>(toVinoDTO.convert(vina.getContent()), headers, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<VinoDTO> get(@PathVariable Long id) {
		Vino vino = vinoService.findOne(id);

		if (vino != null) {
			return new ResponseEntity<>(toVinoDTO.convert(vino), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Vino obrisaniVino = vinoService.delete(id);

		if (obrisaniVino != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDTO> create(@Valid @RequestBody VinoDTO vinoDTO) {
		Vino vino = toVino.convert(vinoDTO);

		if (vino.getTipVina() == null || vino.getTipVina() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Vino sacuvanoVino = vinoService.save(vino);

		return new ResponseEntity<>(toVinoDTO.convert(sacuvanoVino), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDTO> update(@PathVariable Long id, @Valid @RequestBody VinoDTO vinoDTO) {

		if (!id.equals(vinoDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Vino vino = toVino.convert(vinoDTO);

		if (vino.getTipVina() == null || vino.getTipVina() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Vino sacuvanoVino = vinoService.save(vino);

		return new ResponseEntity<>(toVinoDTO.convert(sacuvanoVino), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}/nabavka", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDTO> nabavkaVina(@PathVariable Long id, @Valid @RequestBody KolicinaDTO kolicinaDTO) {
		Vino vino = vinoService.findOne(id);

		if (vino == null || vino.getVinarija() == null || vino.getTipVina() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		int kolicina = kolicinaDTO.getKolicinaZaIzmenu();
		vinoService.nabavka(vino, kolicina);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
