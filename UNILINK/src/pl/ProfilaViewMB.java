package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.EskaintzaileaEJB;
import bl.EskatzaileaEJB;
import dl.*;

@Named
@ViewScoped
public class ProfilaViewMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ProfilaViewMB() {
		// TODO Auto-generated constructor stub
	}
	@EJB private EskaintzaileaEJB irakEJB;
	@EJB private EskatzaileaEJB ikasEJB;
	private EskaintzaileaE eskaintzaileaDB;
	private EskatzaileaE eskatzaileaDB;
	private List<EskaintzaE> irakEskaintzakDB;
	private List<ErlazioaE> ikasEskariakDB;
	
	public EskaintzaileaE irakBatenDatuakLortuDB(){
		if(eskaintzaileaDB==null) 
	    {      	
			eskaintzaileaDB=irakEJB.irakBatenDatuakLortuDB();
	    }
		return eskaintzaileaDB;
	}
	
	public EskatzaileaE ikasBatenDatuakLortuDB()
	{
		if(eskatzaileaDB==null)
		{
			eskatzaileaDB=ikasEJB.ikasBatenDatuakLortuDB();
		}
		return eskatzaileaDB;
	}
	public List<EskaintzaE> irakBatenEskaintzakLortu(){
		if(irakEskaintzakDB==null) {
			irakEskaintzakDB=irakEJB.irakBatenEskaintzakLortuDB();
		}
		return irakEskaintzakDB;
	}
	public List<ErlazioaE> ikasBatenEskariakLortu(){
		if(ikasEskariakDB==null) {
			ikasEskariakDB=ikasEJB.ikasBatenEskariakLortuDB();
		}
		return ikasEskariakDB;
	}
	public void resetView()
	{
		this.eskaintzaileaDB=null;
		this.eskatzaileaDB=null;
		this.ikasEskariakDB=null;
		this.irakEskaintzakDB=null;
	}
}
