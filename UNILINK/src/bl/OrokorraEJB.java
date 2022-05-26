package bl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.SecurityDomain;

import dl.*;

/**
 * Session Bean implementation class OrokorraEJB
 */
@SecurityDomain("UNILINK")
@DenyAll

@Stateless
@LocalBean
public class OrokorraEJB {
	
	@PersistenceContext private EntityManager em;
	@Resource 
	private javax.ejb.EJBContext ejbContext;

    /**
     * Default constructor. 
     */
    public OrokorraEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<EskaintzaE> eskaintzaAktiboakLortuDB(){
    	return (List<EskaintzaE>)em.createNamedQuery("EskaintzaE.eskaintzaAktiboakLortu").getResultList(); 
    }
    
    @RolesAllowed({"ikaslea","irakaslea"})
    public EskaintzaileaE eskaintzaileBatLortuDB(int idEskaintzailea) {
    	return em.find(EskaintzaileaE.class, idEskaintzailea);
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<EskatzaileaE> ikasleAutentikatutakoaLortuDB(String username) {
    	List<EskatzaileaE> eskatzaileaList=(List<EskatzaileaE>)em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", username).getResultList();
    	return eskatzaileaList;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<EskaintzaileaE> irakasleAutentikatutakoaLortuDB(String username) {
    	List<EskaintzaileaE> eskaintzaileaList=(List<EskaintzaileaE>)em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", username).getResultList();
    	return eskaintzaileaList;
    }
   
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public int autentikatutakoarenRolaLortu(String username) {
    	int rola=0;
    	List<ErabiltzaileaE> erabiltzaileList=(List<ErabiltzaileaE>)em.createNamedQuery("ErabiltzaileaE.erabLortu").setParameter("username", username).getResultList();
    	if(erabiltzaileList.size()!=0) {
    		ErabiltzaileaE erab=erabiltzaileList.get(0);
    		if(erab.getMota().equals("irakaslea")) {
    			rola=1;
    		}
    		else {
    			rola=2;
    		}
    	}
    	return rola;
    }
   
    @RolesAllowed({"ikaslea","irakaslea"})
    public EskaintzaE eskaintzaLortuDB(int idEskaintza) {
    	return em.find(EskaintzaE.class, idEskaintza);
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<KomentarioakE> komentarioakBistaratu (int idEskaintza)
    {
    	List<KomentarioakE> komentarioGuztiak = new ArrayList<KomentarioakE>();
    	List<KomentarioakE> komentarioNagusiak = new ArrayList<KomentarioakE>();
    	komentarioGuztiak=em.createNamedQuery("KomentarioakE.komentarioakLortu").setParameter("id", idEskaintza).getResultList();
    	for (int i=0; i<komentarioGuztiak.size(); i++)
    	{
    		if(komentarioGuztiak.get(i).getKomentarioakE()==null)
    		{
    			komentarioNagusiak.add(komentarioGuztiak.get(i));
    		}
    	}
    	return komentarioNagusiak;
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<KomentarioakE> komentarioarenErantzunakLortu (int idKomentarioa)
    {
    	List<KomentarioakE> erantzunak = new ArrayList<KomentarioakE>();
    	erantzunak=em.createNamedQuery("KomentarioakE.erantzunakLortu").setParameter("id", idKomentarioa).getResultList();
    	
    	return erantzunak;    	   	
    	
    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<EskaintzaE> irakEskaintzakLortuDB(int idEskaintzailea){
    	return em.createNamedQuery("EskaintzaE.irakEskaintzakLortu").setParameter("idEskaintzailea", idEskaintzailea).getResultList();
    }

    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<String> graduakLortuDB(){
    	return em.createNamedQuery("EskaintzaE.graduakLortu").getResultList();

    }
    
    @SuppressWarnings("unchecked")
    @RolesAllowed({"ikaslea","irakaslea"})
    public List<EskaintzaE> aukeratutakoEskaintzakLortuDB(String gradua){
        	return em.createNamedQuery("EskaintzaE.eskaintzaGraduaLortu").setParameter("gradua", gradua).getResultList();
    }
}
