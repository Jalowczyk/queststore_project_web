package src.models;

public class Mentor extends AbstractUser {

  public Mentor(){}

  public Mentor(String name, String surname, String password, String login, String id) {
      super(name, surname, password, login, id);
  }
  public String getMentorName(){
    return this.name;
  }
  public String getMentorSurname(){
    return this.surname;
  }
  public String getMentorLogin(){
    return this.login;
  }
  public String getMentorId(){
    return this.id;
  }

  public void setMentorName(String name){
    this.name = name;
  }
  public void setMentorSurname(String surname){
    this.surname = surname;
  }
  public void setMentorPassword(String password){
    this.password = password;
  }
  public void setMentorId(String id){
    this.id = id;
  }

}
