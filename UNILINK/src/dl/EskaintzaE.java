package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskaintza database table.
 * 
 */
@Entity
@Table(name="Eskaintza")
@NamedQueries({
	@NamedQuery(name="EskaintzaE.findAll", query="SELECT e FROM EskaintzaE e"),
	@NamedQuery(name="EskaintzaE.eskaintzaGraduaLortu", query="SELECT e FROM EskaintzaE e WHERE e.graduak= :gradua"),
	@NamedQuery(name="EskaintzaE.eskaintzaAktiboakLortu", query="SELECT e FROM EskaintzaE e WHERE e.eskaintzaEgoera=1"),
	@NamedQuery(name="EskaintzaE.irakEskaintzakLortu", query="SELECT e FROM EskaintzaE e WHERE e.eskaintzaileaE.idEskaintzailea= :idEskaintzailea"),	//KONTUZ LEHEN username zegoen jarrita, igual erroreren bat ematen du !!!!!!
	@NamedQuery(name="EskaintzaE.irakEskaintzakLortuUsername", query="SELECT e FROM EskaintzaE e WHERE e.eskaintzaileaE.username= :username"),	
	@NamedQuery(name="EskaintzaE.graduakLortu", query="SELECT DISTINCT e.graduak FROM EskaintzaE e"),
})
public class EskaintzaE implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEskaintza;

	private String azalpena;

	private int deialdia;

	private int eskaintzaEgoera;

	private String eskakizunak;

	private String graduak;

	private String iraupena;

	private String izenburua;

	private String lekua;

	private String materiala;

	private String oporrak;

	private int orduak;

	private String ordutegia;

	private float prezioa;

	private String saila;

	private float soldata;

	private String tutorea;

	//uni-directional many-to-one association to EskaintzaileaE
	@ManyToOne
	@JoinColumn(name="Eskaintzailea_idEskaintzailea")
	private EskaintzaileaE eskaintzaileaE;

	public EskaintzaE() {
	}

	public EskaintzaE(int idEskaintza, String azalpena, int deialdia, int eskaintzaEgoera, String eskakizunak,
			String graduak, String iraupena, String izenburua, String lekua, String materiala, String oporrak,
			int orduak, String ordutegia, float prezioa, String saila, float soldata, String tutorea,
			EskaintzaileaE eskaintzaileaE) {
		super();
		this.idEskaintza = idEskaintza;
		this.azalpena = azalpena;
		this.deialdia = deialdia;
		this.eskaintzaEgoera = eskaintzaEgoera;
		this.eskakizunak = eskakizunak;
		this.graduak = graduak;
		this.iraupena = iraupena;
		this.izenburua = izenburua;
		this.lekua = lekua;
		this.materiala = materiala;
		this.oporrak = oporrak;
		this.orduak = orduak;
		this.ordutegia = ordutegia;
		this.prezioa = prezioa;
		this.saila = saila;
		this.soldata = soldata;
		this.tutorea = tutorea;
		this.eskaintzaileaE = eskaintzaileaE;
	}

	public int getIdEskaintza() {
		return this.idEskaintza;
	}

	public void setIdEskaintza(int idEskaintza) {
		this.idEskaintza = idEskaintza;
	}

	public String getAzalpena() {
		return this.azalpena;
	}

	public void setAzalpena(String azalpena) {
		this.azalpena = azalpena;
	}

	public int getDeialdia() {
		return this.deialdia;
	}

	public void setDeialdia(int deialdia) {
		this.deialdia = deialdia;
	}

	public int getEskaintzaEgoera() {
		return this.eskaintzaEgoera;
	}

	public void setEskaintzaEgoera(int eskaintzaEgoera) {
		this.eskaintzaEgoera = eskaintzaEgoera;
	}

	public String getEskakizunak() {
		return this.eskakizunak;
	}

	public void setEskakizunak(String eskakizunak) {
		this.eskakizunak = eskakizunak;
	}

	public String getGraduak() {
		return this.graduak;
	}

	public void setGraduak(String graduak) {
		this.graduak = graduak;
	}

	public String getIraupena() {
		return this.iraupena;
	}

	public void setIraupena(String iraupena) {
		this.iraupena = iraupena;
	}

	public String getIzenburua() {
		return this.izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public String getLekua() {
		return this.lekua;
	}

	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	public String getMateriala() {
		return this.materiala;
	}

	public void setMateriala(String materiala) {
		this.materiala = materiala;
	}

	public String getOporrak() {
		return this.oporrak;
	}

	public void setOporrak(String oporrak) {
		this.oporrak = oporrak;
	}

	public int getOrduak() {
		return this.orduak;
	}

	public void setOrduak(int orduak) {
		this.orduak = orduak;
	}

	public String getOrdutegia() {
		return this.ordutegia;
	}

	public void setOrdutegia(String ordutegia) {
		this.ordutegia = ordutegia;
	}

	public float getPrezioa() {
		return this.prezioa;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	public String getSaila() {
		return this.saila;
	}

	public void setSaila(String saila) {
		this.saila = saila;
	}

	public float getSoldata() {
		return this.soldata;
	}

	public void setSoldata(float soldata) {
		this.soldata = soldata;
	}

	public String getTutorea() {
		return this.tutorea;
	}

	public void setTutorea(String tutorea) {
		this.tutorea = tutorea;
	}

	public EskaintzaileaE getEskaintzaileaE() {
		return this.eskaintzaileaE;
	}

	public void setEskaintzaileaE(EskaintzaileaE eskaintzaileaE) {
		this.eskaintzaileaE = eskaintzaileaE;
	}

}