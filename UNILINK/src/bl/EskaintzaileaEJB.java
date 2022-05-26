package bl;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.SecurityDomain;

import dl.ErabiltzaileaE;
import dl.ErlazioaE;
import dl.EskaintzaE;
import dl.EskaintzaileaE;
import dl.EskatzaileaE;
/**
 * Session Bean implementation class EskaintzaileaEJB
 */
@SecurityDomain("UNILINK")
@DenyAll

@Stateless
@LocalBean
public class EskaintzaileaEJB {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext private EntityManager em;
	@Resource 
	private javax.ejb.EJBContext ejbContext;
	
    public EskaintzaileaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("irakaslea")
   	public EskaintzaileaE irakBatenDatuakLortuDB()
       {
       	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
       	List<EskaintzaileaE> eskaintzaileaDB = (List<EskaintzaileaE>)em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", username).getResultList();
       	return eskaintzaileaDB.get(0);
       }

    @RolesAllowed("irakaslea")
    public EskatzaileaE eskaintzaileDatuakLortuDB(int idEskatzailea) {
    	return em.find(EskatzaileaE.class, idEskatzailea);
    }
    
    @RolesAllowed("irakaslea")
    public int eskariBatOnartu(int idEskaintza, int idErlazioa) {			//DEF(58)={idEskaintza, idErlazioa}, ERAB(58)={}
    	int emaitza=0;														//DEF(59)={emaitza}, ERAB(59)={}
    	EskaintzaE eskaintzaDB=em.find(EskaintzaE.class, idEskaintza);		//DEF(60)={eskaintzaDB}, ERAB(60)={idEskaintza}
    	ErlazioaE eskaria=em.find(ErlazioaE.class, idErlazioa);				//DEF(61)={eskaria}, ERAB(61)={idErlazioa}
    	if(eskaintzaDB!=null && eskaria!=null) {							//DEF(62)={}, ERAB(62)={eskaintzaDB, eskaria}
    		eskaria.setEskariaEgoera(2);									//DEF(63)={eskaria}, ERAB(63)={eskaria}
    	}																	//DEF(64)={}, ERAB(64)={}
    	else {																//DEF(65)={}, ERAB(65)={}
    		emaitza=2;														//DEF(66)={emaitza}, ERAB(66)={}
    	}																	//DEF(67)={}, ERAB(67)={}	
    	return emaitza;														//DEF(68)={}, ERAB(68)={emaitza}
    }																		//DEF(69)={}, ERAB(69)={}
    
    @RolesAllowed("irakaslea")
    public int eskariBatEzeztatu(int idEskaintza, int idErlazioa) {
    	int emaitza=0;
    	EskaintzaE eskaintzaDB=em.find(EskaintzaE.class, idEskaintza);
    	ErlazioaE eskaria=em.find(ErlazioaE.class, idErlazioa);
    	if(eskaintzaDB!=null && eskaria!=null) {
    		eskaria.setEskariaEgoera(3);
    	}
    	else {
    		emaitza=2;
    	}
    	return emaitza;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("irakaslea")
   	public List<EskaintzaE> irakBatenEskaintzakLortuDB()
       {
       	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
       	List<EskaintzaE> eskaintzakDB = (List<EskaintzaE>)em.createNamedQuery("EskaintzaE.irakEskaintzakLortuUsername").setParameter("username", username).getResultList();
       	return eskaintzakDB;
       }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("irakaslea")
    public int eskaintzaIgoDB(EskaintzaE eskaintza) {
    	int emaitza=1;
    	String autentikatutakoa=ejbContext.getCallerPrincipal().getName();   
    	List<EskaintzaileaE> eskaintzaileList=(List<EskaintzaileaE>)em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", autentikatutakoa).getResultList();
    	if(eskaintzaileList.size()==0) {
    		emaitza=2;	//ERABILTZAILEA EZ DA EXISTITZEN
    	}
    	else {
    		EskaintzaileaE eskaintzaile = eskaintzaileList.get(0);
    		eskaintza.setEskaintzaileaE(eskaintzaile);
        	em.persist(eskaintza);
    	}
    	return emaitza;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("irakaslea")
	public int irakProfilaGorde(EskaintzaileaE eskaintzaileaE) {
    	int emaitza=0;
    	List<EskaintzaileaE> eskaintzaileakDB = em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", eskaintzaileaE.getUsername()).getResultList();
    	List<ErabiltzaileaE> erabiltzaileakDB = em.createNamedQuery("ErabiltzaileaE.erabLortu").setParameter("username", eskaintzaileaE.getUsername()).getResultList();
    	ErabiltzaileaE erabiltzaileaE = erabiltzaileakDB.get(0);
    	erabiltzaileaE.setPasahitza(eskaintzaileaE.getPasahitza());
    	EskaintzaileaE eskaintzaileaDB=em.find(EskaintzaileaE.class, eskaintzaileakDB.get(0).getIdEskaintzailea());
    	eskaintzaileaE.setIdEskaintzailea(eskaintzaileakDB.get(0).getIdEskaintzailea());
    	if(eskaintzaileaDB!=null)
		{
			emaitza=1;
			em.merge(eskaintzaileaE);
			em.merge(erabiltzaileaE);
		}
		else
		{
			emaitza=2;
		}
    	return emaitza;
       }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("irakaslea")
	public int eskaintzaleaEzabatuDB()
    {
    	int kodea=0;
    	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    	List<EskaintzaileaE> eskaintzaileakDB=em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", username).getResultList();
    	List<ErabiltzaileaE> erabiltzaileakDB = em.createNamedQuery("ErabiltzaileaE.erabLortu").setParameter("username", username).getResultList();
    	EskaintzaileaE eskaintzaileaDB=eskaintzaileakDB.get(0);
    	ErabiltzaileaE erabiltzaileaDB=erabiltzaileakDB.get(0);
    	if(eskaintzaileaDB!=null)
    	{
    		em.remove(eskaintzaileaDB);
    		em.remove(erabiltzaileaDB);
    		kodea=1;
    	}
    	else
    	{
    		kodea=2;
    	}
    	return kodea;
    }
    
    @RolesAllowed("irakaslea")
    public int eskaintzaEzabatu(int idEskaintza) {
    	int kodea=0;
    	EskaintzaE eskaintzaDB=em.find(EskaintzaE.class, idEskaintza);
    	if(eskaintzaDB!=null) {
    		em.remove(eskaintzaDB);
    		kodea=1;
    	}
    	else {
    		kodea=2;
    	}
    	return kodea;
    }
    
    @RolesAllowed("irakaslea")
    public int eskaintzaEgoeraAldatu(int idEskaintza) {
    	int kodea=0;
    	EskaintzaE eskaintzaDB=em.find(EskaintzaE.class, idEskaintza);
    	if(eskaintzaDB!=null) {
    		if(eskaintzaDB.getEskaintzaEgoera()==0) {
    			eskaintzaDB.setEskaintzaEgoera(1);
    		}
    		else {
    			eskaintzaDB.setEskaintzaEgoera(0);
    		}
    		kodea=1;
    	}
    	else {
    		kodea=2;
    	}
    	return kodea;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("irakaslea")
    public List<ErlazioaE> eskariakLortuDB(int idEskaintza){
    	List<ErlazioaE> eskariakDB=(List<ErlazioaE>)em.createNamedQuery("ErlazioaE.eskaIkasLortu").setParameter("id", idEskaintza).getResultList();
    	return eskariakDB;
    }
    
}

