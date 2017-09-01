public class Application {

    public static void main(String[] args) {
        mainController();
    }

    public static void mainController() {

        ApplicationView.setUserLoginMsg();
        String choice = ApplicationView.getInput();

        ApplicationView.setUserId();
        String id = ApplicationView.getInput();

        loginProcess(choice, id);
    }

    public static void loginProcess(String choice, String id) {

        if (choice.equals("1")) {

            Admin createdAdmin = getAdmin(id);

            if (createdAdmin != null) {
                AdminController.startController(createdAdmin);
            } else {
                ApplicationView.failedLoginMsg();
            }
        }
    }

    public static Admin getAdmin(String id) {

        DAOAdmin admin = new DAOAdmin();
        Admin createdAdmin = admin.load(id);
        return createdAdmin;
    }
}




