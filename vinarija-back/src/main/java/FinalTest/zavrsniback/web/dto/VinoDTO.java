package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class VinoDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String ime = "";

	@Positive(message = "Godina proizvodnje mora biti pozitivan broj.")
	private int godinaProizvodnje;

	@Length(max = 120, message = "Opis mora biti maximalno 120 karaktera.")
	private String opis = "";

	@Positive(message = "Cena flase mora biti pozitivan broj.")
	private double cena;

	private int dostupneFlase;

	private Long tipVinaId;

	private String nazivtipaVina = "";

	private Long vinarijaId;

	private String nazivVinarije = "";

	public VinoDTO() {
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
	 * @return the godinaProizvodnje
	 */
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	/**
	 * @param godinaProizvodnje the godinaProizvodnje to set
	 */
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	/**
	 * @return the opis
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * @param opis the opis to set
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

	/**
	 * @return the cena
	 */
	public double getCena() {
		return cena;
	}

	/**
	 * @param cena the cena to set
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}

	/**
	 * @return the dostupneFlase
	 */
	public int getDostupneFlase() {
		return dostupneFlase;
	}

	/**
	 * @param dostupneFlase the dostupneFlase to set
	 */
	public void setDostupneFlase(int dostupneFlase) {
		this.dostupneFlase = dostupneFlase;
	}

	/**
	 * @return the tipVinaId
	 */
	public Long getTipVinaId() {
		return tipVinaId;
	}

	/**
	 * @param tipVinaId the tipVinaId to set
	 */
	public void setTipVinaId(Long tipVinaId) {
		this.tipVinaId = tipVinaId;
	}

	/**
	 * @return the nazivtipaVina
	 */
	public String getNazivtipaVina() {
		return nazivtipaVina;
	}

	/**
	 * @param nazivtipaVina the nazivtipaVina to set
	 */
	public void setNazivtipaVina(String nazivtipaVina) {
		this.nazivtipaVina = nazivtipaVina;
	}

	/**
	 * @return the vinarijaId
	 */
	public Long getVinarijaId() {
		return vinarijaId;
	}

	/**
	 * @param vinarijaId the vinarijaId to set
	 */
	public void setVinarijaId(Long vinarijaId) {
		this.vinarijaId = vinarijaId;
	}

	/**
	 * @return the nazivVinarije
	 */
	public String getNazivVinarije() {
		return nazivVinarije;
	}

	/**
	 * @param nazivVinarije the nazivVinarije to set
	 */
	public void setNazivVinarije(String nazivVinarije) {
		this.nazivVinarije = nazivVinarije;
	}

}
