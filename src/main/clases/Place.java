package src.main.clases;

public class Place {
    private int id;
    private TypePlace type;

    //constructor
    public Place() {
    }

    //get and set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypePlace getType() {
        return type;
    }

    public void setType(TypePlace type) {
        this.type = type;
    }
}
