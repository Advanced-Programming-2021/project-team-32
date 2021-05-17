package app.view;

import app.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DeckMenuHandler implements MenuHandler {

    @Override
    public boolean handle(Controller controller) {
        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = DeckCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            System.out.println("Deck Menu");
        } else if ((matcher = DeckCommand.CREATE_DECK.getStringMatcher(command)).find()) {
            controller.createDeck(matcher.group(1));
        } else if ((matcher = DeckCommand.DELETE_DECK.getStringMatcher(command)).find()) {
            controller.deleteDeck(matcher.group(1));
        } else if ((matcher = DeckCommand.SET_ACTIVE.getStringMatcher(command)).find()) {
            controller.setActive(matcher.group(1));
        } else if ((matcher = DeckCommand.ADD_CARD.getStringMatcher(command)).find()) {
            controller.addCard(matcher.group("cardname"), matcher.group("deckname"), matcher.group("side"));
        } else if ((matcher = DeckCommand.REMOVE_CARD.getStringMatcher(command)).find()) {
            controller.removeCard(matcher.group("cardname"), matcher.group("deckname"), matcher.group("side"));
        } else if ((matcher = DeckCommand.SHOW_ALL.getStringMatcher(command)).find()) {
            controller.showAll();
        } else if ((matcher = DeckCommand.SHOW_DECK.getStringMatcher(command)).find()) {
            controller.showDeck(matcher.group("deckname"), matcher.group("side"));
        } else if ((matcher = DeckCommand.SHOW_CARD.getStringMatcher(command)).find()) {
            controller.showCard();
        } else if ((matcher = DeckCommand.EXIT.getStringMatcher(command)).find()) {
            controller.exit();
        } else {
            System.out.println("invalid command");
        }
        return false;
    }
 }

 enum DeckCommand {
    SHOW_MENU("^menu show-current$"),
    CREATE_DECK("^deck create (\\w+)$"),
    DELETE_DECK("^deck delete (\\w+)$"),
    SET_ACTIVE("^deck set-activate (\\w+)$"),
    ADD_CARD("^deck add-card (?=.*--card (?<card name>\\S+))(?=.*--deck (?<deck name>\\S+))(?=.*--side)?$"),
    REMOVE_CARD("^deck rm-card  (?=.*--card (?<card name>\\S+))(?=.*--deck (?<deck name>\\S+))(?=.*--side)?$"),
    SHOW_ALL("^deck show --all$"),
    SHOW_DECK("^deck show (?=.*--deck-name (?<deck name>\\S+))(?=.*--side)?$"),
    SHOW_CARD("^deck show --cards$"),
    EXIT("^menu exit$");




    private Pattern commandPattern;

    public Pattern getCommandPattern() {

        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {

        return this.commandPattern.matcher(input);
    }

    DeckCommand(String commandPatternString) {

        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
