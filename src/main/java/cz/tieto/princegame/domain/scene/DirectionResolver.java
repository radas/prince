package cz.tieto.princegame.domain.scene;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.action.MoveBackward;
import cz.tieto.princegame.common.action.MoveForward;

public class DirectionResolver {

    private static Direction direction = Direction.FORWARD;

    public static int resolveLookByDirection() {

        if (direction.compareTo(Direction.FORWARD) == 0) {

            return 1;

        }

        return -1;

    }

    public static Action resolveJumpByDirection() {

        if (direction.compareTo(Direction.FORWARD) == 0) {

            return new JumpForward();

        }

        return new JumpBackward();

    }

    public static Action resolveMoveByDirection() {

        if (direction.compareTo(Direction.FORWARD) == 0) {

            return new MoveForward();

        }

        return new MoveBackward();

    }

    public static void changePrinceDirection() {

        if (direction.compareTo(Direction.FORWARD) == 0) {

            direction = Direction.BACKWARD;

        } else {

            direction = Direction.FORWARD;

        }

    }

    public static void setDirectionForward() {

        direction = Direction.FORWARD;

    }

    public static void setDirectionBackward() {

        direction = Direction.BACKWARD;

    }

    public static Direction getDirection() {

        return direction;

    }

    public static void setDirection(Direction newDirection) {

        direction = newDirection;

    }

}
