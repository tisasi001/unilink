package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.OrokorraEJB;
import dl.*;

@Named
@ViewScoped
public class EskaintzaileaViewMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EskaintzaileaE eskaintzaileaDB;
	private List<EskaintzaE> eskaintzakDB;
	
	@EJB private OrokorraEJB oEJB;

	public EskaintzaileaViewMB() {
		// TODO Auto-generated constructor stub
	}
	
	public EskaintzaileaE irakProfilaLortu(int idEskaintzailea) {
		if(eskaintzaileaDB==null) {
			eskaintzaileaDB=oEJB.eskaintzaileBatLortuDB(idEskaintzailea);
		}
		return eskaintzaileaDB;
	}
	public List<EskaintzaE> irakEskaintzakLortu(int idEskaintzailea){
		if(eskaintzakDB==null) {
			eskaintzakDB=oEJB.irakEskaintzakLortuDB(idEskaintzailea);
		}
		return eskaintzakDB;
	}

	public EskaintzaileaE getEskaintzaileaDB() {
		return eskaintzaileaDB;
	}

	public void setEskaintzaileaDB(EskaintzaileaE eskaintzaileaDB) {
		this.eskaintzaileaDB = eskaintzaileaDB;
	}
	public void resetView() {
		this.eskaintzaileaDB=null;
	}

}
