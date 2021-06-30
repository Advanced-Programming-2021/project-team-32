package app.view;

import app.Controller;
import app.DataCenter;
import app.model.Battle.Battle;
import app.model.Battle.BattleCard;
import app.model.Battle.Phases;
import app.model.Battle.Player;
import app.model.IllegalActionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuelMenuHandler implements MenuHandler {

    @Override
    public boolean handle(Controller controller) throws IllegalActionException {
        String menuCommands =
                "Duel menu:\n" +
                        "1.menu show-current\n" +
                        "2.select --monster <monster number>\n" +
                        "3.select --monster --opponent <monster number>\n" +
                        "4.select --spell <spell number>\n" +
                        "5.select --spell --opponent <spell number>" +
                        "6.select --field\n" +
                        "7.select --field --opponent\n" +
                        "8.select --hand <number>\n" +
                        "9.select -d\n" +
                        "10.summon\n" +
                        "11.set\n" +
                        "12.set --position attack/defense\n" +
                        "13.flip-summon\n" +
                        "14.attack <number>\n" +
                        "15.attack direct\n" +
                        "16.activate effect\n" +
                        "17.show graveyard\n" +
                        "18.back\n" +
                        "19.card show --selected\n" +
                        "20.surrender\n" +
                        "21.menu exit";

        System.out.println(menuCommands);

        String command = UserCommandGetter.getUserCommand();
        Matcher matcher;
        if ((matcher = DuelCommand.SHOW_MENU.getStringMatcher(command)).find()) {
            System.out.println("Duel Menu");
        } else if ((matcher = DuelCommand.EXIT.getStringMatcher(command)).find()) {
            controller.exit();
        } else if ((matcher = DuelCommand.SELECT_MONSTER.getStringMatcher(command)).find()) {
            controller.selectMonster(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = DuelCommand.SELECT_SPELL.getStringMatcher(command)).find()) {
            controller.selectSpell(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = DuelCommand.MONSTER_OPP.getStringMatcher(command)).find()) {
            controller.oppMonster(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = DuelCommand.SPELL_OPP.getStringMatcher(command)).find()) {
            controller.spellOpp(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = DuelCommand.SELECT_FIELD.getStringMatcher(command)).find()) {
            controller.selectField();
        } else if ((matcher = DuelCommand.FIELD_OPP.getStringMatcher(command)).find()) {
            controller.oppField();
        } else if ((matcher = DuelCommand.SELECT_HAND.getStringMatcher(command)).find()) {
            controller.selectHand(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = DuelCommand.DESELECT.getStringMatcher(command)).find()) {
            controller.deselect();
        } else if ((matcher = DuelCommand.SUMMON.getStringMatcher(command)).find()) {
            controller.summon();
        } else if ((matcher = DuelCommand.NEXT_PHASE.getStringMatcher(command)).find()) {
            Phases phase = controller.nextPhase();
            if (phase == Phases.DRAW) {
                printBattle(DataCenter.getInstance().getCurrentBattle());
            }
        } else if ((matcher = DuelCommand.SET.getStringMatcher(command)).find()) {
            controller.set();
        } else if ((matcher = DuelCommand.SET_POSITION.getStringMatcher(command)).find()) {
            controller.setPosition(matcher.group(1));
        } else if ((matcher = DuelCommand.FLIP.getStringMatcher(command)).find()) {
            controller.flip();
        } else if ((matcher = DuelCommand.ATTACK.getStringMatcher(command)).find()) {
            controller.attack(matcher.group(1));
        } else if ((matcher = DuelCommand.DIRECT_ATTACK.getStringMatcher(command)).find()) {
            controller.directAttack();
        } else if ((matcher = DuelCommand.ACTIVE_EFFECT.getStringMatcher(command)).find()) {
            controller.activeEffect();
        } else if ((matcher = DuelCommand.SHOW_GRAYVEYARD.getStringMatcher(command)).find()) {
            controller.showGraveyard();
        }else if ((matcher = DuelMenuHandler.DuelCommand.CARD_SHOW.getStringMatcher(command)).find()) {
            controller.cardShow(matcher.group(1).trim());
        } else if ((matcher = DuelCommand.BACK.getStringMatcher(command)).find()) {
            controller.back();
        } else if ((matcher = DuelCommand.SHOW_SELECTED_CARD.getStringMatcher(command)).find()) {
            controller.showSelected();
        } else if ((matcher = DuelCommand.ENTER_MENU.getStringMatcher(command)).find()) {
            System.out.println("menu navigation is not possible");
        } else if ((matcher = DuelCommand.END_PROGRAM.getStringMatcher(command)).find()) {
            return false;
        } else if ((matcher = DuelCommand.SURRENDER.getStringMatcher(command)).find()) {
            controller.surrender();
        }
        return true;
    }

    public void printBattle(Battle battle) {
        int turn = battle.getTurn();
        Player opponent = battle.getPlayer((turn + 1) % 2);
        System.out.println(opponent.getUser().getNickname() + " : " + opponent.getLP());
        for (int i = 0; i < opponent.getHandCards().size(); i++) {
            System.out.print("\tc");
        }
        System.out.println();
        System.out.println(opponent.getRemainedCards().size());
        BattleCard[] spells = battle.getBattleField().getSpellZone((turn + 1) % 2);
        for (int i = 4; i >= 0; i--) {
            System.out.print("\t");
            if (spells[i] == null) {
                System.out.print("E");
            } else {
                System.out.print(spells[i].getState().getS());
            }
        }
        System.out.println();
        BattleCard[] monsters = battle.getBattleField().getMonsterZone((turn + 1) % 2);
        for (int i = 4; i >= 0; i--) {
            System.out.print("\t");
            if (monsters[i] == null) {
                System.out.print("E");
            } else {
                System.out.print(monsters[i].getState().getS());
            }
        }
        System.out.println();
        System.out.print(battle.getBattleField().getGraveYard((turn + 1) % 2).size() + "\t\t\t\t\t\t");
        if (battle.getBattleField().getFieldZone((turn + 1) % 2) == null)
            System.out.println("E");
        else
            System.out.println("O");
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        if (battle.getBattleField().getFieldZone(turn % 2) == null)
            System.out.print("E\t\t\t\t\t\t");
        else
            System.out.print("O\t\t\t\t\t\t");
        System.out.println(battle.getBattleField().getGraveYard(turn % 2).size());
        monsters = battle.getBattleField().getMonsterZone(turn % 2);
        for (int i = 0; i < 5; i++) {
            System.out.print("\t");
            if (monsters[i] == null) {
                System.out.print("E");
            } else {
                System.out.print(monsters[i].getState().getS());
            }
        }
        System.out.println();
        spells = battle.getBattleField().getSpellZone(turn % 2);
        for (int i = 0; i < 5; i++) {
            System.out.print("\t");
            if (spells[i] == null) {
                System.out.print("E");
            } else {
                System.out.print(spells[i].getState().getS());
            }
        }
        System.out.println();
        Player current = battle.getPlayer(turn % 2);
        System.out.println(" \t\t\t\t\t\t" + current.getRemainedCards().size());

        for (int i = 0; i < current.getHandCards().size(); i++) {
            System.out.print("\tc");
        }
        System.out.println();
        System.out.println(current.getUser().getNickname() + " : " + current.getLP());
    }

    enum DuelCommand {
        ACTIVE_EFFECT("^activate effect$"),
        ATTACK("^attack ([1-5])$"),
        BACK("^back$"),
        DESELECT("^select -d$"),
        DIRECT_ATTACK("^attack direct$"),
        EXIT("^menu exit$"),
        FIELD_OPP("^select --field --opponent$"),
        FLIP("^flip-summon$"),
        MONSTER_OPP("^select --monster --opponent (\\d+)$"),
        SELECT_FIELD("^select --field"),
        SELECT_HAND("^select --hand (\\d+)$"),
        SELECT_MONSTER("^select --monster (\\d+)$"),
        SELECT_SPELL("^select --spell (\\d+)$"),
        SET("^set$"),
        SET_POSITION("^set --position (attack|defense)$"),
        SHOW_SELECTED_CARD("^card show --selected$"),
        SHOW_GRAYVEYARD("^show graveyard$"),
        SHOW_MENU("^menu show-current$"),
        SPELL_OPP("^select --spell --opponent (\\d+)$"),
        SUMMON("^summon$"),
        NEXT_PHASE("^next phase"),
        SURRENDER("^surrender$"),
        END_PROGRAM("^end program$"),
        CARD_SHOW("^card show ((\\w+ *)+)$"),
        ENTER_MENU("^menu enter$");


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
}

