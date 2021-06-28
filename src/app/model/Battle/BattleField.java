package app.model.Battle;

import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private List<ArrayList<BattleCard>> graveYard = new ArrayList<>(2);
    private BattleCard[] fieldZone = new BattleCard[2];
    private List<BattleCard[]> monsterCards = new ArrayList<>(2);
    private List<BattleCard[]> spellTrapCards = new ArrayList<>(2);

    public BattleField() {
        graveYard.add(new ArrayList<>());
        graveYard.add(new ArrayList<>());
        monsterCards.add(new BattleCard[5]);
        monsterCards.add(new BattleCard[5]);
        spellTrapCards.add(new BattleCard[5]);
        spellTrapCards.add(new BattleCard[5]);
    }


    public BattleCard[] getMonsterZone(int i) {
        return monsterCards.get(i);
    }

    public BattleCard[] getSpellZone(int i) {
        return spellTrapCards.get(i);
    }

    public BattleCard[] getFieldZone() {
        return fieldZone;
    }
}
