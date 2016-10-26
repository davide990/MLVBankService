/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upem.mlvBank.dao;

import com.upem.mlvBank.entities.Compte;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author davide
 */
@Stateless
public class CompteDAO {//extends AbstractFacade<Compte> {

    @PersistenceContext//(unitName = "mlvBankPU")
    private EntityManager em;
//
//    public CompteDAO() {
//        super(Compte.class);
//    }
//
//    public CompteDAO(Class<Compte> entityClass) {
//        super(entityClass);
//    }
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
    public void create(Compte compte) {
        em.persist(compte);
    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    @Path("{id}")
//    public Compte read(@PathParam("id") long id) {
//        return em.find(Compte.class, id);
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void update(Compte customer) {
//        em.merge(customer);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void delete(@PathParam("id") long id) {
//        Compte customer = read(id);
//        if (null != customer) {
//            em.remove(customer);
//        }
//    }

}
