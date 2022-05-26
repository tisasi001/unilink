package pl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.OrokorraEJB;
import dl.*;

@Named
@SessionScoped
public class OrokorraAtazakMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private EskaintzaileaE eskaintzaileaDB;
	private EskatzaileaE eskatzaileaDB;
	private int idEskaintza;
	private int idEskaintzailea;
	private int idEskatzailea;
	private String mezua;
	private int kodea;
	private String autentikatutakoa;
	private int rola;
	private String aukeratutakoGradua;

	
	@EJB private OrokorraEJB oEJB;

	public OrokorraAtazakMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void autentikatutakoaLortu() {
		autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		rola=oEJB.autentikatutakoarenRolaLortu(autentikatutakoa);
		return;
	}
	
	
	public void irakProfilaKlikEgin(int idEskaintzailea) {
		this.idEskaintzailea=idEskaintzailea;
	}
	public void eskaintzaKlikEgin(int idEskaintza) {
		this.idEskaintza=idEskaintza;
	}
	public void ikasProfilaKlikEgin(int idEskatzailea) {
		this.idEskatzailea=idEskatzailea;
	}
	
	public EskaintzaileaE getEskaintzaileaDB() {
		return eskaintzaileaDB;
	}

	public void setEskaintzaileaDB(EskaintzaileaE eskaintzaileaDB) {
		this.eskaintzaileaDB = eskaintzaileaDB;
	}

	public EskatzaileaE getEskatzaileaDB() {
		return eskatzaileaDB;
	}

	public void setEskatzaileaDB(EskatzaileaE eskatzaileaDB) {
		this.eskatzaileaDB = eskatzaileaDB;
	}

	public String getMezua() {
		return mezua;
	}

	public void setMezua(String mezua) {
		this.mezua = mezua;
	}
	public int getRola() {
		return rola;
	}
	public void setRola(int rola) {
		this.rola = rola;
	}

	public String getAutentikatutakoa() {
		return autentikatutakoa;
	}
	public void resetAutentikatutakoa() {
		autentikatutakoa=null;
	}

	public int getKodea() {
		return kodea;
	}

	public void setKodea(int kodea) {
		this.kodea = kodea;
	}

	public int getIdEskaintza() {
		return idEskaintza;
	}

	public void setIdEskaintza(int idEskaintza) {
		this.idEskaintza = idEskaintza;
	}

	public int getIdEskaintzailea() {
		return idEskaintzailea;
	}

	public void setIdEskaintzailea(int idEskaintzailea) {
		this.idEskaintzailea = idEskaintzailea;
	}

	public int getIdEskatzailea() {
		return idEskatzailea;
	}

	public void setIdEskatzailea(int idEskatzailea) {
		this.idEskatzailea = idEskatzailea;
	}

	public String getAukeratutakoGradua() {
		return aukeratutakoGradua;
	}

	public void setAukeratutakoGradua(String aukeratutakoGradua) {
		this.aukeratutakoGradua = aukeratutakoGradua;
	}
	
	
}
