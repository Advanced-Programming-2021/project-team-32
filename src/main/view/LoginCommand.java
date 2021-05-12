package main.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginCommand
{

    SHOW_MENU("^menu show-current$"),
    CREATE_USER("^user create (?=.*--username (?<username>\\S+))(?=.*--password (?<password>\\S+))(?=.*--nickname (?<nickname>\\S+))$"),
    LOGIN_USER("^user login (?=.*--username (?<username>\\S+))(?=.*--password (?<password>\\S+))$"),
    EXIT("^menu exit$");






    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    LoginCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
