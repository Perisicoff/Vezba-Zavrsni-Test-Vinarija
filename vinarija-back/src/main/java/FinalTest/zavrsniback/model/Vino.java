package FinalTest.zavrsniback.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String ime = "";

	@Column
	private String opis = "";

	@Column(nullable = false)
	private int godinaProizvodnje;

	@Column
	private double cena;

	@Column
	private int dostupneFlase;

	@ManyToOne
	private TipVina tipVina;

	@ManyToOne
	private Vinarija vinarija;

	public Vino() {
	}

	public Vino(String ime, String opis, int godinaProizvodnje, double cena, int dostupneFlase, TipVina tipVina,
			Vinarija vinarija) {
		this.ime = ime;
		this.opis = opis;
		this.godinaProizvodnje = godinaProizvodnje;
		this.cena = cena;
		this.dostupneFlase = dostupneFlase;
		this.tipVina = tipVina;
		this.vinarija = vinarija;
	}

	public Vino(Long id, String ime, String opis, int godinaProizvodnje, double cena, int dostupneFlase,
			TipVina tipVina, Vinarija vinarija) {
		this.id = id;
		this.ime = ime;
		this.opis = opis;
		this.godinaProizvodnje = godinaProizvodnje;
		this.cena = cena;
		this.dostupneFlase = dostupneFlase;
		this.tipVina = tipVina;
		this.vinarija = vinarija;
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
	 * @return the godinaProizvodjne
	 */
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	/**
	 * @param godinaProizvodjne the godinaProizvodjne to set
	 */
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
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
	 * @return the tipVina
	 */
	public TipVina getTipVina() {
		return tipVina;
	}

	/**
	 * @param tipVina the tipVina to set
	 */
	public void setTipVina(TipVina tipVina) {
		this.tipVina = tipVina;
	}

	/**
	 * @return the vinarija
	 */
	public Vinarija getVinarija() {
		return vinarija;
	}

	/**
	 * @param vinarija the vinarija to set
	 */
	public void setVinarija(Vinarija vinarija) {
		this.vinarija = vinarija;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vino)) {
			return false;
		}
		Vino other = (Vino) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vino [id=" + id + ", ime=" + ime + ", opis=" + opis + ", godinaProizvodnje=" + godinaProizvodnje
				+ ", cena=" + cena + ", dostupneFlase=" + dostupneFlase + ", tipVina=" + tipVina + ", vinarija="
				+ vinarija + "]";
	}

}
