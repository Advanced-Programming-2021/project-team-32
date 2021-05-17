package app.model;

import java.util.ArrayList;
import java.util.List;

public class Mat {
    private int id;
    private List<Place> placeList = new ArrayList<>();

    //constructor
    public Mat(int id) {
        this.id = id;
    }

    //get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    //methods
    public void addCard() {
    }

    public void attack() {
    }

    public void defence() {
    }
}
