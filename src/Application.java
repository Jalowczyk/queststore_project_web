public class Application {

    public static void main(String[] args) {

        DAOAdmin admin = new DAOAdmin();


        Admin admin1 = admin.load("cc13023");

        AdminController.startController(admin1);

        }


    }
}
