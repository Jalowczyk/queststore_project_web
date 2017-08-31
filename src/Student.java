import java.util.ArrayList;

public class Student extends AbstractUser {

    ArrayList<Quest> studentQuests = new ArrayList<Quest>();

    public Student(){}

    public Student(String name, String surname, String login, String id){
        super(name, surname, password, login, id);
        this.wallet = new Wallet();
    }
    @Override
    public String toString() {
      return name, surname, login, id;
    }
    public getStudentName(){
      return this.name;
    }
    public getStudentSurname(){
      return this.surname;
    }
    public getStudentLogin(){
      return this.login;
    }
    public getStudentId(){
      return this.id;
    }
    public getWallet(){
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
