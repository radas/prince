package cz.tieto.princegame.common;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.PrinceGameInstance;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.gamerules.GameRulesMap;
import cz.tieto.princegame.gamerules.GameRulesMapImpl;
import cz.tieto.princegame.gamerules.impl.EnterGateGameRule;
import cz.tieto.princegame.gamerules.impl.GrabEquipmentGameRule;
import cz.tieto.princegame.gamerules.impl.HealGameRule;
import cz.tieto.princegame.gamerules.impl.KillObstacleGameRule;
import cz.tieto.princegame.gamerules.impl.MoveGameRule;

public class POPGameStrategy implements GameStrategy {

    private static final GameRulesMap gameRulesMap = initGameRulesMap();

    public Action step(Prince prince) {

        PrinceGameInstance princeGameInstance = PrinceGameInstance.getInstance();

        // 1st round
        if (princeGameInstance == null) {

            PrinceGameInstance.initInstance(prince);
            princeGameInstance = PrinceGameInstance.getInstance();
            
        }

        Action action = gameRulesMap.generateAction(prince);

        PrinceDTO princeDto = princeGameInstance.getPrinceDto();

        princeDto.setHealthInPreviousRound(prince.getHealth());
        princeDto.setActionInPreviousRound(action);

        return action;

    }

    private static GameRulesMap initGameRulesMap() {

        final GameRulesMap map = new GameRulesMapImpl();

        map.addGameRule(new EnterGateGameRule());
        map.addGameRule(new GrabEquipmentGameRule());
        map.addGameRule(new HealGameRule());
        map.addGameRule(new KillObstacleGameRule());

        map.setDefaultGameRule(new MoveGameRule());

        return map;

    }

}
