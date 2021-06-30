package app.model.Battle;

import app.model.CardTypes.CardType;
import app.model.Cards.Card;
import app.model.Cards.Monster;
import app.model.IllegalActionException;
import app.model.User;

import java.util.ArrayList;

public class Battle {
    private final int rounds;
    private int currentRound;
    private Player player0;
    private Player player1;
    private BattleField battleField;
    private int selectedAddress;
    private SelectType selectType;
    private Phases currentPhase;
    private boolean hasSetOrSummon;
    private int turn;
    private BattleCard battleCard;

    public Battle(User currentUser, User secondPlayer, int round) {
        player0 = new Player(8000, currentUser);
        player1 = new Player(8000, secondPlayer);
        this.rounds = round;
        this.battleField = new BattleField();
    }

    public void select(int selectedAddress, SelectType selectType) {
        this.selectType = selectType;
        this.selectedAddress = selectedAddress;
    }

    public Player getPlayer(int i) {
        if (i == 0)
            return player0;
        return player1;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getCurrentPlayer() {
        return getPlayer(turn % 2);
    }

    public void deselect() throws IllegalActionException {
        if (selectType == null) {
            throw new IllegalActionException("no card is selected yet");
        }
        selectType = null;
    }

    public void summon() throws IllegalActionException {
        if (selectType == null) {
            throw new IllegalActionException("no card is selected yet");
        }
        if (selectType != SelectType.SELECT_HAND) {
            throw new IllegalActionException("you can’t summon this card");
        }
        ArrayList<BattleCard> handCards = getCurrentPlayer().getHandCards();
        BattleCard selectedCard = handCards.get(selectedAddress);
        if (selectedCard.getCard().getType() != CardType.MONSTER) {
            throw new IllegalActionException("you can’t summon this card");
        }
        if (currentPhase != Phases.MAIN_PHASE_1 && currentPhase != Phases.MAIN_PHASE_2) {
            throw new IllegalActionException("action not allowed in this phase");
        }
        BattleCard[] monsterZone = battleField.getMonsterZone(turn % 2);
        if (!hasCapacity(monsterZone)) {
            throw new IllegalActionException("monster card zone is full");
        }
        if (hasSetOrSummon) {
            throw new IllegalActionException("you already summoned/set on this turn");
        }
        Monster card = ((Monster) selectedCard.getCard());
        if (card.getLevel() <= 4) {

        } else if (card.getLevel() <= 6) {

        } else {

        }
        for (int i = 0; i < 5; i++) {
            if (monsterZone[i] == null) {
                monsterZone[i] = selectedCard;
                handCards.remove(selectedAddress);
            }
        }

    }

    private boolean hasCapacity(BattleCard[] zone) {
        for (int i = 0; i < 5; i++) {
            if (zone[i] == null)
                return true;

        }
        return false;
    }

    public Phases getCurrentPhase() {
        return currentPhase;
    }

    public void winGame(int i) {
        int scoreRewardAmount = 1000 * rounds;
        if (i == 0) {
            player0.getUser().increaseScore(scoreRewardAmount);
            player0.getUser().increaseBalance(scoreRewardAmount + (player0.getMaxLPReward() * rounds));
            player1.getUser().increaseBalance(100 * rounds);
        } else {
            player1.getUser().increaseScore(scoreRewardAmount);
            player1.getUser().increaseBalance(scoreRewardAmount + (player1.getMaxLPReward() * rounds));
            player0.getUser().increaseBalance(100 * rounds);
        }
    }

    public void winRound(int i) {
        if (i == 0) {
        } else {
        }
        currentRound++;
    }

    public Phases nextPhase() {
        return null;
    }

    public SelectType getSelectType() {
        return selectType;
    }

    public BattleCard getSelected() throws IllegalActionException {
        if (selectType == SelectType.SELECT_MONSTER) {
            BattleCard[] monsterZone = battleField.getMonsterZone(turn % 2);
            return monsterZone[selectedAddress];
        }
        if (selectType == SelectType.MONSTER_OPPONENT){
            BattleCard[] monsterOpponent = battleField.getMonsterZone((turn+1)%2);
            if (monsterOpponent[selectedAddress].getState() == State.DEFENSIVE_HIDDEN){
                throw new IllegalActionException("card is not visible");
            }
        }
        if (selectType == SelectType.SELECT_SPELL){
            BattleCard[] spellZone = battleField.getSpellZone(turn%2);
            return spellZone[selectedAddress];
        }
        if (selectType == SelectType.SPELL_OPPONENT){
            BattleCard[] spellOpponent = battleField.getSpellZone((turn+1)%2);
            if (spellOpponent[selectedAddress].getState() == State.HIDDEN){
                throw new IllegalActionException("card is not visible");
            }
        }
        if (selectType == SelectType.SELECT_FIELLD){
            return battleField.getFieldZone(turn%2);
        }
        if (selectType == SelectType.FIELD_OPPONENT){
            return battleField.getFieldZone((turn+1)%2);
        }
        if (selectType == SelectType.SELECT_HAND){
            BattleCard[] handCard = getCurrentPlayer().getHandCards().toArray(new BattleCard[0]);
            return handCard[selectedAddress];
        }
        throw new IllegalActionException("no card is selected yet");
    }

}
