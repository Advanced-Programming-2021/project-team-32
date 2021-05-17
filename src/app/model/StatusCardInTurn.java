package app.model;

public enum StatusCardInTurn {
    ATTACK("Attack"),
    DEFENCE("defence");

    private String title;

    private StatusCardInTurn(String title) {
        this.title = title;
    }

    public String getValue() {
        return title;
    }

}
