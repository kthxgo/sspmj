/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import database.Partei;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jeff
 */
@ManagedBean(name = "parteienTableBean")
@RequestScoped
public class managed_bean_politiker {

    /**
     * Creates a new instance of managed_bean_politiker
     */
    public managed_bean_politiker() {
        
    }
    
    private List<Partei> parteiList;
    
    public List<Partei> getParteiList() {
        if(parteiList == null) {
            initList();
        }
        return parteiList;
    }

    private void initList() {
        parteiList = new ArrayList<>();
        //SQL
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BundestagAppPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Partei> cq = cb.createQuery(Partei.class);
        Root<Partei> rootEntry = cq.from(Partei.class);
        CriteriaQuery<Partei> all = cq.select(rootEntry);
        TypedQuery<Partei> allQuery = em.createQuery(all);
        
        parteiList = allQuery.getResultList();
    }
    
}
