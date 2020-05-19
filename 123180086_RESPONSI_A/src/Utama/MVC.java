package Utama;

import Controller.Controller;
import View.vLogin;

public class MVC {
    public MVC(){
        vLogin vLogin = new vLogin();
        Model model = new Model();
        Controller controller = new Controller(vLogin,model);
    }
}
