package src.main.clases;

public enum TypePlace {
    GRAVEYARD("GRAVEYARD "),
    MONSTER("MONSTER"),
    MAGIC("MAGIC"),
    MERGE("MERGE"),
    ALLCARD("ALL CARDS"),
    INHAND("IN HAND");

    private String title;

    private TypePlace(String title) {
        this.title = title;
    }

    public String getValue() {
        return title;
    }
}
