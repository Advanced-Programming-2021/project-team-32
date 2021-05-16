package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainMenuHandler implements MenuHandler {

    public MainMenuHandler() {

    }

    @Override
    public boolean handle(Controller controller) {
        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = MainCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            System.out.println("Main Menu");
        }
        else if ((matcher=MainCommand.ENTER_MENU.getStringMatcher(command)).find()){
            controller.enterMenu(matcher.group(1));
        }
        else if((matcher=MainCommand.LOGOUT.getStringMatcher(command)).find()){
            controller.logout();
        }
        else if((matcher=MainCommand.EXIT.getStringMatcher(command)).find()){
            controller.exitMain();
        };
        return false;
    }
}
enum MainCommand {
    SHOW_MENU("^menu show-current$"),
    ENTER_MENU("^menu enter (Deck|Scoreboard|Profile|Shop)$"),
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
