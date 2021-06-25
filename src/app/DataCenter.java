package app;

import app.model.Cards.Card;
import app.model.Cards.Monster;
import app.model.Cards.Spell;
import app.model.Cards.Trap;
import app.model.User;
import app.utils.DatabaseManager;

import java.util.ArrayList;
import java.util.HashMap;

public class DataCenter {
    private static DataCenter dataCenter;
    //تو این بخش همه دیتاهایی که مورد نیاز هست رو (هش‌مپ ها و اری‌لیست ها) اینجا اضافه میشه
    private HashMap<String, User> users;
    private HashMap<String, Monster> monsters;
    private HashMap<String, Spell> spells;
    private HashMap<String, Trap> traps;
    private HashMap<String, Card> cards;
    private User currentUser;

    private DataCenter() {
        users = new HashMap<>();
    }

    public static DataCenter getInstance() {
        if (dataCenter == null) {
            dataCenter = new DataCenter();
        }
        return dataCenter;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public HashMap<String, Monster> getMonsters() {
        return monsters;
    }

    public HashMap<String, Spell> getSpells() {
        return spells;
    }

    public HashMap<String, Trap> getTraps() {
        return traps;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public void loadData() {
        monsters = DatabaseManager.loadMonsters();
        traps = DatabaseManager.loadTraps();
        spells = DatabaseManager.loadSpells();
        users = DatabaseManager.loadUsers();
        cards = new HashMap<>();
        for (Trap trap : traps.values()) {
            cards.put(trap.getName(), trap);
        }
        for (Monster monster : monsters.values()) {
            cards.put(monster.getName(), monster);
        }
        for (Spell spell : spells.values()) {
            cards.put(spell.getName(), spell);
        }
    }

    public void storeData() {
        DatabaseManager.storeUsers(users);
    }

    public boolean nicknameExisted(String nickname) {
        for (User u : users.values()) {
            if (u.getNickname().equals(nickname))
                return true;
        }
        return false;
    }
}
