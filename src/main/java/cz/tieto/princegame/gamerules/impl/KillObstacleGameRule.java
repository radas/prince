package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Use;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.obstacle.ObstacleDecorator;
import cz.tieto.princegame.domain.obstacle.ObstacleDecoratorFactory;
import cz.tieto.princegame.domain.weapon.Sword;
import cz.tieto.princegame.gamerules.GameRule;

public class KillObstacleGameRule implements GameRule {

    @Override
    public Action generateAction(Prince prince) {

        int lookByDirection = DirectionResolver.resolveLookByDirection();

        Field lookField = prince.look(lookByDirection);

        if (lookField == null) {

            return null;

        }

        Obstacle obstacle = lookField.getObstacle();

        if (obstacle == null) {
            return null;
        }

        ObstacleDecorator decoratedObstacle = ObstacleDecoratorFactory.resolveObstacle(obstacle);

        boolean isKillable = decoratedObstacle.isKillable();

        if (!isKillable) {

            return null;

        }

        boolean isDead = decoratedObstacle.isDead();

        if (isDead) {

            // TODO return action that passes through the obstacle
            return null;
        }

        boolean hasSword = Sword.hasSword(prince);

        if (!hasSword) {

            // TODO change direction and return move action, we can not kill obstacle
            return null;
        }

        Equipment sword = Sword.obtainSword(prince);

        if (sword == null) {

            return null;

        }

        Action kill = new Use(sword, obstacle);

        return kill;

    }

}
