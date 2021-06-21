import app.model.Card;
import app.utils.DatabaseManager;

import java.util.HashMap;

public class TestRun {
    public static void main(String[] args) {
        HashMap<String, Card> x = DatabaseManager.loadMonsters();
        for (String s :
                x.keySet()) {
            System.out.println(s);
        }
    }
}
