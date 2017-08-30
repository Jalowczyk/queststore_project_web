public abstract class AbstractUser {

    String name;
    String surname;
    protected Character[] password;
    String login;
    String id;

    public AbstractUser(String name, String surname, Character[] password, String login, String id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.login = login;
        this.id = id;
    }

    public void showInfo(){

        String info = String.format("Id: %s\nName: %s%n\nSurname: $%s%nLogin: %s%n",this.id, this.name, this.login);
    }


}

