package main.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DuelCommand {
    SHOW_MENU("^menu show-current$"),
    SELECT_MONSTR("^select --monster ([1-5])$"),
    SELECT_SPELL("^select --spell ([1-5])$"),
    MONSTER_OPP("^select --monster --opponent ([1-5])$"),
    SPELL_OPP("^select --spell --opponent ([1-5])$"),
    SELECT_FIELD("^select --field"),
    FIELD_OPP("^select --field --opponent$"),
    SELECT_HAND("^select --hand ([1-6])"),
    DESELECT("^select -d$"),
    SUMMON("^summon$"),
    SET("^set$"),
    SET_POSITION("^set --position (attack|defense)$"),
    FLIP("^flip-summon$"),
    ATTACK("^attack ([1-5])$"),
    DIRECT_ATTACK("^attack direct$"),
    ACTIVE_EFFECT("^activate effect$"),
    SHOW_GYARD("^show graveyard$"),
    BACK("^back$"),
    SHOW_CARD("^card show --selected$"),
    SURRENDER("^surrender$"),
    EXIT("^menu exit$");





    private Pattern commandPattern;

    public Pattern getCommandPattern() {
        return commandPattern;
    }

    public Matcher getStringMatcher(String input) {
        return this.commandPattern.matcher(input);
    }

    DuelCommand(String commandPatternString) {
        this.commandPattern = Pattern.compile(commandPatternString);
    }
}
