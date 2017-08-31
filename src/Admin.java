public class Admin extends AbstractUser{



    public Admin(){}
//
//    public Admin(String name, String surname, String password, String login, String id, String mail){
//        super(name, surname, login, id, mail);
//    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getLogin(){
        return this.login;
    }

    public void setId(String id){
        this.id = id;
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

    public void setLogin(String login){
        this.login = login;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String getMail(){
        return this.mail;
    }


}
