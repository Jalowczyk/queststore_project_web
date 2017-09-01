import java.util.ArrayList;


public class Student extends AbstractUser {
    Wallet wallet;
    //ArrayList<> studentQuests = new ArrayList<>();

    public Student(){}

    public Student(String name, String surname, String password, String login, String id){
        super(name, surname, password, login, id);
        this.wallet = new Wallet();
    }
    public String getStudentName(){
      return this.name;
    }
    public String getStudentSurname(){
      return this.surname;
    }
    public String getStudentLogin(){
      return this.login;
    }
    public String getStudentId(){
      return this.id;
    }
    public Wallet getWallet(){
      return this.wallet;
    }
    public void setStudentName(String name){
      this.name = name;
    }
    public void setStudentSurname(String surname){
      this.surname = surname;
    }
    public void setStudentPassword(String password){
      this.password = password;
    }
    public void setStudentId(String id){
      this.id = id;
    }
}
