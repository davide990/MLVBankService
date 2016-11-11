/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upem.mlvBank.services;

import com.upem.mlvBank.dao.CompteDAO;
import com.upem.mlvBank.entities.Compte;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Davide Andrea Guastella <davide.guastella90@gmail.com>
 */
@WebService(serviceName = "BankService")
public class BankService {

    @EJB
    private CompteDAO ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "compte") Compte compte) {
        ejbRef.create(compte);
    }

    @WebMethod(operationName = "update")
    @Oneway
    public void update(@WebParam(name = "compte") Compte compte) {
        ejbRef.update(compte);
    }

    @WebMethod(operationName = "delete")
    @Oneway
    public void delete(@WebParam(name = "compte") Compte compte) {
        ejbRef.delete(compte);
    }

    @WebMethod(operationName = "depositMoneyTo")
    @Oneway
    public void depositMoneyTo(@WebParam(name = "iban") String iban, @WebParam(name = "amount") int amount) {
        ejbRef.depositMoneyTo(iban, amount);
    }

    @WebMethod(operationName = "withdrawMoneyFrom")
    @Oneway
    public void withdrawMoneyFrom(@WebParam(name = "iban") String iban, @WebParam(name = "amount") int amount) {
        ejbRef.withdrawMoneyFrom(iban, amount);
    }

    @WebMethod(operationName = "getAccountState")
    public int getAccountState(@WebParam(name = "iban") String iban) {
        return ejbRef.getAccountState(iban);
    }

    @WebMethod(operationName = "getAllCompte")
    public List<Compte> getAllCompte() {
        return ejbRef.getAllCompte();
    }

    @WebMethod(operationName = "getCompteBy")
    public Compte getCompteBy(@WebParam(name = "iban") String iban) {
        return ejbRef.getCompteByIBAN(iban);
    }

    @WebMethod(operationName = "enableAccount")
    @Oneway
    public void enableAccount(@WebParam(name = "iban") String iban) {
        ejbRef.enableAccount(iban);
    }

    @WebMethod(operationName = "disbleAccount")
    @Oneway
    public void disbleAccount(@WebParam(name = "iban") String iban) {
        ejbRef.disableAccount(iban);
    }

}
