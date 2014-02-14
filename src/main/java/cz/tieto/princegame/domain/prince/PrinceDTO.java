package cz.tieto.princegame.domain.prince;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.scene.Direction;

public class PrinceDTO {

    private final int maxHealth;

    private int actualHealth;

    private int healthInPreviousRound;

    private boolean waitUntilHealed;

    private Action actionInPreviousRound;

    private Direction direction;

    public PrinceDTO(Prince prince) {

        maxHealth = prince.getMaxHealth() + 10;

        actualHealth = prince.getHealth();

        healthInPreviousRound = prince.getHealth();

        direction = direction.FORWARD;

    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealthInPreviousRound() {
        return healthInPreviousRound;
    }

    public void setHealthInPreviousRound(int healthInPreviousRound) {
        this.healthInPreviousRound = healthInPreviousRound;
    }

    public Action getActionInPreviousRound() {
        return actionInPreviousRound;
    }

    public void setActionInPreviousRound(Action actionInPreviousRound) {
        this.actionInPreviousRound = actionInPreviousRound;
    }

    public boolean isWaitUntilHealed() {
        if (healthInPreviousRound == actualHealth) {
            waitUntilHealed = false;
        }
        return waitUntilHealed;
    }

    public void setWaitUntilHealed(boolean waitUntilHealed) {
        this.waitUntilHealed = waitUntilHealed;
    }

    public void changePrinceDirection() {

        if (direction.compareTo(Direction.FORWARD) == 0) {

            direction = Direction.BACKWARD;

        } else {

            direction = Direction.FORWARD;

        }

    }

    public void setDirectionForward() {

        direction = Direction.FORWARD;

    }

    public void setDirectionBackward() {

        direction = Direction.BACKWARD;

    }

    public Direction getDirection() {

        return direction;

    }

    public void setDirection(Direction newDirection) {

        direction = newDirection;

    }

}
