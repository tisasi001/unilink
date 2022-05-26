package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskatzailea database table.
 * 
 */
@Entity
@Table(name="Eskatzailea")
@NamedQueries({
	@NamedQuery(name="EskatzaileaE.findAll", query="SELECT e FROM EskatzaileaE e"),
	@NamedQuery(name="EskatzaileaE.eskatzaileBatLortu", query="SELECT e FROM EskatzaileaE e WHERE e.username= :username")
})
public class EskatzaileaE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEskatzailea;

	private String bizilekua;

	private String email;

	private String gaitasunak;

	private String hizkuntzak;

	private String izenAbizenak;

	private String mota;

	private String pasahitza;

	private String tituluak;

	private String username;

	public EskatzaileaE() {
	}

	public EskatzaileaE(int idEskatzailea, String bizilekua, String email, String gaitasunak, String hizkuntzak,
			String izenAbizenak, String mota, String pasahitza, String tituluak, String username) {
		super();
		this.idEskatzailea = idEskatzailea;
		this.bizilekua = bizilekua;
		this.email = email;
		this.gaitasunak = gaitasunak;
		this.hizkuntzak = hizkuntzak;
		this.izenAbizenak = izenAbizenak;
		this.mota = mota;
		this.pasahitza = pasahitza;
		this.tituluak = tituluak;
		this.username = username;
	}

	public int getIdEskatzailea() {
		return this.idEskatzailea;
	}

	public void setIdEskatzailea(int idEskatzailea) {
		this.idEskatzailea = idEskatzailea;
	}

	public String getBizilekua() {
		return this.bizilekua;
	}

	public void setBizilekua(String bizilekua) {
		this.bizilekua = bizilekua;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGaitasunak() {
		return this.gaitasunak;
	}

	public void setGaitasunak(String gaitasunak) {
		this.gaitasunak = gaitasunak;
	}

	public String getHizkuntzak() {
		return this.hizkuntzak;
	}

	public void setHizkuntzak(String hizkuntzak) {
		this.hizkuntzak = hizkuntzak;
	}

	public String getIzenAbizenak() {
		return this.izenAbizenak;
	}

	public void setIzenAbizenak(String izenAbizenak) {
		this.izenAbizenak = izenAbizenak;
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

	public String getTituluak() {
		return this.tituluak;
	}

	public void setTituluak(String tituluak) {
		this.tituluak = tituluak;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}