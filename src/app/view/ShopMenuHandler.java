package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 public class ShopMenuHandler implements MenuHandler{

     @Override
     public boolean handle(Controller controller) {

         String command = UserCommandGetter.getUserCommand();
         Matcher matcher;
         if ((matcher = ShopCommand.SHOW_MENU.getStringMatcher(command)).find()) {
             controller.showmenu();
         }
         else if ((matcher=ShopCommand.BUY_CARD.getStringMatcher(command)).find()){}
         else if((matcher=ShopCommand.SHOW_SHOP.getStringMatcher(command)).find()){}
         else if((matcher=ShopCommand.EXIT.getStringMatcher(command)).find()){};
         return false;
     }
 }
 enum ShopCommand {
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
