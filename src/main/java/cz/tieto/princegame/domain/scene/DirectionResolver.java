package cz.tieto.princegame.domain.scene;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.action.MoveBackward;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.domain.PrinceGameInstance;
import cz.tieto.princegame.domain.prince.PrinceDTO;

public class DirectionResolver {

    public static int resolveLookByDirection() {

        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        if (princeDto.getDirection().compareTo(Direction.FORWARD) == 0) {

            return 1;

        }

        return -1;

    }

    public static Action resolveJumpByDirection() {

        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        if (princeDto.getDirection().compareTo(Direction.FORWARD) == 0) {

            return new JumpForward();

        }

        return new JumpBackward();

    }

    public static Action resolveMoveByDirection() {

        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        if (princeDto.getDirection().compareTo(Direction.FORWARD) == 0) {

            return new MoveForward();

        }

        return new MoveBackward();

    }

}
