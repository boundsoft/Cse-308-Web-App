/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import boundless.entities.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Matt
 */
@Stateless
@LocalBean
public class RequestBean {

    private static final Logger logger = Logger.getLogger(
                "boundless.ejb.RequestBean");
    @Resource
    SessionContext ctx;
    private CriteriaBuilder cb;
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void init() {
        cb = em.getCriteriaBuilder();
    }

    public String logIn(Account acc) {
        
        return null;
    }
    
    public String register(Account acc) {
        
        return null;
    }
}
