public abstract class AbstractUser {

    String name;
    String surname;
    String password;
    String login;
    String id;
    String mail;

    public AbstractUser(){}

    public AbstractUser(String name, String surname, String login, String id, String mail) {

        this.name = name;
        this.surname = surname;
        this.login = login;
        this.id = id;
        this.mail = mail;

    }

    public void showInfo(){

        String info = String.format("Id: %s\nName: %s%n\nSurname: $%s%nLogin: %s%n",this.id, this.name, this.login);
    }


}

