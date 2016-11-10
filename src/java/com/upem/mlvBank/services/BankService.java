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
    public void depositMoneyTo(@WebParam(name = "accountID") String accountID, @WebParam(name = "accountPSW") String accountPSW, @WebParam(name = "amount") int amount) {
        ejbRef.depositMoneyTo(accountID, accountPSW, amount);
    }

    @WebMethod(operationName = "withdrawMoneyFrom")
    @Oneway
    public void withdrawMoneyFrom(@WebParam(name = "accountID") String accountID, @WebParam(name = "accountPSW") String accountPSW, @WebParam(name = "amount") int amount) {
        ejbRef.withdrawMoneyFrom(accountID, accountPSW, amount);
    }

    @WebMethod(operationName = "getAccountState")
    public int getAccountState(@WebParam(name = "accountID") String accountID, @WebParam(name = "accountPSW") String accountPSW) {
        return ejbRef.getAccountState(accountID, accountPSW);
    }

    @WebMethod(operationName = "getAllCompte")
    public List<Compte> getAllCompte() {
        return ejbRef.getAllCompte();
    }

    @WebMethod(operationName = "getCompteBy")
    public Compte getCompteBy(@WebParam(name = "accountID") String accountID) {
        return ejbRef.getCompteBy(accountID);
    }

    @WebMethod(operationName = "enableAccount")
    @Oneway
    public void enableAccount(@WebParam(name = "accountID") String accountID) {
        ejbRef.enableAccount(accountID);
    }

    @WebMethod(operationName = "disbleAccount")
    @Oneway
    public void disbleAccount(@WebParam(name = "accountID") String accountID) {
        ejbRef.disableAccount(accountID);
    }
    
}
