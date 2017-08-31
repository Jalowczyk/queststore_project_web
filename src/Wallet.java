public class Wallet{

  ArrayList<Artifacts> artifacts = new ArrayList<>();
  Integer experience = 0;
  Integer balance = 0;

  public Wallet(){
  }
  @Override
  public String toString() {
    return artifacts, experience, balance;
  }
  public getArtifacts(){
    return this.artifacts;
  }
  public getExperience(){
    return this.experience;
  }
  public getBalance(){
    return this.balance;
  }
  public void setExperience(Integer exp){
    this.experience = exp;
  }
  public void setBalance(Integer bal){
    this.balance = bal;
  }
}
