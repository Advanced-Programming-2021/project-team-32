package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum ProfileCommand {
    SHOW_MENU("^menu show-current$"),
    CHANGE_NICKNAME("^profile change --nickname (?<nickname>\\S+)$"),
    CHANGE_PASSWORD("^profile change (?=.*--password)(?=.*--current (?<cp>\\S+))(?=.*--new (?<password>\\S+)))$"),
    EXIT("^menu exit$");

    private final Pattern commandPattern;

    ProfileCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }
}

public class ProfileMenuHandler implements MenuHandler {

    @Override
    public boolean handle(Controller controller) {
        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = ProfileCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            System.out.println("Profile Menu");
        } else if ((matcher = ProfileCommand.CHANGE_NICKNAME.getStringMatcher(command)).find()) {
            controller.changeNickName(matcher.group("nickname"));
        } else if ((matcher = ProfileCommand.CHANGE_PASSWORD.getStringMatcher(command)).find()) {
            controller.changePassword(matcher.group("cp"), matcher.group("password"));
        } else if ((matcher = ProfileCommand.EXIT.getStringMatcher(command)).find()) {
            controller.exit();
        } else {
            System.out.println("invalid command");
        }
        return false;
    }
}
