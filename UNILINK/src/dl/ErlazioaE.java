package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Erlazioa database table.
 * 
 */
@Entity
@Table(name="Erlazioa")
@NamedQueries({
	@NamedQuery(name="ErlazioaE.findAll", query="SELECT e FROM ErlazioaE e"),
	@NamedQuery(name="ErlazioaE.ikasEskariakLortu", query="SELECT e FROM ErlazioaE e WHERE e.eskatzaileaE.idEskatzailea= :idEskatzailea"),
	@NamedQuery(name="ErlazioaE.eskaIkasLortu", query="SELECT e FROM ErlazioaE e WHERE e.eskaintzaE.idEskaintza= :id"),
})
public class ErlazioaE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idErlazioa;

	private int eskariaEgoera;

	//uni-directional many-to-one association to EskaintzaE
	@ManyToOne
	@JoinColumn(name="Eskaintza_idEskaintza")
	private EskaintzaE eskaintzaE;

	//uni-directional many-to-one association to EskatzaileaE
	@ManyToOne
	@JoinColumn(name="Eskatzailea_idEskatzailea")
	private EskatzaileaE eskatzaileaE;

	public ErlazioaE() {
	}

	public ErlazioaE(int idErlazioa, int eskariaEgoera, EskaintzaE eskaintzaE, EskatzaileaE eskatzaileaE) {
		super();
		this.idErlazioa = idErlazioa;
		this.eskariaEgoera = eskariaEgoera;
		this.eskaintzaE = eskaintzaE;
		this.eskatzaileaE = eskatzaileaE;
	}

	public int getIdErlazioa() {
		return this.idErlazioa;
	}

	public void setIdErlazioa(int idErlazioa) {
		this.idErlazioa = idErlazioa;
	}

	public int getEskariaEgoera() {
		return this.eskariaEgoera;
	}

	public void setEskariaEgoera(int eskariaEgoera) {
		this.eskariaEgoera = eskariaEgoera;
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

}