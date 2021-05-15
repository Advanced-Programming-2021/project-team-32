package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuHandler implements MenuHandler {

    @Override
    public boolean handle(Controller controller) {

        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = LoginCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            controller.showmenu();
        } else if ((matcher = LoginCommand.EXIT.getStringMatcher(command)).find()) {
            return false;
        } else if ((matcher = LoginCommand.LOGIN_USER.getStringMatcher(command)).find()) {
            controller.login(matcher.group("username"), matcher.group("password"));
         }
        else if ((matcher=LoginCommand.CREATE_USER.getStringMatcher(command)).find()){
            controller.createUser(matcher.group("username"), matcher.group("password"), matcher.group("nickname"));
        };
        return true;
    }
}


 enum LoginCommand {
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
