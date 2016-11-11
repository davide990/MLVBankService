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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    public void depositMoneyTo(String iban, int amount) {
        logger.log(Level.INFO, "Depositing " + amount + " to account ID: " + iban);
        Compte compte = getCompteByIBAN(iban);
        compte.depositToCompte(amount);
        update(compte);
    }

    public void withdrawMoneyFrom(String iban, int amount) {
        logger.log(Level.INFO, "Withdrawing " + amount + " from account ID: " + iban);
        Compte compte = getCompteByIBAN(iban);
        compte.withdrawFromCompte(amount);
        update(compte);
    }

    public int getAccountState(String iban) {
        return getCompteByIBAN(iban).getAmount();
    }

    public List<Compte> getAllCompte() {
        /*TypedQuery<Compte> q = em.createQuery("select e from Compte e", Compte.class);
        return q.getResultList();*/
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Compte> compte = builder.createQuery(Compte.class);

        Root<Compte> compteRoot = compte.from(Compte.class); //ROOT
        compte.select(compteRoot);
        TypedQuery<Compte> pp = em.createQuery(compte);
        return pp.getResultList();

    }

    public Compte getCompteByIBAN(String iban) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Compte> compte = builder.createQuery(Compte.class);

        Root<Compte> compteRoot = compte.from(Compte.class); //ROOT

        Predicate pd = builder.equal(compteRoot.get("iban"), iban);

        compte.select(compteRoot).where(pd);
        TypedQuery<Compte> pp = em.createQuery(compte);
        return (Compte) pp.getSingleResult();
    }

    public void enableAccount(String iban) {
        logger.log(Level.INFO, "Enabling account ID: " + iban);
        Compte compte = getCompteByIBAN(iban);
        compte.EnableCompte();
        update(compte);
    }

    public void disableAccount(String iban) {
        logger.log(Level.INFO, "Disabling account ID: " + iban);
        Compte compte = getCompteByIBAN(iban);
        compte.DisableCompte();
        update(compte);
    }
}
