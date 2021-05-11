package src.main.clases;

public class Player {

    int id;
    private String nickName;
    private String userName;
    private String passWord;
    private double balance ;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    //methods are clear

    public void login(String userName, String passWord, String nickName){

    }

    public void showCards(){}

    public void createNewGame(){}

    public void menuEnter(){}

    public void menuExit(){}

    public void createPlayer(){}

    public void scoreBoardShow(){}

    public void showPlayers(){}

    public void changeNickName(){}

    public void changePassword(){}




}
