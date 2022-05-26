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

import dl.*;

/**
 * Session Bean implementation class EskatzaileaEJB
 */
@SecurityDomain("UNILINK")
@DenyAll

@Stateless
@LocalBean
public class EskatzaileaEJB {
	@PersistenceContext private EntityManager em;
	@Resource 
	private javax.ejb.EJBContext ejbContext;

    /**
     * Default constructor. 
     */
    public EskatzaileaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
	public EskatzaileaE ikasBatenDatuakLortuDB()
    {
    	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    	List<EskatzaileaE> eskatzaileaDB = (List<EskatzaileaE>)em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", username).getResultList();
    	return eskatzaileaDB.get(0);
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
    public List<ErlazioaE> ikasBatenEskariakLortuDB(){
    	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    	List<EskatzaileaE> eskatzaileaList = (List<EskatzaileaE>)em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", username).getResultList();
    	int idEskatzailea = eskatzaileaList.get(0).getIdEskatzailea();
    	List<ErlazioaE> eskariakDB = (List<ErlazioaE>)em.createNamedQuery("ErlazioaE.ikasEskariakLortu").setParameter("idEskatzailea", idEskatzailea).getResultList();
    	return eskariakDB;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
    public int eskariBatEgin(int idEskaintza, String username) {
    	int emaitza=1;
    		EskaintzaE eskaintzaDB=em.find(EskaintzaE.class, idEskaintza);
    		List<EskatzaileaE> ikasleList=(List<EskatzaileaE>)em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", username).getResultList();
    		if(eskaintzaDB==null || ikasleList.size()==0 || eskaintzaDB.getEskaintzaEgoera()==0) {
    			emaitza=2;	//ESKAINTZA EZ DAGO JADANIK DBan EDO INAKTIBO DAGO EDO ESKATZAILEA EZ DAGO DBan
    		}
    		else {
    			EskatzaileaE ikasle=ikasleList.get(0);
    			ErlazioaE erlazioa=new ErlazioaE(0,1,eskaintzaDB,ikasle);
    			em.persist(erlazioa);
    		}
    	return emaitza;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
   	public int ikasProfilaGorde(EskatzaileaE eskatzaileaE) {
       	int emaitza=0;
       	List<EskatzaileaE> eskatzaileakDB = em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", eskatzaileaE.getUsername()).getResultList();
       	List<ErabiltzaileaE> erabiltzaileakDB = em.createNamedQuery("ErabiltzaileaE.erabLortu").setParameter("username", eskatzaileaE.getUsername()).getResultList();
       	EskatzaileaE eskatzaileaDB=em.find(EskatzaileaE.class, eskatzaileakDB.get(0).getIdEskatzailea());
       	eskatzaileaE.setIdEskatzailea(eskatzaileakDB.get(0).getIdEskatzailea());
       	ErabiltzaileaE erabiltzaileaE=erabiltzaileakDB.get(0);
       	erabiltzaileaE.setPasahitza(eskatzaileaE.getPasahitza());
       	if(eskatzaileaDB!=null)
   		{
   			emaitza=1;
   			em.merge(eskatzaileaE);
   			em.merge(erabiltzaileaE);
   		}
   		else
   		{
   			emaitza=2;
   		}
       	return emaitza;
       }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
    public List<ErlazioaE> autentikatutakoarenEskariakLortu(String username) {
		return (List<ErlazioaE>)em.createNamedQuery("ErlazioaE.ikasEskariakLortu").setParameter("username", username).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
	public int eskatzaileaEzabatuDB()
    {
    	int kodea=0;
    	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    	List<EskatzaileaE> eskatzaileakDB=em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", username).getResultList();
    	List<ErabiltzaileaE> erabiltzaileakDB = em.createNamedQuery("ErabiltzaileaE.erabLortu").setParameter("username", username).getResultList();
    	EskatzaileaE eskatzaileaDB=eskatzaileakDB.get(0);
    	ErabiltzaileaE erabiltzaileaDB=erabiltzaileakDB.get(0);
    	if(eskatzaileaDB!=null)
    	{
    		em.remove(eskatzaileaDB);
    		em.remove(erabiltzaileaDB);
    		kodea=1;
    	}
    	else
    	{
    		kodea=2;
    	}
    	return kodea;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
	public void komentarioaSartuDB(KomentarioakE komentarioaE)
    {
    	String autentikatutakoa=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    	
    	List<EskatzaileaE> eskatzaileakDB = em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", autentikatutakoa).getResultList();
    	
    	komentarioaE.setEskatzaileaE(eskatzaileakDB.get(0));
    	
    	em.persist(komentarioaE);
    }

    @SuppressWarnings("unchecked")
    @RolesAllowed("ikaslea")
    public int eskariaDuen(int idEskaria)
    {
    	int n = 0; //ikasle honek ez du eskari hau egin
    	String username=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
    	List<EskatzaileaE> eskatzaileaList = (List<EskatzaileaE>)em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", username).getResultList();
    	int idEskatzailea = eskatzaileaList.get(0).getIdEskatzailea();
    	List<ErlazioaE> eskariakDB = (List<ErlazioaE>)em.createNamedQuery("ErlazioaE.ikasEskariakLortu").setParameter("idEskatzailea", idEskatzailea).getResultList();
    	for(int i=0; i<eskariakDB.size(); i++)
    	{
    		if(idEskaria==eskariakDB.get(i).getEskaintzaE().getIdEskaintza())
    		{
    			n=1; //ikasle honek eskaintza hau eginda dauka
    		}
    	}
    	return n;    	
    }

}
