/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upem.mlvBank.services;

import com.upem.mlvBank.entities.Compte;
import com.upem.mlvBank.dao.CompteDAO;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author davide
 */
@WebService(serviceName = "BankService")
public class BankService {

    @Inject
    private CompteDAO compteDAO;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "WithdrawMoney")
    public boolean WithdrawMoney(@WebParam(name = "WithDrawMoneyAccountID") String AccountID,
            @WebParam(name = "WithDrawMoneyOwnerPassword") String OwnerPassword,
            @WebParam(name = "WithDrawMoneyAmount") int Amount) {
        if (compteDAO.getCompteBy(AccountID) == null) {
            return false;
        }

        compteDAO.withdrawMoneyFrom(AccountID, OwnerPassword, Amount);
        //comptes.get(AccountID).withdrawFromCompte(OwnerPassword, Amount);

        //LOG HERE
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AccountState")
    public int AccountState(@WebParam(name = "AccountStateAccountID") String AccountID,
            @WebParam(name = "AccountStateOwnerPassword") String OwnerPassword) {
        if (compteDAO.getCompteBy(AccountID) == null) {
            return -1;
        }

        return compteDAO.getAccountState(AccountID, OwnerPassword);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DepositMoney")
    public boolean DepositMoney(@WebParam(name = "DepositMoneyAccountID") String AccountID,
            @WebParam(name = "DepositMoneyOwnerPassword") String OwnerPassword,
            @WebParam(name = "DepositMoneyAmount") int Amount) {
        if (compteDAO.getCompteBy(AccountID) == null) {
            return false;
        }

        compteDAO.depositMoneyTo(AccountID, OwnerPassword, Amount);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "OpenNewAccount")
    public String OpenNewAccount(@WebParam(name = "OpenAccountOwnerPassword") String OwnerPassword,
            @WebParam(name = "OpenNewAccountInitialAmount") int InitialAmount) {
        Compte newCompte = new Compte();
        newCompte.EnableCompte();
        newCompte.setComptePassword("", OwnerPassword);
        newCompte.depositToCompte(OwnerPassword, InitialAmount);

        compteDAO.create(newCompte);

        return newCompte.getId();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListAccounts")
    public List<Compte> ListAccounts() {
        return compteDAO.getAllCompte();
    }

    /**
     * Web service operation
     */
//    @WebMethod(operationName = "DisableAccount")
//    public int DisableAccount(@WebParam(name = "DisableAccountAccountID") String AccountID, @WebParam(name = "DisableAccountOwnerPassword") String OwnerPassword) {
//        //TODO write your implementation code here:
//        return 0;
//    }
}
