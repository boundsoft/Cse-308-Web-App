/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import boundless.entities.*;
import boundless.scheduler.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Matt
 */
//@Stateless
@Singleton
@Named
//@LocalBean
public class RequestBean {

    private static final Logger logger = Logger.getLogger(
                "boundless.ejb.RequestBean");
    @Resource
    SessionContext ctx;
    private CriteriaBuilder cb;
    @PersistenceContext
    private EntityManager em;

    
    //Constructor to emulate BookRequestBean
    /*public RequestBean() throws Exception {
        
    }*/
    
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
    
    public League getLeague(int lid) {
        return em.find(League.class, lid);
    }
    
    public List<Team> getAllTeamsInLeague(League l) {
        int leagueId = l.getId();
        CriteriaQuery<Team> cq = em.getCriteriaBuilder().createQuery(Team.class);
        Root<Team> team = cq.from(Team.class);
        //EntityType<PlayerAssignment> PlayerAssignment_ = playerAssignment.getModel();
        Metamodel m = em.getMetamodel();
        EntityType<Team> Team_ = m.entity(Team.class);
        cq.select(team);
        cq.where(
                cb.equal(team.get(Team_.getSingularAttribute("League", Integer.class)),
                l.getId()));
        TypedQuery<Team> q = em.createQuery(cq);
        
        return q.getResultList();   
    }
    
    public int getNumTeamsInLeague(League l) {
        Numteamsperleague number = em.find(Numteamsperleague.class, l);
        if (number == null)
            return -1;
        return number.getNumteams();
    }
    
    /**
     * Loads a new schedule into the Game History module, to be updated when games are actually played
     * @param l
     * @param schedule 
     */
    public void makeSchedule(League l, HashMap<Integer, ArrayList<TeamPair>> schedule) {
        int leagueId = l.getId();
        Set<Integer> weeks = schedule.keySet();
        for (Integer w : weeks) {
            ArrayList<TeamPair> games = schedule.get(w);
            for (int i = 0; i < games.size(); i++) {
                TeamPair curGame = games.get(i);
                GameHistory gh = new GameHistory(curGame.first().getId(), curGame.second().getId(), w, leagueId);
                em.persist(gh);
            }
        }
    }
    
    /**
     * Validates that there the number of players of a particular position on a team is valid under NFL rules
     * @param n : The number of players of that position
     * @param p : The position being played
     * @return : True if number of players is valid, false otherwise
     */
   /** public boolean validatePositionNumbers(int n, PlayPosition p) {
     
    }*/
    
    /**
     * Returns all players with the given name
     * @param name : The name to searc for
     * @return : A list of all players with that name
     */
    public List<Player> getPlayerByName(String name) {
        CriteriaQuery<Player> cq = em.getCriteriaBuilder().createQuery(Player.class);
        
        Root<Player> player = cq.from(Player.class);
        Metamodel m = em.getMetamodel();
        EntityType<Player> Player_ = m.entity(Player.class);
        cq.select(player);
        cq.where(
                cb.equal(
                player.get(Player_.getSingularAttribute("Name", Integer.class)),
                name));
        TypedQuery<Player> q = em.createQuery(cq);
        
        return q.getResultList();
    } 
    
    public List<Player> getPlayerByNameAndPosition(String name, PlayPosition p) {
        int pId = p.getId();
        
        CriteriaQuery<Player> cq = em.getCriteriaBuilder().createQuery(Player.class);
        
        Root<Player> player = cq.from(Player.class);
        Metamodel m = em.getMetamodel();
        EntityType<Player> Player_ = m.entity(Player.class);
        cq.select(player);
        cq.where(
                cb.equal(
                player.get(Player_.getSingularAttribute("Name", Integer.class)),
                name),
                cb.equal(
                player.get(Player_.getSingularAttribute("Play_Position", Integer.class)),
                pId));
        TypedQuery<Player> q = em.createQuery(cq);
        
        return q.getResultList();
    }
    public boolean assignPlayerToTeam(Player p, Team t, League l, short a) {

        
        if(isPlayerAssignedToLeague(p, l)) {
            return false;
        }
        
        //Create the new assignment and persist it to the db
        PlayerAssignment assignment = new PlayerAssignment(p, t, l, a);
        em.persist(assignment);
        
        return true;
    }
    
    public List<Player> getAllPlayersOfPosition(PlayPosition p) {
        
        int pId = p.getId();
        CriteriaQuery<Player> cq = em.getCriteriaBuilder().createQuery(Player.class);
        Root<Player> player = cq.from(Player.class);
        Metamodel m = em.getMetamodel();
        EntityType<Player> Player_ = m.entity(Player.class);
        cq.select(player);
        cq.where(
                cb.equal(
                player.get(Player_.getSingularAttribute("Play_Position", Integer.class)),
                pId));
        TypedQuery<Player> q = em.createQuery(cq);
        
        return q.getResultList();
    }

    
    public boolean isPlayerAssignedToLeague(Player p, League l) {
  
        
        int leagueId = l.getId();
        int playerId = p.getId();
        
        CriteriaQuery<PlayerAssignment> cq = em.getCriteriaBuilder().createQuery(PlayerAssignment.class);
        Root<PlayerAssignment> playerAssignment = cq.from(PlayerAssignment.class);
        Metamodel m = em.getMetamodel();
        EntityType<PlayerAssignment> PlayerAssignment_ = m.entity(PlayerAssignment.class);
        cq.select(playerAssignment);
        cq.where(
                cb.equal(
                playerAssignment.get(PlayerAssignment_.getSingularAttribute("League_Id", Integer.class)),
                leagueId),
                cb.equal(
                playerAssignment.get(PlayerAssignment_.getSingularAttribute("Player_Id", Integer.class)),
                playerId));
        TypedQuery<PlayerAssignment> q = em.createQuery(cq);
        
        try {
            q.getSingleResult();
        }
        catch(NoResultException ne) {
            return false;
        }
        return true;
    }
    
    public List<PlayerAssignment> getAllAssignmentsFromLeague(League l) {
        int leagueId = l.getId();
        CriteriaQuery<PlayerAssignment> cq = em.getCriteriaBuilder().createQuery(PlayerAssignment.class);
        Root<PlayerAssignment> playerAssignment = cq.from(PlayerAssignment.class);
        //EntityType<PlayerAssignment> PlayerAssignment_ = playerAssignment.getModel();
        Metamodel m = em.getMetamodel();
        EntityType<PlayerAssignment> PlayerAssignment_ = m.entity(PlayerAssignment.class);
        cq.select(playerAssignment);
        cq.where(
                cb.equal(playerAssignment.get(PlayerAssignment_.getSingularAttribute("League_Id", Integer.class)),
                l.getId()));
        TypedQuery<PlayerAssignment> q = em.createQuery(cq);
        
        return q.getResultList();   
        
    }
}
