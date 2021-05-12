package main.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ShopCommand {
    SHOW_MENU("^menu show-current$"),
    BUY_CARD("^shop buy (\\w+)$"),
    SHOW_SHOP("^shop show --all$"),
    EXIT("^menu exit$");




    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    ShopCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
