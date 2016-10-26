/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upem.project;

import com.davide.test.Compte;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author davide
 */
@WebService(serviceName = "BankService")
public class BankService {

    //private final HashMap<int, int> ints;
    public BankService() {
//        ints = new HashMap<>();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "WithdrawMoney")
    public Compte WithdrawMoney(@WebParam(name = "WithDrawMoneyAccountID") int AccountID, @WebParam(name = "WithDrawMoneyOwnerPassword") String OwnerPassword, @WebParam(name = "WithDrawMoneyAmount") int Amount) {
//        if (!ints.containsKey(AccountID)) {
//            return -1;
//        }

        //ints.get(AccountID).withdraw(Amount);
        return new Compte();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AccountState")
    public int AccountState(@WebParam(name = "AccountStateAccountID") Compte AccountID, @WebParam(name = "AccountStateOwnerPassword") String OwnerPassword) {
//        if (!ints.containsKey(AccountID)) {
//            return -1;
//        }

        return 150;//ints.get(AccountID).getMoneyAmount();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DepositMoney")
    public boolean DepositMoney(@WebParam(name = "DepositMoneyAccountID") String AccountID, @WebParam(name = "DepositMoneyOwnerPassword") String OwnerPassword, @WebParam(name = "DepositMoneyAmount") int Amount) {
//        if (!ints.containsKey(AccountID)) {
//            return false;
//        }

        //ints.get(AccountID).deposit(Amount);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "OpenNewAccount")
    public boolean OpenNewAccount(@WebParam(name = "OpenAccountOwnerPassword") String OwnerPassword, @WebParam(name = "OpenNewAccountInitialAmount") int InitialAmount) {
        //TODO write your implementation code here:
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DisableAccount")
    public int DisableAccount(@WebParam(name = "DisableAccountAccountID") int AccountID, @WebParam(name = "DisableAccountOwnerPassword") String OwnerPassword) {
        //TODO write your implementation code here:
        return 0;
    }
}
