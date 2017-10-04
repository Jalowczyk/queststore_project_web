package com.school.models;

import com.school.controllers.WalletInterface;
import java.util.ArrayList;


public class Wallet implements WalletInterface{

  private ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
  private Integer experience;
  private Integer balance;
  private Integer walletId;

  public Wallet() {

  }

  public Wallet(Integer walletId, Integer experience, Integer balance, ArrayList<Artifact> artifacts) {

    this.walletId = walletId;
    this.experience = experience;
    this.balance = balance;
    this.artifacts = artifacts;

  }


  public ArrayList getArtifacts(){
    return this.artifacts;
  }
  public Integer getWalletId() {return this.walletId; }
  public Integer getExperience(){
    return this.experience;
  }
  public Integer getBalance(){
    return this.balance;
  }

  public void setWalletId(Integer id) { this.walletId = id; }
  public void setExperience(Integer exp){
    this.experience = exp;
  }
  public void setBalance(Integer balance){
    this.balance = balance;
  }

  public String vievWallet(){
    String walletInfo;

    walletInfo = String.format("You have %s coolcoins available.\nYour bought artifacts: %s", balance, artifacts);

    return walletInfo;
  }

  private Integer calculateLevel() {

    return null;
  }

}

