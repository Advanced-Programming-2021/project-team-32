package app.model;

import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int score = 0;
    private int balance;
    private HashMap<String, Integer> cards;

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    public void decreaseScore(int score) {
        this.score -= score;
    }

    public String toString() {
        return "username: " + username + "\nnickname: " + nickname + "\nscore: " + score;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void decreaseBalance(int price){
        this.balance-= price;
    }
    public void addCard(String name){
        if (cards == null){
            cards = new HashMap<>();
        }
        if (cards.containsKey(name)){
            int number = cards.get(name);
            number++;
            cards.put(name, number);
        }
        else {
            cards.put(name, 1);
        }
    }
}
