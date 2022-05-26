package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ErregistratzeaEJB;
import bl.OrokorraEJB;
import dl.EskaintzaileaE;
import dl.EskatzaileaE;

@Named
@SessionScoped
public class ErregistratuAtazakMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mezua;
	private int kodea;
	private int kodeaIkas;
	private int kodeaIrak;
	private int eskaintzaileHartua;
	private String username;
	private EskaintzaileaE erregistratutakoEskaintzailea;
	
	@EJB private ErregistratzeaEJB eEJB;
	@EJB private OrokorraEJB oEJB;

	public ErregistratuAtazakMB() {
		// TODO Auto-generated constructor stub
	}
	public void eskaintzaileaErregistratuDB(EskaintzaileaFormMB eskaintzaileaFormMB)
	{
		EskaintzaileaE eskaintzaileaE=new EskaintzaileaE(0, eskaintzaileaFormMB.getEmail(), eskaintzaileaFormMB.getEnpresaIzena(), eskaintzaileaFormMB.getIzena(), eskaintzaileaFormMB.getKokalekua(), eskaintzaileaFormMB.getLaburpena(), eskaintzaileaFormMB.getLanEsparrua(), "irakaslea", eskaintzaileaFormMB.getPasahitza(), eskaintzaileaFormMB.getSaila(), eskaintzaileaFormMB.getUsername());
		kodeaIrak=eEJB.eskaintzaileaErregistratuDB(eskaintzaileaE);
		
		if(kodeaIrak==1)
		{
			mezua="ESKAINTZAILEA ONDO ERREGISTRATU DA";
			eskaintzaileHartua=1;
			setUsername(eskaintzaileaFormMB.getUsername());
			eskaintzaileaFormMB.clearForm();
		}
		else if(kodeaIrak==2)
		{
			mezua="USERNAME HORI HARTUTA DAGO";
			eskaintzaileHartua=2;
		}
	}
	
	public void eskatzaileaErregistratuDB(EskatzaileaFormMB eskatzaileaFormMB)
	{
		EskatzaileaE eskatzaileaE=new EskatzaileaE(0, eskatzaileaFormMB.getBizilekua(), eskatzaileaFormMB.getEmail(), eskatzaileaFormMB.getGaitasunak(), eskatzaileaFormMB.getHizkuntzak(), eskatzaileaFormMB.getIzenAbizenak(), "ikaslea", eskatzaileaFormMB.getPasahitza(), eskatzaileaFormMB.getTituluak(), eskatzaileaFormMB.getUsername());
		kodeaIkas=eEJB.eskatzaileaErregistratuDB(eskatzaileaE);
		
		if(kodeaIkas==0)
		{
			mezua="";
			eskaintzaileHartua=0;
		}
		else if(kodeaIkas==1)
		{
			mezua="ESKATZAILEA ONDO ERREGISTRATU DA";
			eskatzaileaFormMB.clearForm();
		}
		else if(kodeaIkas==2)
		{
			mezua="USERNAME HORI HARTUTA DAGO";
		}
	}
	
	public EskaintzaileaE erregistratutakoEskaintzaileaLortu() {
		erregistratutakoEskaintzailea=eEJB.erregistratutakoEskaintzaileaLortu(username);
		eskaintzaileHartua=0;
		if(erregistratutakoEskaintzailea==null) {
			kodea=2;
			mezua="ERREGISTRATU ZAITEZ BERRIRO, ZEOZER HUTS EGIN DU";
		}
		else {
			kodea=1;
			mezua="ESKATZAILEA ONDO ERREGISTRATU DA";
		}
		return erregistratutakoEskaintzailea;
	}
	
	public void eskaintzaileHartuaGarbitu()
	{
		eskaintzaileHartua=0;
	}
	
	public String getMezua() {
		return mezua;
	}
	public void setMezua(String mezua) {
		this.mezua = mezua;
	}
	public int getKodea() {
		return kodea;
	}
	public void setKodea(int kodea) {
		this.kodea = kodea;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public EskaintzaileaE getErregistratutakoEskaintzailea() {
		return erregistratutakoEskaintzailea;
	}
	public void setErregistratutakoEskaintzailea(EskaintzaileaE erregistratutakoEskaintzailea) {
		this.erregistratutakoEskaintzailea = erregistratutakoEskaintzailea;
	}
	public int getEskaintzaileHartua() {
		return eskaintzaileHartua;
	}
	public void setEskaintzaileHartua(int eskaintzaileHartua) {
		this.eskaintzaileHartua = eskaintzaileHartua;
	}
	public int getKodeaIkas() {
		return kodeaIkas;
	}
	public void setKodeaIkas(int kodeaIkas) {
		this.kodeaIkas = kodeaIkas;
	}
	public int getKodeaIrak() {
		return kodeaIrak;
	}
	public void setKodeaIrak(int kodeaIrak) {
		this.kodeaIrak = kodeaIrak;
	}
	
}
