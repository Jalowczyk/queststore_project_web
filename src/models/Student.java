package src.models;

public class Student extends User {

    Wallet wallet;
    //ArrayList<> studentQuests = new ArrayList<>();

    public Student(){}

    public Student(String name, String surname, String password, String login, String id){
        super(name, surname, password, login, id);
        this.wallet = new Wallet();
    }

    public static void startController(){

    }

}

