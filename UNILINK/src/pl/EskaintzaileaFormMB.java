package pl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.EskaintzaileaEJB;
import bl.OrokorraEJB;
import dl.*;

@Named
@RequestScoped
public class EskaintzaileaFormMB {

	public EskaintzaileaFormMB() {
		// TODO Auto-generated constructor stub
	}

	@EJB private EskaintzaileaEJB eEJB;
	@EJB private OrokorraEJB oEJB;
	private String email;
	private String enpresaIzena;
	private String izena;
	private String kokalekua;
	private String laburpena;
	private String lanEsparrua;
	private String pasahitza;
	private String saila;
	private String username;
	
	public EskaintzaileaFormMB(String email, String enpresaIzena, String izena, String kokalekua, String laburpena,
			String lanEsparrua, String pasahitza, String saila, String username) {
		super();
		this.email = email;
		this.enpresaIzena = enpresaIzena;
		this.izena = izena;
		this.kokalekua = kokalekua;
		this.laburpena = laburpena;
		this.lanEsparrua = lanEsparrua;
		this.pasahitza = pasahitza;
		this.saila = saila;
		this.username = username;
	}
	
	public void balioakHasieratu(ProfilaViewMB profilaViewMB)
	{
		String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		List<EskaintzaileaE> irakasleList=oEJB.irakasleAutentikatutakoaLortuDB(username);
		EskaintzaileaE eskaintzaileaDB=irakasleList.get(0);
		email=eskaintzaileaDB.getEmail();
		enpresaIzena=eskaintzaileaDB.getEnpresaIzena();
		izena=eskaintzaileaDB.getIzena();
		kokalekua=eskaintzaileaDB.getKokalekua();
		laburpena=eskaintzaileaDB.getLaburpena();
		lanEsparrua=eskaintzaileaDB.getLanEsparrua();
		pasahitza=eskaintzaileaDB.getPasahitza();
		saila=eskaintzaileaDB.getSaila();
		username=eskaintzaileaDB.getUsername();
		
		/*email=eEJB.irakBatenDatuakLortuDB().getEmail();
		enpresaIzena=eEJB.irakBatenDatuakLortuDB().getEnpresaIzena();
		izena=eEJB.irakBatenDatuakLortuDB().getIzena();
		kokalekua=eEJB.irakBatenDatuakLortuDB().getKokalekua();
		laburpena=eEJB.irakBatenDatuakLortuDB().getLaburpena();
		lanEsparrua=eEJB.irakBatenDatuakLortuDB().getLanEsparrua();
		pasahitza=eEJB.irakBatenDatuakLortuDB().getPasahitza();
		saila=eEJB.irakBatenDatuakLortuDB().getSaila();
		username=eEJB.irakBatenDatuakLortuDB().getUsername();*/
		profilaViewMB.resetView();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnpresaIzena() {
		return enpresaIzena;
	}

	public void setEnpresaIzena(String enpresaIzena) {
		this.enpresaIzena = enpresaIzena;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getKokalekua() {
		return kokalekua;
	}

	public void setKokalekua(String kokalekua) {
		this.kokalekua = kokalekua;
	}

	public String getLaburpena() {
		return laburpena;
	}

	public void setLaburpena(String laburpena) {
		this.laburpena = laburpena;
	}

	public String getLanEsparrua() {
		return lanEsparrua;
	}

	public void setLanEsparrua(String lanEsparrua) {
		this.lanEsparrua = lanEsparrua;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getSaila() {
		return saila;
	}

	public void setSaila(String saila) {
		this.saila = saila;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void clearForm()
	{
		email="";
		enpresaIzena="";
		izena="";
		kokalekua="";
		laburpena="";
		lanEsparrua="";
		pasahitza="";
		saila="";
		username="";
	}
}
