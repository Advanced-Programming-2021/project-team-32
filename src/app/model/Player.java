package src.main.clases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Player implements Comparator, Comparable {

    int id;
    private String nickName;
    private String userName;
    private String password;
    private double balance;
    private Stock stock;

    //instructor
    public Player() {
    }

    //get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //methods are clear

    public void login(String userName, String passWord, String nickName) {

    }

    public MatchGame createNewGame() {
        MatchGame match = new MatchGame();
        System.out.println(" enter number of round");
        Scanner scan = new Scanner(System.in);
        if (scan.next().equals("1")) {
            return match.startOneRound();
        }
        if (scan.next().equals("3")) {
            return match.startThreeRound();
        }
        System.out.println(" number of round required");
        return null;
    }

    public void menuEnter(List<Player> playerList) {
        System.out.print("menu enter : ");
        Scanner scan = new Scanner(System.in);
        switch (scan.next()) {
            case "Duel":
                enterDuel(scan.next());
                break;
            case "Deck":
                enterDeck(scan.next());
                break;
            case "Scoreboard":
                enterScoreboard(scan.next(), playerList);
                break;
            case "Profile":
                enterProfile(scan.next(), this);
                break;
            case "Import/Export":
                enterIE(scan.next());
                break;
            case "Shop":
                enterShop(scan.next());
                break;
        }
    }

    public void enterDuel(String title) {
        if (title.equals("Duel")) {

        }
    }

    public void enterDeck(String title) {
        if (title.equals("Deck")) {

        }
    }

    public void enterShop(String title) {
        if (title.equals("Shop")) {

        }
    }

    public void enterScoreboard(String title, List<Player> playerList) {
        if (title.equals("Scoreboard")) {
            scoreBoardShow(playerList);
        }
    }

    public void enterIE(String title) {
        if (title.equals("Import/Export")) {
            System.out.println("enter import for import file");
            Scanner scan = new Scanner(System.in);
            if (scan.next().equals("import")) {
              //  File file = new File();
               // FileInputStream inputStream = new FileInputStream(file);
            }
        }
    }

    public void enterProfile(String title, Player player) {
        if (title.equals("Profile")) {
            System.out.print("user name:");
            System.out.println(player.userName);
            System.out.print("password:");
            System.out.println(player.password);
            System.out.print("name");
            System.out.print(player.nickName);
            System.out.print("score");
            System.out.print(player.balance);
            System.out.print("change password");
            System.out.print("change name");
        }
    }

    public void menuExit() {
        System.out.flush();
        System.out.println(" Main ");
    }

    public void createPlayer(List<Player> playerList) {
        if (playerList.isEmpty()) {
            System.out.println(" sign up ");
            System.out.print(" enter your user name: ");
            Scanner scan = new Scanner(System.in);
            System.out.print(" enter your password: ");
            Scanner scan2 = new Scanner(System.in);
            System.out.print(" enter your name: ");
            Scanner scan3 = new Scanner(System.in);
            this.setUserName(scan.next());
            this.setPassword(scan2.next());
            this.setNickName(scan3.next());
            playerList.add(this);
        } else {
            Player player = new Player();
            System.out.println(" create player ");
            System.out.print(" enter your user name: ");
            Scanner scan = new Scanner(System.in);
            System.out.print(" enter your password: ");
            Scanner scan2 = new Scanner(System.in);
            System.out.print(" enter your name: ");
            Scanner scan3 = new Scanner(System.in);
            player.setUserName(scan.next());
            player.setPassword(scan2.next());
            player.setNickName(scan3.next());
            playerList.add(player);
        }
    }

    public void scoreBoardShow(List<Player> playerList) {
        Collections.sort(playerList);
        for (Player player : playerList) {
            System.out.println(player.getNickName() + " " + player.getBalance());
        }
    }


    public void showPlayers(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player.getNickName() + " " + player.getBalance());
        }
    }

    public void changeNickName(Player player) {
        System.out.println(" enter your new nick name");
        Scanner scan = new Scanner(System.in);
        player.setNickName(scan.next());
        System.out.println(" your new nick name is " + player.getNickName());
    }

    public void changePassword(Player player) {
        System.out.println(" enter your new password");
        Scanner scan = new Scanner(System.in);
        player.setPassword(scan.next());
        System.out.println(" your new password is " + player.getPassword());
    }


    @Override
    public int compare(Object o1, Object o2) {
        if (((Player) o1).getBalance() > ((Player) o2).getBalance()) {
            return 1;
        } else if (((Player) o1).getBalance() == ((Player) o2).getBalance()) {
            if (((Player) o1).getNickName().compareTo(((Player) o2).getNickName()) > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

    @Override
    public int compareTo(Object o) {
        if (this.getBalance() > ((Player) o).getBalance()) {
            return 1;
        } else if (this.getBalance() == ((Player) o).getBalance()) {
            if (this.getNickName().compareTo(((Player) o).getNickName()) > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
