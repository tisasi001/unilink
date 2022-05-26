package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Komentarioak database table.
 * 
 */
@Entity
@Table(name="Komentarioak")
@NamedQueries({
	@NamedQuery(name="KomentarioakE.findAll", query="SELECT k FROM KomentarioakE k"),
	@NamedQuery(name="KomentarioakE.komentarioakLortu", query="SELECT k FROM KomentarioakE k WHERE k.eskaintzaE.idEskaintza= :id"),
	@NamedQuery(name="KomentarioakE.erantzunakLortu", query="SELECT k FROM KomentarioakE k WHERE k.komentarioakE.idKomentarioak= :id"),
})
public class KomentarioakE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKomentarioak;

	private String testua;

	//uni-directional many-to-one association to EskaintzaE
	@ManyToOne
	@JoinColumn(name="Eskaintza_idEskaintza")
	private EskaintzaE eskaintzaE;

	//uni-directional many-to-one association to EskatzaileaE
	@ManyToOne
	@JoinColumn(name="Eskatzailea_idEskatzailea")
	private EskatzaileaE eskatzaileaE;

	//uni-directional many-to-one association to KomentarioakE
	@ManyToOne
	@JoinColumn(name="Komentarioak_idKomentarioak")
	private KomentarioakE komentarioakE;

	public KomentarioakE() {
	}

	public KomentarioakE(int idKomentarioak, String testua, EskaintzaE eskaintzaE, EskatzaileaE eskatzaileaE,
			KomentarioakE komentarioakE) {
		super();
		this.idKomentarioak = idKomentarioak;
		this.testua = testua;
		this.eskaintzaE = eskaintzaE;
		this.eskatzaileaE = eskatzaileaE;
		this.komentarioakE = komentarioakE;
	}

	public int getIdKomentarioak() {
		return this.idKomentarioak;
	}

	public void setIdKomentarioak(int idKomentarioak) {
		this.idKomentarioak = idKomentarioak;
	}

	public String getTestua() {
		return this.testua;
	}

	public void setTestua(String testua) {
		this.testua = testua;
	}

	public EskaintzaE getEskaintzaE() {
		return this.eskaintzaE;
	}

	public void setEskaintzaE(EskaintzaE eskaintzaE) {
		this.eskaintzaE = eskaintzaE;
	}

	public EskatzaileaE getEskatzaileaE() {
		return this.eskatzaileaE;
	}

	public void setEskatzaileaE(EskatzaileaE eskatzaileaE) {
		this.eskatzaileaE = eskatzaileaE;
	}

	public KomentarioakE getKomentarioakE() {
		return this.komentarioakE;
	}

	public void setKomentarioakE(KomentarioakE komentarioakE) {
		this.komentarioakE = komentarioakE;
	}

}