package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.Direction;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.domain.prince.PrinceInstance;
import cz.tieto.princegame.gamerules.GameRule;

public class HealGameRule implements GameRule {
    
    private final int MIN_HEALTH_TO_CONTINUE = 6;

    @Override
    public Action generateAction(Prince prince) {

        PrinceDTO princeDto = PrinceInstance.getPrince();
        
        // if there is no need for healing, return null;
        if (prince.getHealth() >= princeDto.getMaxHealth()) {

            princeDto.setWaitUntilHealed(false);
            return null;

        }
        
        Action actionInPreviousRound = princeDto.getActionInPreviousRound();
        
        boolean waitUntilHealed = princeDto.isWaitUntilHealed();
        
        int healthDiff = prince.getHealth() - princeDto.getHealthInPreviousRound();
        
        if (healthDiff < -3) {
            
            if (prince.getHealth() < 6) {
            MoveGameRule moveGameRule = new MoveGameRule();

                    Direction originalDirection = DirectionResolver.getDirection();

                    DirectionResolver.changePrinceDirection();

                    Action stepBackAction = moveGameRule.generateAction(prince);

                    DirectionResolver.setDirection(originalDirection);
                    princeDto.setWaitUntilHealed(true);
                    System.out.println("StepBack");
                    return stepBackAction;
                    
            }
            
        }
        
        // heal in previous round, but something is killing us constantly,
        // we must step backward
        if ((actionInPreviousRound instanceof Heal) && (healthDiff <=0)) {
            MoveGameRule moveGameRule = new MoveGameRule();

                    Direction originalDirection = DirectionResolver.getDirection();

                    DirectionResolver.changePrinceDirection();

                    Action stepBackAction = moveGameRule.generateAction(prince);

                    DirectionResolver.setDirection(originalDirection);
                    princeDto.setWaitUntilHealed(true);
                    System.out.println("StepBack");
                    return stepBackAction;
        }
        
        if (prince.getHealth() < MIN_HEALTH_TO_CONTINUE) {
            
            princeDto.setWaitUntilHealed(true);
            
            return new Heal();
            
        }
        
        if (waitUntilHealed) {
            
            return new Heal();
            
        }
        
        return null;

    }

}
