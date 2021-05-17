package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ScoreboardMenuHandler implements MenuHandler{

    @Override
    public boolean handle(Controller controller) {
        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = ScoreboardCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            System.out.println("Scoreboard Menu");
        }
        else if((matcher=ScoreboardCommand.SHOW.getStringMatcher(command)).find()){
            System.out.println(controller.showScoreboard());

        }
        else if ((matcher=ScoreboardCommand.EXIT.getStringMatcher(command)).find()){
            controller.exit();
        };
        return false;
    }
}
 enum ScoreboardCommand {
    SHOW_MENU("^menu show-current$"),
    SHOW("^scoreboard show$"),
    EXIT("^menu exit$");

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
