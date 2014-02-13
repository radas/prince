package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.GameBoolean;
import cz.tieto.princegame.common.gameobject.Obstacle;

public class KnightDecorator extends ObstacleDecorator {

    public static final String KNIGHT = "knight";

    public KnightDecorator(Obstacle obstacle) {

        super(obstacle);

    }

    @Override
    public boolean canBeJumpedOver() {

        return false;

    }

    @Override
    public boolean canBeJumpedOverNow() {

        throw new UnsupportedOperationException("Can not be applied on Knight");
    }

    @Override
    public boolean isKillable() {

        return true;

    }

    @Override
    public boolean isDead() {

        String dead = getObstacle().getProperty("dead");

        if (dead == null) {

            return false;

        }

        return GameBoolean.TRUE.equals(dead);

    }

}
