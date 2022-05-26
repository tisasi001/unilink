package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import bl.EskatzaileaEJB;
import dl.*;

@Named
@SessionScoped
public class EskatzaileAtazakMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kodea;
	private String mezua;
	private String irakEmail;
	
	private List<ErlazioaE> autentikatutakoarenEskaerak;
	
	@EJB private EskatzaileaEJB eEJB;

	public EskatzaileAtazakMB() {
		// TODO Auto-generated constructor stub
	}
	
	public void eskariBatEginAktiboak(EskaintzaE eskaintza, EskaintzaAktiboakViewMB eskaintzaAktiboakViewMB) {
		String autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		kodea=eEJB.eskariBatEgin(eskaintza.getIdEskaintza(), autentikatutakoa);
		if(kodea==2) {
			mezua="ESKARIA EZ DA ONDO EGIN";
		}
		else {
			mezua="ESKARIA ONDO EGIN DA";
		}
		eskaintzaAktiboakViewMB.resetView();
	}
	public void eskariBatEginEskaintza(EskaintzaE eskaintza, EskaintzakViewMB eskaintzakViewMB) {
		String autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		kodea=eEJB.eskariBatEgin(eskaintza.getIdEskaintza(), autentikatutakoa);
		if(kodea==2) {
			mezua="ESKARIA EZ DA ONDO EGIN";
		}
		else {
			mezua="ESKARIA ONDO EGIN DA";
		}
		eskaintzakViewMB.resetView();
	}
	public void eskariBatEginEskaintzaileDatuak(EskaintzaE eskaintza, EskaintzaileaViewMB eskaintzaileaViewMB) {
		String autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		kodea=eEJB.eskariBatEgin(eskaintza.getIdEskaintza(), autentikatutakoa);
		if(kodea==2) {
			mezua="ESKARIA EZ DA ONDO EGIN";
		}
		else {
			mezua="ESKARIA ONDO EGIN DA";
		}
		eskaintzaileaViewMB.resetView();	
	}
	
	
	public void profilaEskatzaileaGorde(EskatzaileaFormMB eskatzaileaFormMB)
	{
		String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		EskatzaileaE eskatzaileaE=new EskatzaileaE(0, eskatzaileaFormMB.getBizilekua(), eskatzaileaFormMB.getEmail(), eskatzaileaFormMB.getGaitasunak(), eskatzaileaFormMB.getHizkuntzak(), eskatzaileaFormMB.getIzenAbizenak(), "ikaslea", eskatzaileaFormMB.getPasahitza(), eskatzaileaFormMB.getTituluak(), username);
		eEJB.ikasProfilaGorde(eskatzaileaE);
		eskatzaileaFormMB.clearForm();
	}
	public List<ErlazioaE> autentikatutakoarenEskariakLortuDB(){
		String autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		autentikatutakoarenEskaerak=eEJB.autentikatutakoarenEskariakLortu(autentikatutakoa);
		return autentikatutakoarenEskaerak;
	}
	public void eskatzaileaEzabatuDB()
	{
		kodea=eEJB.eskatzaileaEzabatuDB();
		if(kodea==0)
		{
			mezua="";
		}
		else if(kodea==1)
		{
			mezua="ESKATZAILEA EZABATUTA";
		}
		else if(kodea==2)
		{
			mezua="ESKATZAILE HORI EZ DA EXISTITZEN";
		}
	}
	public void komentarioaSartuDB(KomentarioakFormMB komentarioakFormMB,EskaintzakViewMB eskaintzakViewMB,EskaintzaE eskaintzaE) {
		KomentarioakE komentarioaE = new KomentarioakE();
		komentarioaE.setIdKomentarioak(0);
		komentarioaE.setEskaintzaE(eskaintzaE);
		komentarioaE.setTestua(komentarioakFormMB.getTestua());
		
		eEJB.komentarioaSartuDB(komentarioaE);
		
		komentarioakFormMB.clearForm();
		eskaintzakViewMB.resetView();
	}
	public void erantzunaSartuDB(KomentarioakFormMB komentarioakFormMB, EskaintzakViewMB eskaintzakViewMB, KomentarioakE komentarioaE) {
		KomentarioakE erantzuna = new KomentarioakE();
		erantzuna.setIdKomentarioak(0);
		erantzuna.setEskaintzaE(komentarioaE.getEskaintzaE());
		erantzuna.setTestua(komentarioakFormMB.getTestua());
		erantzuna.setKomentarioakE(komentarioaE);
		
		eEJB.komentarioaSartuDB(erantzuna);
		
		komentarioakFormMB.clearForm();
		eskaintzakViewMB.resetView();
	}
	
	public boolean botoiaBistaratu(int idEskaintza)
	{
		int a=eEJB.eskariaDuen(idEskaintza);	
		boolean bai=true; //ez dugu eskaria egin, beraz bistaratuko da.
		if(a==1)
		{
			bai=false; //bat bueltatu du, bazegoen eskaria eginda, ez da bistaratuko
		}
		return bai;
	}
	
	public void emailKlikEgin(String email) {
		this.irakEmail=email;
	}
	
	public int getKodea() {
		return kodea;
	}

	public void setKodea(int kodea) {
		this.kodea = kodea;
	}

	public String getMezua() {
		return mezua;
	}

	public void setMezua(String mezua) {
		this.mezua = mezua;
	}

	public String getIrakEmail() {
		return irakEmail;
	}

	public void setIrakEmail(String irakEmail) {
		this.irakEmail = irakEmail;
	}

	public List<ErlazioaE> getAutentikatutakoarenEskaerak() {
		return autentikatutakoarenEskaerak;
	}

	public void setAutentikatutakoarenEskaerak(List<ErlazioaE> autentikatutakoarenEskaerak) {
		this.autentikatutakoarenEskaerak = autentikatutakoarenEskaerak;
	}
	
}
