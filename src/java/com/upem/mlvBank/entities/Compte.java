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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davide
 */
@Entity
@Table(name = "compte")
@XmlRootElement
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "amount")
    private int amount;
    @Column(name = "iban")
    private String iban;
    @Column(name = "disabled")
    private boolean disabled;
    @Column(name = "ownerFirstName")
    private String ownerFirstName;
    @Column(name = "ownerLastName")
    private String ownerLastName;
    @Column(name = "comptePassword")
    private String comptePassword;
    @Column(name = "currency")
    private String currency;

    public Compte() {
        disabled = false;
        amount = 0;
        comptePassword = "";
        iban = UUID.randomUUID().toString();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getComptePassword() {
        return comptePassword;
    }

    public void setComptePassword(String comptePassword) {
        this.comptePassword = comptePassword;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void EnableCompte() {
        disabled = true;
    }

    public void DisableCompte() {
        disabled = false;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public void setComptePassword(String oldComptePassword, String newComptePassword) {

        if (!oldComptePassword.equals(comptePassword)) {
            return;
        }

        this.comptePassword = newComptePassword;
    }

    public void depositToCompte(int amountToDeposit) {
        if (disabled) {
            return;
        }

        amount += amountToDeposit;
    }

    public void withdrawFromCompte(int amountToWithdraw) {
        if (disabled) {
            return;
        }

        amount -= amountToWithdraw;
    }

}
