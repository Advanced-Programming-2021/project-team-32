package main.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ScoreboardCommand {
    SHOW_MENU("^menu show-current$"),
    SHOW("^scoreboard show$");


    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    ScoreboardCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
