package cz.tieto.princegame.gamerules.impl;

import static org.mockito.Mockito.when;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cz.tieto.princegame.client.gameobject.FieldImpl;
import cz.tieto.princegame.client.gameobject.ObstacleImpl;
import cz.tieto.princegame.client.gameobject.PrinceImpl;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Grab;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.action.MoveBackward;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.common.util.GameBoolean;
import cz.tieto.princegame.domain.PrinceGameInstance;
import cz.tieto.princegame.domain.obstacle.ChopperDecorator;
import cz.tieto.princegame.domain.obstacle.KnightDecorator;
import cz.tieto.princegame.domain.obstacle.PitfallDecorator;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.domain.scene.DirectionResolver;
import cz.tieto.princegame.gamerules.GameRule;
import java.util.HashMap;
import java.util.Map;

public class MoveGameRuleTest {

    @Mock
    private Prince prince;

    @Before
    public void onSetUp() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testMoveForwardNoObstacle() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        Field fieldWithNoObstacle = new FieldImpl(null, null, false);

        when(prince.look(1)).thenReturn(fieldWithNoObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testMoveBackwardNoObstacle() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        Field fieldWithNoObstacle = new FieldImpl(null, null, false);

        when(prince.look(-1)).thenReturn(fieldWithNoObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testJumpForwardWithPitfall() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        Obstacle obstacle = new ObstacleImpl(PitfallDecorator.PITFALL, 1, null);

        Field fieldWithObstacle = new FieldImpl(null, obstacle, false);

        when(prince.look(1)).thenReturn(fieldWithObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(JumpForward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testJumpBackwardWithPitfall() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        Obstacle obstacle = new ObstacleImpl(PitfallDecorator.PITFALL, 1, null);

        Field fieldWithObstacle = new FieldImpl(null, obstacle, false);

        when(prince.look(-1)).thenReturn(fieldWithObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(JumpBackward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testMoveForwardWithDeadObstacle() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        Map<String, String> map = new HashMap<String, String>();

        map.put(KnightDecorator.DEAD, GameBoolean.TRUE);

        Obstacle obstacle = new ObstacleImpl(KnightDecorator.KNIGHT, 1, map);

        Field fieldWithObstacle = new FieldImpl(null, obstacle, false);

        when(prince.look(1)).thenReturn(fieldWithObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testMoveBackwardWithDeadObstacle() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        Map<String, String> map = new HashMap<String, String>();

        map.put(KnightDecorator.DEAD, GameBoolean.TRUE);

        Obstacle obstacle = new ObstacleImpl(KnightDecorator.KNIGHT, 1, map);

        Field fieldWithObstacle = new FieldImpl(null, obstacle, false);

        when(prince.look(-1)).thenReturn(fieldWithObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testJumpForwardWithClosedChopper() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        Map<String, String> map = new HashMap<String, String>();

        map.put(ChopperDecorator.CLOSING, GameBoolean.TRUE);
        map.put(ChopperDecorator.OPENING, GameBoolean.FALSE);

        Obstacle obstacle = new ObstacleImpl(ChopperDecorator.CHOPPER, 1, map);

        Field fieldWithObstacle = new FieldImpl(null, obstacle, false);

        when(prince.look(1)).thenReturn(fieldWithObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(Grab.class.getName(), action.getClass().getName());

    }

    @Test
    public void testJumpBackwardWithClosedChopper() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        Map<String, String> map = new HashMap<String, String>();

        map.put(ChopperDecorator.CLOSING, GameBoolean.TRUE);
        map.put(ChopperDecorator.OPENING, GameBoolean.FALSE);

        Obstacle obstacle = new ObstacleImpl(ChopperDecorator.CHOPPER, 1, map);

        Field fieldWithObstacle = new FieldImpl(null, obstacle, false);

        when(prince.look(-1)).thenReturn(fieldWithObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(Grab.class.getName(), action.getClass().getName());

    }

    @Test
    public void testSceneEndReached() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionForward();

        Field fieldWithoutObstacle = new FieldImpl(null, null, false);

        when(prince.look(1)).thenReturn(null);
        when(prince.look(-1)).thenReturn(fieldWithoutObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());

    }

    @Test
    public void testSceneStartReached() {

        // arrange
        PrinceGameInstance.initInstance(new PrinceImpl(1, null, 1, 1, null, null));
        PrinceDTO princeDto = PrinceGameInstance.getInstance().getPrinceDto();

        princeDto.setDirectionBackward();

        Field fieldWithoutObstacle = new FieldImpl(null, null, false);

        when(prince.look(-1)).thenReturn(null);
        when(prince.look(1)).thenReturn(fieldWithoutObstacle);

        final GameRule gameRule = new MoveGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());

    }

}
