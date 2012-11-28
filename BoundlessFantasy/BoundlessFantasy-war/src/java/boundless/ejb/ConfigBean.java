/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import boundless.entities.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
/**
 *
 * @author Matt
 */
@Singleton
@LocalBean
public class ConfigBean {
    private static final Logger logger = Logger.getLogger(
                "dukestutoring.ejb.ConfigBean");
    
    private CriteriaBuilder cb;
    @PersistenceContext
    private EntityManager em;
    @EJB
    private AdminBean adminBean;
    @EJB
    private RequestBean requestBean;

    @PostConstruct
    public void init() {
        cb = em.getCriteriaBuilder();
        
        // create Matt
        logger.info("Creating Matt entity");
        
        Account matt = new Account();
        matt.setFirstname("Matt");
        matt.setLastname("Krupin");
        matt.setEmail("mjkupin@gmail.com");
        matt.setUsername("boundsoft");
        matt.setPassword("boundless");
        
        
        logger.info("Calling createStudent() on Matt");
        String result = adminBean.createAccount(matt);
    }
}
