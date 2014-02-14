package cz.tieto.princegame.domain.prince;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Prince;

public class PrinceDTO {

    private final int maxHealth;

    private int actualHealth;

    private int healthInPreviousRound;

    private boolean waitUntilHealed;

    private Action actionInPreviousRound;

    public PrinceDTO(Prince prince) {

        maxHealth = prince.getMaxHealth() + 10;

        actualHealth = prince.getHealth();

        healthInPreviousRound = prince.getHealth();

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

}
