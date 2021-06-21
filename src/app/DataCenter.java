package app;

import app.model.Card;
import app.model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class DataCenter {
    private static DataCenter dataCenter;
    //تو این بخش همه دیتاهایی که مورد نیاز هست رو (هش‌مپ ها و اری‌لیست ها) اینجا اضافه میشه
    private HashMap<String, User> users;
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
    public ArrayList<User> getUsers(){
        return new ArrayList<>(users.values());
    }

    public void loadData() {

    }

    public void storeData() {
    }
}
