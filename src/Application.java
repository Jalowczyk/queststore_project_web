public class Application {

    public static void main(String[] args) {

        DAOAdmin admin = new DAOAdmin();
        
        Admin admin1 = admin.load("cc13023");
        Admin admin2 = admin.load("cc12954");

        admin.save(admin1);
        admin.save(admin2);

    }
}
