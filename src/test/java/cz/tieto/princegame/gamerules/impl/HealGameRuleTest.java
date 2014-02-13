package cz.tieto.princegame.gamerules.impl;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cz.tieto.princegame.client.gameobject.FieldImpl;
import cz.tieto.princegame.client.gameobject.ObstacleImpl;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.gamerules.GameRule;

public class HealGameRuleTest {

    @Mock
    private Prince prince;

    @Before
    public void onSetUp() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testHealLookForwardWithNoKnightWithLowHealth() {

        // arrange
        DirectionResolver.setDirectionForward();

        Field fieldWithNoObstacle = new FieldImpl(null, null, false);

        when(prince.look(1)).thenReturn(fieldWithNoObstacle);
        when(prince.getHealth()).thenReturn(3);

        final GameRule gameRule = new HealGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(Heal.class.getName(), action.getClass().getName());

    }

    @Test
    public void testHealLookBackwardWithNoKnightWithLowHealth() {

        // arrange
        DirectionResolver.setDirectionBackward();

        Field fieldWithNoObstacle = new FieldImpl(null, null, false);

        when(prince.look(-1)).thenReturn(fieldWithNoObstacle);
        when(prince.getHealth()).thenReturn(3);

        final GameRule gameRule = new HealGameRule();

        // act
        Action action = gameRule.generateAction(prince);

        // assert
        Assert.assertEquals(Heal.class.getName(), action.getClass().getName());

    }

    @Test
    public void testHealLookForwardWithFullHealth() {
        /*
         // arrange
         when(prince.getHealth()).thenReturn(Health.MAX_HEALTH);
		
         final GameRule gameRule = new HealGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertNull(action);
         */
    }

    @Test
    public void testHealLookBackwardWithFullHealth() {
        /*
         // arrange
         when(prince.getHealth()).thenReturn(Health.MAX_HEALTH);
		
         final GameRule gameRule = new HealGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertNull(action);
         */
    }

    @Test
    public void testHealLookForwardWithKnightWithLowHealth() {
        /*
         // arrange
         DirectionResolver.setDirectionForward();
		
         Map<String, String> map = new HashMap<String,String>();
		
         map.put("dead", "false");
		
         Obstacle knight = new ObstacleImpl(Knight.KNIGHT_NAME, 1, map);
         Field fieldWithKnight = new FieldImpl(null, knight, false);
		
         when(prince.look(1)).thenReturn(fieldWithKnight);
         when(prince.getHealth()).thenReturn(3);
		
         final GameRule gameRule = new HealGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertNull(action);
         */
    }

    @Test
    public void testHealLookBackwardWithKnightWithLowHealth() {
        /*
         // arrange
         DirectionResolver.setDirectionBackward();
		
         Map<String, String> map = new HashMap<String,String>();
		
         map.put("dead", "false");
		
         Obstacle knight = new ObstacleImpl(Knight.KNIGHT_NAME, 1, map);
         Field fieldWithKnight = new FieldImpl(null, knight, false);
		
         when(prince.look(-1)).thenReturn(fieldWithKnight);
         when(prince.getHealth()).thenReturn(3);
		
         final GameRule gameRule = new HealGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertNull(action);
         */
    }

}
