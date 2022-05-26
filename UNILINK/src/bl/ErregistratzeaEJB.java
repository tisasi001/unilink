package bl;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.ErabiltzaileaE;
import dl.EskaintzaileaE;
import dl.EskatzaileaE;

/**
 * Session Bean implementation class ErregistratzeaEJB
 */
@Stateless
@LocalBean
public class ErregistratzeaEJB {

	@PersistenceContext private EntityManager em;
	@Resource 
	private javax.ejb.EJBContext ejbContext;

    /**
     * Default constructor. 
     */
    public ErregistratzeaEJB() {
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unchecked")
	public int eskaintzaileaErregistratuDB(EskaintzaileaE eskaintzaileaE)
    {
    	int kodea=0;
    	List<EskaintzaileaE> eskaintzaileaDB=em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", eskaintzaileaE.getUsername()).getResultList();
    	List<EskatzaileaE> eskatzaileaDB=em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", eskaintzaileaE.getUsername()).getResultList();
    	if(eskaintzaileaDB.isEmpty() && eskatzaileaDB.isEmpty())
    	{
    		kodea=1;
    		em.persist(eskaintzaileaE);
    		ErabiltzaileaE erabiltzaileaE=new ErabiltzaileaE(0, "irakaslea", eskaintzaileaE.getPasahitza(), eskaintzaileaE.getUsername());
    		em.persist(erabiltzaileaE);
    	}
    	else 
    	{
    		kodea=2;
    	}
    	return kodea;
    }
    
    @SuppressWarnings("unchecked")
	public int eskatzaileaErregistratuDB(EskatzaileaE eskatzaileaE)
    {
    	int kodea=0;
    	List<EskatzaileaE> eskatzaileaDB=em.createNamedQuery("EskatzaileaE.eskatzaileBatLortu").setParameter("username", eskatzaileaE.getUsername()).getResultList();
    	List<EskaintzaileaE> eskaintzaileaDB=em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", eskatzaileaE.getUsername()).getResultList();
    	if(eskatzaileaDB.isEmpty() && eskaintzaileaDB.isEmpty())
    	{
    		kodea=1;
    		em.persist(eskatzaileaE);
    		ErabiltzaileaE erabiltzaileaE=new ErabiltzaileaE(0, "ikaslea", eskatzaileaE.getPasahitza(), eskatzaileaE.getUsername());
    		em.persist(erabiltzaileaE);
    	}
    	else
    	{
    		kodea=2;
    	}
    	return kodea;
    }
    @SuppressWarnings("unchecked")
    public EskaintzaileaE erregistratutakoEskaintzaileaLortu(String username) {
    	List<EskaintzaileaE> eskaintzaileaDB=em.createNamedQuery("EskaintzaileaE.eskaintzaileBatLortu").setParameter("username", username).getResultList();
    	return eskaintzaileaDB.get(0);
    }

}
