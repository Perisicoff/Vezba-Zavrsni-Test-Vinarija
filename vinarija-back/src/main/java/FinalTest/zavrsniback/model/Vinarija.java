package FinalTest.zavrsniback.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vinarija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String ime = "";

	@Column
	private int godinaOsnivanja;

	@OneToMany(mappedBy = "vinarija")
	private List<Vino> vina = new ArrayList<>();

	public Vinarija() {
	}

	public Vinarija(String ime, int godinaOsnivanja, List<Vino> vina) {
		this.ime = ime;
		this.godinaOsnivanja = godinaOsnivanja;
		this.vina = vina;
	}

	public Vinarija(Long id, String ime, int godinaOsnivanja, List<Vino> vina) {
		this.id = id;
		this.ime = ime;
		this.godinaOsnivanja = godinaOsnivanja;
		this.vina = vina;
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

	/**
	 * @return the vina
	 */
	public List<Vino> getVina() {
		return vina;
	}

	/**
	 * @param vina the vina to set
	 */
	public void setVina(List<Vino> vina) {
		this.vina = vina;
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
		if (!(obj instanceof Vinarija)) {
			return false;
		}
		Vinarija other = (Vinarija) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vinarija [id=" + id + ", ime=" + ime + ", godinaOsnivanja=" + godinaOsnivanja + ", vina=" + vina + "]";
	}

}
