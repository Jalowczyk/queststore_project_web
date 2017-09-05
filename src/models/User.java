package src.models;

public abstract class User {

    protected String name;
    protected String surname;
    protected String password;
    protected String id;
    protected String mail;

    public User(){}

    public User(String name, String surname, String password, String id, String mail) {

        this.name = name;
        this.surname = surname;
        this.id = id;
        this.mail = mail;
        this.password = password;

    }

    @Override
    public String toString(){

        String info = String.format("\nName: %s\nSurname: $%s%nLogin: %s%n", this.name, this.surname, this.id);
        return info;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getId(){
        return this.id;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String getMail(){
        return this.mail;
    }

}
