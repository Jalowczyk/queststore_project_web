package src.models;

public class Mentor extends AbstractUser {

  public Mentor(){}

  public Mentor(String name, String surname, String password, String login, String mail) {
      super(name, surname, password, login, mail);
  }

}
