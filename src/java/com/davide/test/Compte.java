/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davide.test;

import java.util.UUID;

/**
 *
 * @author davide
 */
public class Compte {

    private int amount;
    private final String id;
    private boolean disabled;
    private String owner;
    private String comptePassword;

    public Compte() {
        disabled = true;
        amount = 0;
        comptePassword = "";
        id = UUID.randomUUID().toString();
    }

    public void EnableCompte() {
        disabled = true;
    }

    public void DisableCompte() {
        disabled = false;
    }

    public String getId() {
        String a = id;
        return a;
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
        if (disabled) {
            return;
        }

        if (!ComptePassword.equals(this.comptePassword)) {
            return;
        }

        amount += amountToDeposit;
    }

    public void withdrawFromCompte(String ComptePassword, int amountToWithdraw) {
        if (disabled) {
            return;
        }

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
