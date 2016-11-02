/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upem.mlvBank.dao;

import com.upem.mlvBank.entities.Compte;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.logging.Logger;

/**
 *
 * @author davide
 */
@Stateless
public class CompteDAO {

    @PersistenceContext
    private EntityManager em;

    private final static Logger logger = Logger.getLogger(CompteDAO.class.getName());

    public void create(Compte compte) {
        /* persist:
            - Insert a new register to the database
            - Attach the object to the entity manager.
         */
        logger.log(Level.INFO, "Adding compte ID: " + compte.getId());
        em.persist(compte);

    }

    public void update(Compte compte) {
        /* merge:
            - Find an attached object with the same id and update it.
            - If exists update and return the already attached object.
            - If doesn't exist insert the new register to the database.
         */
        logger.log(Level.INFO, "Updating compte ID: " + compte.getId());
        em.merge(compte);

    }

    public void delete(Compte compte) {
        logger.log(Level.INFO, "Deleting compte ID: " + compte.getId());
        em.remove(compte);
    }

    public void depositMoneyTo(String accountID, String accountPSW, int amount) {
        logger.log(Level.INFO, "Depositing " + amount + " to account ID: " + accountID);
        Compte compte = getCompteBy(accountID);
        compte.depositToCompte(accountPSW, amount);
        update(compte);
    }

    public void withdrawMoneyFrom(String accountID, String accountPSW, int amount) {
        logger.log(Level.INFO, "Withdrawing " + amount + " from account ID: " + accountID);
        Compte compte = getCompteBy(accountID);
        compte.withdrawFromCompte(accountPSW, amount);
        update(compte);
    }

    public int getAccountState(String accountID, String accountPSW) {
        return getCompteBy(accountID).getAmount(accountPSW);
    }

    public List<Compte> getAllCompte() {
        TypedQuery<Compte> q = em.createQuery("select e from Compte e", Compte.class);
        return q.getResultList();
    }

    public Compte getCompteBy(String accountID) {
        Compte compte;
        TypedQuery<Compte> q = em.createQuery("select e from Compte e where e.id = '" + accountID + "'", Compte.class);

        try {
            compte = q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        return compte;
    }

    public void enableAccount(String accountID) {
        logger.log(Level.INFO, "Enabling account ID: " + accountID);
        Compte compte = getCompteBy(accountID);
        compte.EnableCompte();
        update(compte);
    }

    public void disbleAccount(String accountID) {
        logger.log(Level.INFO, "Disabling account ID: " + accountID);
        Compte compte = getCompteBy(accountID);
        compte.DisableCompte();
        update(compte);
    }
}
