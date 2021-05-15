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

    public void showmenu() {};
    public void createUser(String username,String password, String nickname){};
    public void login(String username, String password) {
        MenuHandler handler = new MainMenuHandler();
    }
    public void logout(){};
    public void enterMenu(String group){};
    public void changeNickName(String nickname){};
    public void changePassword(String cp, String password ){};
    public void showScoreboard(){};
    public void showShop(){};
    public void buyCard(String group){};
    public void activeEffect(){};
    public void attack(String group){};
    public void back(){};
    public void deselect(){};
    public void directAttack(){};
    public void oppField(){};
    public void flip(){};
    public void oppMonster(String group){};
    public void selectField(){};
    public void selectHand(String group){};
    public void selectSpell(String group){};
    public void selectMonster(String group){};
    public void set(){};
    public void setPosition(String group){};
    public void showCard(){};
    public void showGyard(){};
    public void spelltOpp(String group){};
    public void summon(){};
    public void surrender(){};
    public void createDeck(String group){};
    public void deleteDeck(String group){};
    public void setActive(String group){};
    public void addCard(String cardname, String deckname, String side){};
    public void removeCard(String cardname, String deckname, String side){};
    public void showAll(){};
    public void showDeck(String deckname, String side){};
    public void exit(){};
}
