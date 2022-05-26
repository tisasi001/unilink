package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.EskaintzaileaEJB;
import dl.EskatzaileaE;

@Named
@ViewScoped
public class EskatzaileaViewMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EskatzaileaE eskatzaileaDB;
	@EJB private EskaintzaileaEJB eEJB;

	public EskatzaileaViewMB() {
		// TODO Auto-generated constructor stub
	}
	public EskatzaileaE eskaintzaileDatuakLortuDB(int idEskatzailea) {
		if(eskatzaileaDB==null) {
			eskatzaileaDB=eEJB.eskaintzaileDatuakLortuDB(idEskatzailea);
		}
		return eskatzaileaDB;
	}
	public EskatzaileaE getEskatzaileaDB() {
		return eskatzaileaDB;
	}
	public void setEskatzaileaDB(EskatzaileaE eskatzaileaDB) {
		this.eskatzaileaDB = eskatzaileaDB;
	}
	
}
