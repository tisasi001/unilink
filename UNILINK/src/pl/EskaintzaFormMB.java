package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EskaintzaFormMB {

	public EskaintzaFormMB() {
		// TODO Auto-generated constructor stub
	}
	
	private String azalpena;
	private String materiala;
	private String eskakizunak;
	private String graduak;
	private String ordutegia;
	private int orduak;
	private String iraupena;
	private float prezioa;
	private String lekua;
	private String oporrak;
	private float soldata;
	private int deialdia;
	private String izenburua;
	private String saila;
	private String tutorea;
	

	public EskaintzaFormMB(String azalpena, String materiala, String eskakizunak, String graduak, String ordutegia,
			int orduak, String iraupena, float prezioa, String lekua, String oporrak, float soldata, int deialdia,
			String izenburua, String saila, String tutorea) {
		super();
		this.azalpena = azalpena;
		this.materiala = materiala;
		this.eskakizunak = eskakizunak;
		this.graduak = graduak;
		this.ordutegia = ordutegia;
		this.orduak = orduak;
		this.iraupena = iraupena;
		this.prezioa = prezioa;
		this.lekua = lekua;
		this.oporrak = oporrak;
		this.soldata = soldata;
		this.deialdia = deialdia;
		this.izenburua = izenburua;
		this.saila = saila;
		this.tutorea = tutorea;
	}
	
	public String getAzalpena() {
		return azalpena;
	}


	public void setAzalpena(String azalpena) {
		this.azalpena = azalpena;
	}


	public String getMateriala() {
		return materiala;
	}


	public void setMateriala(String materiala) {
		this.materiala = materiala;
	}


	public String getEskakizunak() {
		return eskakizunak;
	}


	public void setEskakizunak(String eskakizunak) {
		this.eskakizunak = eskakizunak;
	}


	public String getGraduak() {
		return graduak;
	}


	public void setGraduak(String graduak) {
		this.graduak = graduak;
	}


	public String getOrdutegia() {
		return ordutegia;
	}


	public void setOrdutegia(String ordutegia) {
		this.ordutegia = ordutegia;
	}


	public int getOrduak() {
		return orduak;
	}


	public void setOrduak(int orduak) {
		this.orduak = orduak;
	}


	public String getIraupena() {
		return iraupena;
	}


	public void setIraupena(String iraupena) {
		this.iraupena = iraupena;
	}


	public float getPrezioa() {
		return prezioa;
	}


	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}


	public String getLekua() {
		return lekua;
	}


	public void setLekua(String lekua) {
		this.lekua = lekua;
	}


	public String getOporrak() {
		return oporrak;
	}


	public void setOporrak(String oporrak) {
		this.oporrak = oporrak;
	}


	public float getSoldata() {
		return soldata;
	}


	public void setSoldata(float soldata) {
		this.soldata = soldata;
	}


	public int getDeialdia() {
		return deialdia;
	}


	public void setDeialdia(int deialdia) {
		this.deialdia = deialdia;
	}


	public String getIzenburua() {
		return izenburua;
	}


	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}


	public String getSaila() {
		return saila;
	}


	public void setSaila(String saila) {
		this.saila = saila;
	}


	public String getTutorea() {
		return tutorea;
	}


	public void setTutorea(String tutorea) {
		this.tutorea = tutorea;
	}
	

	@Override
	public String toString() {
		return "EskaintzaFormMB [azalpena=" + azalpena + ", materiala=" + materiala + ", eskakizunak=" + eskakizunak
				+ ", graduak=" + graduak + ", ordutegia=" + ordutegia + ", orduak=" + orduak + ", iraupena=" + iraupena
				+ ", prezioa=" + prezioa + ", lekua=" + lekua + ", oporrak=" + oporrak + ", soldata=" + soldata
				+ ", deialdia=" + deialdia + ", izenburua=" + izenburua + ", saila=" + saila + ", tutorea=" + tutorea
				+ "]";
	}

	public void clearForm() {
		this.azalpena ="";
		this.materiala="";
		this.eskakizunak="";
		this.graduak="";
		this.ordutegia="";
		this.orduak= 0;
		this.iraupena="";
		this.prezioa= 0;
		this.lekua="";
		this.oporrak="";
		this.soldata=0;
		this.deialdia=0;
		this.izenburua="";
		this.saila="";
		this.tutorea="";
	}
}
