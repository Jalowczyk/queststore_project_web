public class Application {

    public static void main(String[] args) {

        ApplicationView.setUserLoginMsg();
        String choice = ApplicationView.getInput();

        if(choice.equals("1")){
            ApplicationView.setUserId();
            String id = ApplicationView.getInput();

            DAOAdmin admin = new DAOAdmin();
            Admin admin1 = admin.load(id);
            if(admin1 == null){
                ApplicationView.failedLoginMsg();
            }else{
                AdminController.startController(admin1);
            }
        }

    }
}

