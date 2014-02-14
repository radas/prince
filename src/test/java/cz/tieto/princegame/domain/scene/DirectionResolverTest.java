package cz.tieto.princegame.domain.scene;

import cz.tieto.princegame.client.gameobject.PrinceImpl;
import junit.framework.Assert;

import org.junit.Test;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.action.MoveBackward;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.domain.PrinceGameInstance;
import cz.tieto.princegame.domain.prince.PrinceDTO;

public class DirectionResolverTest {

    @Test
    public void testResolveLookByDirectionForward() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        // act
        int look = DirectionResolver.resolveLookByDirection();

        // assert
        Assert.assertEquals(1, look);

    }

    @Test
    public void testResolveLookByDirectionBackward() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        // act
        int look = DirectionResolver.resolveLookByDirection();

        // assert
        Assert.assertEquals(-1, look);

    }

    @Test
    public void testResolveJumpByDirectionForward() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        // act
        Action action = DirectionResolver.resolveJumpByDirection();

        // assert
        Assert.assertEquals(JumpForward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testResolveJumpByDirectionBackward() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        // act
        Action action = DirectionResolver.resolveJumpByDirection();

        // assert
        Assert.assertEquals(JumpBackward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testResolveMoveByDirectionForward() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        // act
        Action action = DirectionResolver.resolveMoveByDirection();

        // assert
        Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testResolveMoveByDirectionBackward() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        // act
        Action action = DirectionResolver.resolveMoveByDirection();

        // assert
        Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testChangePrinceDirection() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        // act
        princeDto.changePrinceDirection();

        // assert
        Assert.assertEquals(Direction.BACKWARD, princeDto.getDirection());

    }

}
