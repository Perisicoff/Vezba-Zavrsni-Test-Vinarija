package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class VinarijaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String ime;

	private int godinaOsnivanja;

	public VinarijaDTO() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * @return the godinaOsnivanja
	 */
	public int getGodinaOsnivanja() {
		return godinaOsnivanja;
	}

	/**
	 * @param godinaOsnivanja the godinaOsnivanja to set
	 */
	public void setGodinaOsnivanja(int godinaOsnivanja) {
		this.godinaOsnivanja = godinaOsnivanja;
	}

}
