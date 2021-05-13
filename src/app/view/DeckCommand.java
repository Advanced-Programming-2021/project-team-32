package app.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DeckCommand {
    SHOW_MENU("^menu show-current$"),
    CREATE_DECK("^deck create (\\w+)$"),
    DELETE_DECK("^deck delete (\\w+)$"),
    SET_ACTIVE("^deck set-activate (\\w+)$"),
    ADD_CARD("^deck add-card (?=.*--card (?<card name>\\S+))(?=.*--deck (?<deck name>\\S+))(?=.*--side)?$"),
    REMOVE_CARD("^deck rm-card  (?=.*--card (?<card name>\\S+))(?=.*--deck (?<deck name>\\S+))(?=.*--side)?$"),
    SHOW_ALL("^deck show --all$"),
    SHOW_DECK("^deck show (?=.*--deck-name (?<deck name>\\S+))(?=.*--side)?$"),
    SHOW_CARD("^deck show --cards$"),
    EXIT("^menu exit$");




    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    DeckCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
