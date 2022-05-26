package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.EskatzaileaEJB;
import bl.OrokorraEJB;
import dl.EskaintzaE;

@Named
@ViewScoped
public class EskaintzaAktiboakViewMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<EskaintzaE> eskaintzaAktiboakDB;
	private List<String> graduakDB;
	@EJB private OrokorraEJB oEJB;
	@EJB private EskatzaileaEJB eEJB;
	
	public List<EskaintzaE> eskaintzaAktiboakLortuDB(){
		if(eskaintzaAktiboakDB==null) 
        {      	
			eskaintzaAktiboakDB=oEJB.eskaintzaAktiboakLortuDB();
        }
      return eskaintzaAktiboakDB;
	}
	
	public List<String> graduakLortuDB(){
		if(graduakDB==null) {
			graduakDB=oEJB.graduakLortuDB();
		}
		return graduakDB;
	}
	
	public List<EskaintzaE> getEskaintzaAktiboakDB() {
		return eskaintzaAktiboakDB;
	}

	public void setEskaintzaAktiboakDB(List<EskaintzaE> eskaintzaAktiboakDB) {
		this.eskaintzaAktiboakDB = eskaintzaAktiboakDB;
	}

	public List<String> getGraduakDB() {
		return graduakDB;
	}

	public void setGraduakDB(List<String> graduakDB) {
		this.graduakDB = graduakDB;
	}
	public void resetView() {
		this.eskaintzaAktiboakDB=null;
		this.graduakDB=null;
	}
}
