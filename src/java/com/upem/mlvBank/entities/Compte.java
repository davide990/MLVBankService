/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upem.mlvBank.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author davide
 */
@Entity
@Table(name = "compte")
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long persistence_id;
    @Column(name = "amount")
    private int amount;
    @Column(name = "compteID")
    private final String id;
    @Column(name = "disabled")
    private boolean disabled;
    @Column(name = "owner")
    private String owner;
    @Column(name = "comptePassword")
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
