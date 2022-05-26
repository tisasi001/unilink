package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskaintzailea database table.
 * 
 */
@Entity
@Table(name="Eskaintzailea")
@NamedQueries({
	@NamedQuery(name="EskaintzaileaE.findAll", query="SELECT e FROM EskaintzaileaE e"),
	@NamedQuery(name="EskaintzaileaE.eskaintzaileBatLortu", query="SELECT e FROM EskaintzaileaE e WHERE e.username= :username"),
})
public class EskaintzaileaE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEskaintzailea;

	private String email;

	private String enpresaIzena;

	private String izena;

	private String kokalekua;

	private String laburpena;

	private String lanEsparrua;

	private String mota;

	private String pasahitza;

	private String saila;

	private String username;

	public EskaintzaileaE() {
	}

	public EskaintzaileaE(int idEskaintzailea, String email, String enpresaIzena, String izena, String kokalekua,
			String laburpena, String lanEsparrua, String mota, String pasahitza, String saila, String username) {
		super();
		this.idEskaintzailea = idEskaintzailea;
		this.email = email;
		this.enpresaIzena = enpresaIzena;
		this.izena = izena;
		this.kokalekua = kokalekua;
		this.laburpena = laburpena;
		this.lanEsparrua = lanEsparrua;
		this.mota = mota;
		this.pasahitza = pasahitza;
		this.saila = saila;
		this.username = username;
	}

	public int getIdEskaintzailea() {
		return this.idEskaintzailea;
	}

	public void setIdEskaintzailea(int idEskaintzailea) {
		this.idEskaintzailea = idEskaintzailea;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnpresaIzena() {
		return this.enpresaIzena;
	}

	public void setEnpresaIzena(String enpresaIzena) {
		this.enpresaIzena = enpresaIzena;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getKokalekua() {
		return this.kokalekua;
	}

	public void setKokalekua(String kokalekua) {
		this.kokalekua = kokalekua;
	}

	public String getLaburpena() {
		return this.laburpena;
	}

	public void setLaburpena(String laburpena) {
		this.laburpena = laburpena;
	}

	public String getLanEsparrua() {
		return this.lanEsparrua;
	}

	public void setLanEsparrua(String lanEsparrua) {
		this.lanEsparrua = lanEsparrua;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getPasahitza() {
		return this.pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getSaila() {
		return this.saila;
	}

	public void setSaila(String saila) {
		this.saila = saila;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}