package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.OrokorraEJB;
import dl.EskaintzaE;

@Named
@ViewScoped
public class BilaketaViewMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EskaintzaE> aukeratutakoEskaintzakDB;
	@EJB private OrokorraEJB oEJB;

	public BilaketaViewMB() {
		// TODO Auto-generated constructor stub
	}

	public List<EskaintzaE> getAukeratutakoEskaintzakDB() {
		return aukeratutakoEskaintzakDB;
	}

	public void setAukeratutakoEskaintzakDB(List<EskaintzaE> aukeratutakoEskaintzakDB) {
		this.aukeratutakoEskaintzakDB = aukeratutakoEskaintzakDB;
	}
	public List<EskaintzaE> aukeratutakoEskaintzakLortuDB(String gradua){
		if(aukeratutakoEskaintzakDB==null) {
			aukeratutakoEskaintzakDB=oEJB.aukeratutakoEskaintzakLortuDB(gradua);
		}
		return aukeratutakoEskaintzakDB;
	}
	public void resetView() {
		this.aukeratutakoEskaintzakDB=null;
	}

}