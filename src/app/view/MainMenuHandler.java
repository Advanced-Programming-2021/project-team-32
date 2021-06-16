package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum MainCommand {
    SHOW_MENU("^menu show-current$"),
    ENTER_MENU("^menu enter (Deck|Scoreboard|Profile|Shop)$"),
    LOGOUT("^user logout$"),
    EXIT("^menu exit$");

    private final Pattern commandPattern;

    MainCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }
}

public class MainMenuHandler implements MenuHandler {

    public MainMenuHandler() {

    }

    @Override
    public boolean handle(Controller controller) {
        String menuCommands = "Main menu:\n" +
                "1.menu show-current\n" +
                "2.menu enter <menu name>\n" +
                "3.user logout\n" +
                "4.menu exit\n";
        System.out.println(menuCommands);
        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = MainCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            System.out.println("Main Menu");
        } else if ((matcher = MainCommand.ENTER_MENU.getStringMatcher(command)).find()) {
            controller.enterMenu(matcher.group(1));
        } else if ((matcher = MainCommand.LOGOUT.getStringMatcher(command)).find()) {
            controller.logout();
        } else if ((matcher = MainCommand.EXIT.getStringMatcher(command)).find()) {
            controller.exitMain();
        } else {
            System.out.println("invalid command");
        }
        return false;
    }
}
