package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class PitfallDecorator extends ObstacleDecorator {

    public static final String PITFALL = "pitfall";

    public PitfallDecorator(Obstacle obstacle) {

        super(obstacle);

    }

    @Override
    public boolean canBeJumpedOver() {

        return true;

    }

    @Override
    public boolean canBeJumpedOverNow() {

        return true;

    }

    @Override
    public boolean isKillable() {

        return false;

    }

    @Override
    public boolean isDead() {

        throw new UnsupportedOperationException("Can not be applied on Pitfall");

    }

}
