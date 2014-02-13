package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.gameobject.Obstacle;

public abstract class ObstacleDecorator {

    private final Obstacle obstacle;

    public ObstacleDecorator(Obstacle obstacle) {

        this.obstacle = obstacle;

    }

    public Obstacle getObstacle() {

        return obstacle;

    }

    public abstract boolean isKillable();

    public abstract boolean isDead();

    public abstract boolean canBeJumpedOver();

    public abstract boolean canBeJumpedOverNow();

}
