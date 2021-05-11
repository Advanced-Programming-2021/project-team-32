package src.main.clases;

public enum TypeCard {
    MONSTER("monster"),
    MAGIC("magic"),
    MERGE("merge");

    private String title;

    private TypeCard(String title) {
        this.title = title;
    }

    public String getValue() {
        return title;
    }

}
