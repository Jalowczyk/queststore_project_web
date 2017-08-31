public class Mentor extends AbstractUser {

  public Mentor(){}

  public Mentor(String name, String surname, Character[] password, String login, String id) {
      super(name, surname, password, login, id);
  }
  public getMentorName(){
    return this.name;
  }
  public getMentorSurname(){
    return this.surname;
  }
  public getMentorLogin(){
    return this.login;
  }
  public getMentorId(){
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
