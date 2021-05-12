package main.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainCommand {
    SHOW_MENU("^menu show-current$"),
    ENTER_MENU("^menu enter (Login|Main|Duel|Deck|Scoreboard|Profile|ShopCommand)$"),
    LOGOUT("^user logout$"),
    EXIT("^menu exit$");

    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    MainCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
