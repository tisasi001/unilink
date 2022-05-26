package pl;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.EskaintzaileaEJB;
import bl.OrokorraEJB;
import dl.ErlazioaE;
import dl.EskaintzaE;
import dl.KomentarioakE;

import java.io.Serializable;


@Named
@ViewScoped
public class EskaintzakViewMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EskaintzaE eskaintzaDB;
	private List<KomentarioakE> komentarioakDB;
	private List<KomentarioakE> erantzunakDB;
	private List<ErlazioaE> eskariakDB;
	@EJB private OrokorraEJB oEJB;
	@EJB private EskaintzaileaEJB eEJB;
	
	public EskaintzakViewMB() {
		// TODO Auto-generated constructor stub
	}
	
	public EskaintzaE eskaintzaLortuDB(int idEskaintza) {
		if(eskaintzaDB==null) {
			eskaintzaDB=oEJB.eskaintzaLortuDB(idEskaintza);
		}
		return eskaintzaDB;
	}
	public List<KomentarioakE> komentarioakLortuDB(int idEskaintza) {
		if(komentarioakDB==null) 
        {      	
        	komentarioakDB=oEJB.komentarioakBistaratu(idEskaintza);
        }
        return komentarioakDB;
    }
	public List<KomentarioakE> erantzunakLortuDB(int idKomentarioa){	
		erantzunakDB=oEJB.komentarioarenErantzunakLortu(idKomentarioa);
        return erantzunakDB;
	}
	public List<ErlazioaE> eskariakLortuDB(int idEskaintza){
		if(eskariakDB==null) {
			eskariakDB=eEJB.eskariakLortuDB(idEskaintza);
		}
		return eskariakDB;
	}
	
	public List<ErlazioaE> getEskariakDB() {
		return eskariakDB;
	}

	public void setEskariakDB(List<ErlazioaE> eskariakDB) {
		this.eskariakDB = eskariakDB;
	}

	public EskaintzaE getEskaintzaDB() {
		return eskaintzaDB;
	}

	public void setEskaintzaDB(EskaintzaE eskaintzaDB) {
		this.eskaintzaDB = eskaintzaDB;
	}

	public List<KomentarioakE> getKomentarioakDB() {
		return komentarioakDB;
	}

	public void setKomentarioakDB(List<KomentarioakE> komentarioakDB) {
		this.komentarioakDB = komentarioakDB;
	}
	
	public List<KomentarioakE> getErantzunakDB() {
		return erantzunakDB;
	}

	public void setErantzunakDB(List<KomentarioakE> erantzunakDB) {
		this.erantzunakDB = erantzunakDB;
	}

	public void resetView() {
    	this.eskaintzaDB=null;
    	this.komentarioakDB=null;
    	this.erantzunakDB=null;
    	this.eskariakDB=null;
    }

}
