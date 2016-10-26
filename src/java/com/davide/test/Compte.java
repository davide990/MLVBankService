/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davide.test;

/**
 *
 * @author davide
 */
public class Compte {

    private int amount;
    private int id;
    private String owner;
    private String comptePassword;

    public Compte() {
        amount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner(String ComptePassword) {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setComptePassword(String oldComptePassword, String newComptePassword) {

        if (!oldComptePassword.equals(comptePassword)) {
            return;
        }

        this.comptePassword = newComptePassword;
    }

    public void depositToCompte(String ComptePassword, int amountToDeposit) {
        if (!ComptePassword.equals(this.comptePassword)) {
            return;
        }

        amount += amountToDeposit;
    }

    public void withdrawFromCompte(String ComptePassword, int amountToWithdraw) {
        if (!ComptePassword.equals(this.comptePassword)) {
            return;
        }

        amount -= amountToWithdraw;
    }

    public int getAmount(String ComptePassword) {
        int a = amount;
        return a;
    }

}
