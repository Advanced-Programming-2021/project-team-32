package app.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileCommand {
    SHOW_MENU("^menu show-current$"),
    CHANGE_NICKNAME("^profile change --nickname (?<nickname>\\S+)$"),
    CHANGE_PASSWORD("^profile change (?=.*--password)(?=.*--current (?<cp>\\S+))(?=.*--new (?<password>\\S+)))$"),
    EXIT("^menu exit$");

    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    ProfileCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
