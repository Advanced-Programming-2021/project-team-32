package app;

import app.model.IllegalActionException;
import app.model.User;
import app.view.*;

import java.util.ArrayList;

public class Controller {
    MenuHandler handler = new LoginMenuHandler();

    public void run() {
        while (true) {
            try {
                if (!handler.handle(this))
                    break;

            } catch (IllegalActionException e) {
                System.out.println(e.getMessage());
            }
            ;

        }
    }


    public void createUser(String username, String password, String nickname) {
        if (DataCenter.getInstance().getUser(username) == null) {
            User user = new User(username, password, nickname);
            DataCenter.getInstance().addUser(user);
        }
    }

    public void login(String username, String password) {
        User user = DataCenter.getInstance().getUser(username);
        if (user != null && !user.getPassword().equals(password)) {
            DataCenter.getInstance().setCurrentUser(user);
            handler = new MainMenuHandler();

        }
    }

    public void logout() {
        DataCenter.getInstance().setCurrentUser(null);
        handler = new LoginMenuHandler();
    }

    ;

    public void enterMenu(String group) {
        if (group.equals("Deck")) {
            handler = new DeckMenuHandler();
        } else if (group.equals("Profile")) {
            handler = new ProfileMenuHandler();
        } else if (group.equals("Scoreboard")) {
            handler = new ScoreboardMenuHandler();
        } else if (group.equals("Shop")) {
            handler = new ShopMenuHandler();
        }
    }

    ;

    public void exitMain() {
        logout();
    }

    public void changeNickName(String nickname) {
        User user = DataCenter.getInstance().getCurrentUser();
        user.setNickname(nickname);
    }

    ;

    public void changePassword(String cp, String password) {
        User user = DataCenter.getInstance().getCurrentUser();
        if (user.getPassword().equals(cp)) {
            user.setPassword(password);
        }
    }

    ;

    public ArrayList<User> showScoreboard() {

        ArrayList<User> users = DataCenter.getInstance().getUsers();
        users.sort((o1, o2) ->
                o1.getScore() > o2.getScore() ? 1 : 0
        );
        return users;
    }



    public void showShop() {
    }



    public void buyCard(String group) {
    }

    ;

    public void activeEffect() {
    }

    ;

    public void attack(String group) {
    }

    ;

    public void back() {
    }

    ;

    public void deselect() {
    }

    ;

    public void directAttack() {
    }

    ;

    public void oppField() {
    }

    ;

    public void flip() {
    }

    ;

    public void oppMonster(String group) {
    }

    ;

    public void selectField() {
    }

    ;

    public void selectHand(String group) {
    }

    ;

    public void selectSpell(String group) {
    }

    ;

    public void selectMonster(String group) {
    }

    ;

    public void set() {
    }

    ;

    public void setPosition(String group) {
    }

    ;

    public void showCard() {
    }

    ;

    public void showGyard() {
    }

    ;

    public void spelltOpp(String group) {
    }

    ;

    public void summon() {
    }

    ;

    public void surrender() {
    }

    ;

    public void createDeck(String group) {
    }

    ;

    public void deleteDeck(String group) {
    }

    ;

    public void setActive(String group) {
    }

    ;

    public void addCard(String cardname, String deckname, String side) {
    }

    ;

    public void removeCard(String cardname, String deckname, String side) {
    }

    ;

    public void showAll() {
    }

    ;

    public void showDeck(String deckname, String side) {
    }

    ;

    public void exit() {
        handler = new MainMenuHandler();
    }


}
