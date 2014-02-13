package cz.tieto.princegame.common;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.domain.prince.PrinceInstance;
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

        PrinceDTO princeDto = PrinceInstance.getPrince();

        if (princeDto == null) {

            princeDto = new PrinceDTO(prince);
            PrinceInstance.setPrince(princeDto);

        }

        Action action = gameRulesMap.generateAction(prince);

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
