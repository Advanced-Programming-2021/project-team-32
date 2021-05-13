package app;

import app.view.LoginMenuHandler;
import app.view.MainMenuHandler;
import app.view.MenuHandler;

public class Controller {
    MenuHandler handler = new LoginMenuHandler();

    public void run(){
        while (true) {
            if (!handler.handle(this))
                break;
        }
    }

    public void SHOW_MENU() {
    }

    public void login(String username, String password) {
    }
}
