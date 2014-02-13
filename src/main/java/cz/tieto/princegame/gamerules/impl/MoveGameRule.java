package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Grab;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.obstacle.ObstacleDecorator;
import cz.tieto.princegame.domain.obstacle.ObstacleDecoratorFactory;
import cz.tieto.princegame.gamerules.GameRule;

public class MoveGameRule implements GameRule {

    @Override
    public Action generateAction(Prince prince) {

        int lookByDirection = DirectionResolver.resolveLookByDirection();

        Field lookField = prince.look(lookByDirection);

        // game scene boundary reached, change direction and continue on move/jump
        if (lookField == null) {

            DirectionResolver.changePrinceDirection();
            Action action = getActionWithObstacle(prince);
            if (action != null) {
                return action;
            }

        }

        Obstacle obstacle = lookField.getObstacle();

        // if there is no obstacle we can move
        if (obstacle == null) {
            Action move = DirectionResolver.resolveMoveByDirection();
            return move;
        }

        // there is any obstacle in the current direction, so try to decide if we can continue
        Action action = getActionWithObstacle(prince);
        
        if (action != null) {
            return action;
        }

	// there is obstacle, but we can not move in this direction,
        // so change prince direction and get appropriate action
        DirectionResolver.changePrinceDirection();

        Action action2 = getActionWithObstacle(prince);
        if (action2 != null) {
            return action2;
        }
        throw new IllegalStateException();

    }

    private Action getActionWithObstacle(Prince prince) {

        int actualLook = DirectionResolver.resolveLookByDirection();

        Field actualLookField = prince.look(actualLook);

        Obstacle actualObstacle = actualLookField.getObstacle();

        if (actualObstacle == null) {
            Action move = DirectionResolver.resolveMoveByDirection();
            return move;
        }

        ObstacleDecorator decoratedObstacle = ObstacleDecoratorFactory.resolveObstacle(actualObstacle);

        boolean isKillable = decoratedObstacle.isKillable();

        if (isKillable) {

            boolean isDead = decoratedObstacle.isDead();

            if (isDead) {
                Action move = DirectionResolver.resolveMoveByDirection();
                return move;
            }

        }
        
        boolean isJumpable = decoratedObstacle.canBeJumpedOver();

        if (isJumpable) {

            boolean canBeJumpedNow = decoratedObstacle.canBeJumpedOverNow();

            if (canBeJumpedNow) {
                Action jump = DirectionResolver.resolveJumpByDirection();
                return jump;
            } else {
                return new Grab();
            }
        
        }
        
        return null;

    }

}
