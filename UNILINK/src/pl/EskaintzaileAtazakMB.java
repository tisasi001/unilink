package pl;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.EskaintzaileaEJB;
import dl.ErlazioaE;
import dl.EskaintzaE;
import dl.EskaintzaileaE;

import java.io.Serializable;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class EskaintzaileAtazakMB implements Serializable {
	//private String autentikatutakoa;
	private int kodea;
	private String mezua;

	public EskaintzaileAtazakMB() {
		// TODO Auto-generated constructor stub
	}
	@EJB private EskaintzaileaEJB eEJB;
	
	/*@PostConstruct
	private void autentikatutakoaLortu() {
		autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		return;
	}*/
	
	public void eskaintzaIgoDB(EskaintzaFormMB eskaintzaFormMB) {
		EskaintzaE eskaintza=new EskaintzaE(0,eskaintzaFormMB.getAzalpena(),eskaintzaFormMB.getDeialdia(),1,eskaintzaFormMB.getEskakizunak(),eskaintzaFormMB.getGraduak(),eskaintzaFormMB.getIraupena(),eskaintzaFormMB.getIzenburua(),eskaintzaFormMB.getLekua(),eskaintzaFormMB.getMateriala(),eskaintzaFormMB.getOporrak(),eskaintzaFormMB.getOrduak(),eskaintzaFormMB.getOrdutegia(),eskaintzaFormMB.getPrezioa(),eskaintzaFormMB.getSaila(),eskaintzaFormMB.getSoldata(),eskaintzaFormMB.getTutorea(),null);
		kodea=eEJB.eskaintzaIgoDB(eskaintza);
		if(kodea==2) {
			mezua="ERROREA:ESKAINTZA EZ DA ONDO IGO";
		}
		else {
			mezua="ESKAINTZA ONDO IGO DA:"+eskaintzaFormMB.toString();
		}
		eskaintzaFormMB.clearForm();
		
	}
	public void profilaEskaintzaileaGorde(EskaintzaileaFormMB eskaintzaileaFormMB)
	{
		String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		EskaintzaileaE eskaintzaileaE=new EskaintzaileaE(0, eskaintzaileaFormMB.getEmail(), eskaintzaileaFormMB.getEnpresaIzena(), eskaintzaileaFormMB.getIzena(), eskaintzaileaFormMB.getKokalekua(), eskaintzaileaFormMB.getLaburpena(), eskaintzaileaFormMB.getLanEsparrua(), "irakaslea", eskaintzaileaFormMB.getPasahitza(), eskaintzaileaFormMB.getSaila(), username);
		eEJB.irakProfilaGorde(eskaintzaileaE);
		eskaintzaileaFormMB.clearForm();
	}
	public void eskaintzaileaEzabatuDB()
	{
		kodea=eEJB.eskaintzaleaEzabatuDB();
		if(kodea==0)
		{
			mezua="";
		}
		else if(kodea==1)
		{
			mezua="ESKAINTZAILEA EZABATUTA";
		}
		else if(kodea==2)
		{
			mezua="ERRORA: ESKAINTZAILE HORI EZ DA EXISTITZEN";
		}
	}
	public void eskaintzaEzabatu(EskaintzaE eskaintza, ProfilaViewMB profilaViewMB) {
		kodea=eEJB.eskaintzaEzabatu(eskaintza.getIdEskaintza());
		if(kodea==0)
		{
			mezua="";
		}
		else if(kodea==1)
		{
			mezua="ESKAINTZA EZABATUTA";
		}
		else if(kodea==2)
		{
			mezua="ERROREA: ESKAINTZA HORI EZ DA EXISTITZEN";
		}
		profilaViewMB.resetView();
	}
	public void eskaintzaEgoeraAldatu(EskaintzaE eskaintza, ProfilaViewMB profilaViewMB) {
		kodea=eEJB.eskaintzaEgoeraAldatu(eskaintza.getIdEskaintza());
		if(kodea==0)
		{
			mezua="";
		}
		else if(kodea==1)
		{
			mezua=""+eskaintza.getIzenburua()+"ESKAINTZAREN EGOERA ALDATUTA";
		}
		else if(kodea==2)
		{
			mezua="ERROREA: ESKAINTZA HORI EZ DA EXISTITZEN";
		}
		profilaViewMB.resetView();
	}
	// NUEVOOOOOO !!!!!
	public void eskariBatOnartu(ErlazioaE eskaria, EskaintzakViewMB eskaintzakViewMB) {
		kodea=eEJB.eskariBatOnartu(eskaria.getEskaintzaE().getIdEskaintza(),eskaria.getIdErlazioa());
		if(kodea==0)
		{
			mezua="";
		}
		else if(kodea==1)
		{
			mezua="ESKARIA ONARTUTA";
		}
		else if(kodea==2)
		{
			mezua="ERROREA: ESKAINTZA HORI EZ DA EXISTITZEN";
		}
		eskaintzakViewMB.resetView();
	}
	public void eskariBatEzeztatu(ErlazioaE eskaria, EskaintzakViewMB eskaintzakViewMB) {
		kodea=eEJB.eskariBatEzeztatu(eskaria.getEskaintzaE().getIdEskaintza(),eskaria.getIdErlazioa());
		if(kodea==0)
		{
			mezua="";
		}
		else if(kodea==1)
		{
			mezua="ESKARIA EZEZTATUTA";
		}
		else if(kodea==2)
		{
			mezua="ERROREA: ESKAINTZA HORI EZ DA EXISTITZEN";
		}
		eskaintzakViewMB.resetView();
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
	public void resetMB() {
		this.kodea=0;
		this.mezua="";
	}
	
}
