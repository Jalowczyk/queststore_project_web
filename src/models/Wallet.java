package src.models;

import java.util.ArrayList;


public class Wallet implements WalletInterface{

  ArrayList artifacts = new ArrayList();
  Integer experience = 0;
  Integer balance = 0;

  public Wallet(){
  }
 
  public String vievWallet(){
    String walletInfo;

    walletInfo = String.format("You have %s coolcoins available.\nYour bought artifacts: %s", balance, artifacts);

    return walletInfo;
  }
  public ArrayList getArtifacts(){
    return this.artifacts;
  }
  public Integer getExperience(){
    return this.experience;
  }
  public Integer getBalance(){
    return this.balance;
  }
  public void setExperience(Integer exp){
    this.experience = exp;
  }
  public void setBalance(Integer bal){
    this.balance = bal;
  }
}

