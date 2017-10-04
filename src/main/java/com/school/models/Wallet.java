package com.school.models;

import com.school.controllers.WalletInterface;
import java.util.ArrayList;


public class Wallet implements WalletInterface{

  private ArrayList<Artifact> artifacts;
  private Integer experience;
  private Integer balance;
  private Integer walletId;

  public Wallet() {

  }

  // TEMPORARY CONSTRUCTOR
  public Wallet(Integer experience, Integer balance) {

    this.walletId = 1;
    this.experience = experience;
    this.balance = balance;
    this.artifacts = new ArrayList<Artifact>();

  }

  public Wallet(Integer walletId, Integer experience, Integer balance, ArrayList<Artifact> artifacts) {

    this.walletId = walletId;
    this.experience = experience;
    this.balance = balance;
    this.artifacts = artifacts;

  }

  public ArrayList<Artifact> getArtifacts(){
    return this.artifacts;
  }

  public Integer getWalletId() {
    return this.walletId;
  }

  public Integer getExperience(){
    return this.experience;
  }

  public Integer getBalance(){
    return this.balance;
  }

  public void setWalletId(Integer id) {
    this.walletId = id;
  }

  public void setExperience(Integer experience) throws IllegalArgumentException {
    if (experience < 0) {
      throw new IllegalArgumentException();
    }
    this.experience = experience;
  }

  public void setBalance(Integer balance) throws IllegalArgumentException{
    if (balance < 0) {
      throw new IllegalArgumentException();
    }
    this.balance = balance;
  }

  public void addCoolcoins(Integer coolcoins) {
    this.experience += coolcoins;
    this.balance += coolcoins;
  }

  public void addArtifact(Artifact artifact) {
    this.artifacts.add(artifact);
  }

  public String viewWallet() {
    String walletInfo = String.format("You have %s coolcoins available.\nYour bought artifacts:", balance);
    for (Artifact artifact : this.artifacts) {
      walletInfo += "\n" + artifact;
    }
    return walletInfo;
  }

  private Integer calculateLevel() {
    Integer level = (int)this.experience / 1000;
    if (level == 0) {
      level = 1;
    }
    return level;
  }


}

