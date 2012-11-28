/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import boundless.entities.*;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Matt
 */
@Stateless
@LocalBean
public class AdminBean {

    private static final Logger logger = Logger.getLogger(
                "dukestutoring.ejb.AdminBean");
    private CriteriaBuilder cb;
    @PersistenceContext
    private EntityManager em;
    private String username;

    @PostConstruct
    private void init() {
        cb = em.getCriteriaBuilder();
    }

    public String createAccount(Account account) {
        em.persist(account);

        return "createdAccount";
    }

}
