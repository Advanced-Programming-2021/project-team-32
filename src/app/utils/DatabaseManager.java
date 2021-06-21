package app.utils;

import app.model.Card;
import app.model.Trap;
import app.model.User;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

public class DatabaseManager {
    private static final String pathToMonsters = "resources/cards/Monster.csv";
    private static final String pathToUsers = "resources/users/";
    private static final String pathToSpells = "resources/cards/Monster.csv";

    public static HashMap<String, User> loadUsers() {
        HashMap<String, User> users = new HashMap<>();
            File file = new File(pathToUsers);
            try {
                String[] files = file.list();
                if (files == null)
                    return null;
                for (String path : files) {
                    String userJson = readFileAsString(path);
                    User user = new Gson().fromJson(userJson, User.class);
                    users.put(user.getUsername(), user);
                }
            }catch (NullPointerException | IOException e) {
                System.out.println(e);
            }
        return users;
    }

    private static String readFileAsString(String fileName) throws IOException {
        String data;
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static HashMap<String, Card> loadMonsters() {
        HashMap<String, Card> monsters = new HashMap<>();
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(pathToMonsters)));
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                monsters.put(record[0], new Card(record[0], Integer.parseInt(record[1]), record[2], record[3], record[4], Integer.parseInt(record[5]), Integer.parseInt(record[6]), record[7], Integer.parseInt(record[8])));
            }//Name,Level,Attribute, Monster Type , Card Type ,Atk,Def,Description,Price

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return monsters;
    }

    public static HashMap<String, Card> loadTraps() { //Name,Type ,Icon (Property),Description,Status,Price
        HashMap<String, Card> traps = new HashMap<>();
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(pathToSpells)));
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                traps.put(record[0], new Trap(record[0], record[1], record[2], record[3], record[4], Integer.parseInt(record[5])));
            }//Name,Level,Attribute, Monster Type , Card Type ,Atk,Def,Description,Price

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return traps;
    }

    public static void storeUsers(HashMap<String, User> users) {

    }

    public static void storeMonsters() {
    }

    public static void storeTraps() {
    }

}
