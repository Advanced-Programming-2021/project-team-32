package app;

import app.model.Cards.Card;
import app.model.Cards.Monster;
import app.model.Cards.Spell;
import app.model.Cards.Trap;
import app.model.IllegalActionException;
import app.model.User;
import app.view.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Controller {
    MenuHandler handler = new LoginMenuHandler();

    public void run() {
        DataCenter.getInstance().loadData();
        while (true) {
            try {
                if (!handler.handle(this))
                    break;

            } catch (IllegalActionException e) {
                System.out.println(e.getMessage());
            }
        }
        DataCenter.getInstance().storeData();
    }


    public void createUser(String username, String password, String nickname) throws IllegalActionException {
        if (DataCenter.getInstance().getUser(username) == null) {
            if (DataCenter.getInstance().nicknameExisted(nickname)) {
                throw new IllegalActionException("user with nickname " + nickname + " already exists");
            }
            User user = new User(username, password, nickname);
            DataCenter.getInstance().addUser(user);
            System.out.println("user created successfully!");
        } else {
            throw new IllegalActionException("user with username " + username + " already exists");
        }
    }

    public void login(String username, String password) throws IllegalActionException {
        User user = DataCenter.getInstance().getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            DataCenter.getInstance().setCurrentUser(user);
            handler = new MainMenuHandler();
            System.out.println("user logged in successfully!");

        }
        else{
            throw new IllegalActionException("Username and password didn't match!");
        }

    }

    public void logout() {
        DataCenter.getInstance().setCurrentUser(null);
        handler = new LoginMenuHandler();
        System.out.println("user logged out successfully!");
    }

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

    public void exitMain() {
        logout();
    }

    public void changeNickName(String nickname) throws IllegalActionException {
        if (DataCenter.getInstance().nicknameExisted(nickname)){
            throw new IllegalActionException("user with nickname "+ nickname + " already exists");
        } else {
        User user = DataCenter.getInstance().getCurrentUser();
        user.setNickname(nickname);
            System.out.println("nickname changed successfully!");
        }
    }

    public void changePassword(String cp, String password) throws IllegalActionException {
        User user = DataCenter.getInstance().getCurrentUser();
        if (user.getPassword().equals(cp)) {
            if (user.getPassword().equals(password)){
                throw new IllegalActionException("please enter a new password");
            }
            user.setPassword(password);
            System.out.println("password changed successfully");
        }
        else {
            throw new IllegalActionException("current password is invalid");
        }
    }

    public ArrayList<User> showScoreboard() {

        ArrayList<User> users = DataCenter.getInstance().getUsers();
        users.sort((o1, o2) ->
                o1.getScore() > o2.getScore() ? 1 : 0
        );
        return users;
    }


    public void showShop() {
        HashMap<String, Card> cards = DataCenter.getInstance().getCards();

        for (Card card : cards.values()) {
            System.out.println(card.getName() + " : " + card.getDescription() + "\n");
        }

    }


    public void buyCard(String group) throws IllegalActionException {
        HashMap<String, Card> cards = DataCenter.getInstance().getCards();

        if (cards.containsKey(group)) {
            Card card = cards.get(group);
            if (card.getPrice() <= DataCenter.getInstance().getCurrentUser().getBalance()) {
                DataCenter.getInstance().getCurrentUser().decreaseBalance(card.getPrice());
                DataCenter.getInstance().getCurrentUser().addCard(group);
            } else {
                throw new IllegalActionException("not enough money");
            }
        } else {
            throw new IllegalActionException("there is no card with this name");
        }


    }

    public void cardShow(String group) throws IllegalActionException {
        HashMap<String, Card> cards = DataCenter.getInstance().getCards();
        if (cards.containsKey(group)){
            Card card = cards.get(group);
            System.out.println(card.toString());
        }
        else {
            throw new IllegalActionException("card with this name does not exist");
        }
    }

    public void activeEffect() {
    }

    public void attack(String group) {
    }

    public void back() {
    }

    public void deselect() {
    }

    public void directAttack() {
    }

    public void oppField() {
    }

    public void flip() {
    }

    public void oppMonster(String group) {
    }

    public void selectField() {
    }

    public void selectHand(String group) {
    }

    public void selectSpell(String group) {
    }

    public void selectMonster(String group) {
    }

    public void set() {
    }

    public void setPosition(String group) {
    }

    public void showCard() {
    }

    public void showGyard() {
    }

    public void spelltOpp(String group) {
    }

    public void summon() {
    }

    public void surrender() {
    }

    public void createDeck(String group) {
    }

    public void deleteDeck(String group) {
    }

    public void setActive(String group) {
    }

    public void addCard(String cardname, String deckname, String side) {
    }

    public void removeCard(String cardname, String deckname, String side) {
    }

    public void showAll() {
    }

    public void showDeck(String deckname, String side) {
    }

    public void exit() {
        handler = new MainMenuHandler();
    }


    public User getCurrentUser() {
        return DataCenter.getInstance().getCurrentUser();
    }


    public void newDuel(String username) throws IllegalActionException {
        if (DataCenter.getInstance().getUser(username)==null){
            throw new IllegalActionException("there is no player with this username");
        }
    }
}
