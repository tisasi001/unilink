package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Erabiltzailea database table.
 * 
 */
@Entity
@Table(name="Erabiltzailea")
@NamedQueries({
	@NamedQuery(name="ErabiltzaileaE.findAll", query="SELECT e FROM ErabiltzaileaE e"),
	@NamedQuery(name="ErabiltzaileaE.erabLortu", query="SELECT e FROM ErabiltzaileaE e WHERE e.username= :username"),	
	})
public class ErabiltzaileaE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idErabiltzailea;

	private String mota;

	private String pasahitza;

	private String username;

	public ErabiltzaileaE() {
	}

	public ErabiltzaileaE(int idErabiltzailea, String mota, String pasahitza, String username) {
		super();
		this.idErabiltzailea = idErabiltzailea;
		this.mota = mota;
		this.pasahitza = pasahitza;
		this.username = username;
	}

	public int getIdErabiltzailea() {
		return this.idErabiltzailea;
	}

	public void setIdErabiltzailea(int idErabiltzailea) {
		this.idErabiltzailea = idErabiltzailea;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}