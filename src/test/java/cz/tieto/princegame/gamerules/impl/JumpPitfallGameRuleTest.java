package cz.tieto.princegame.gamerules.impl;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cz.tieto.princegame.client.gameobject.FieldImpl;
import cz.tieto.princegame.client.gameobject.ObstacleImpl;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.gamerules.GameRule;

public class JumpPitfallGameRuleTest {

    @Mock
    private Prince prince;

    @Before
    public void onSetUp() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testJumpForwardNoPitfall() {
        /*	
         // arrange
         DirectionResolver.setDirectionForward();
		
         Field fieldWithNoPitfall = new FieldImpl(null, null, false);
		
         when(prince.look(1)).thenReturn(fieldWithNoPitfall);
		
         final GameRule gameRule = new JumpPitfallGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertNull(action);
         */
    }

    @Test
    public void testJumpBackwardNoPitfall() {
        /*	
         // arrange
         DirectionResolver.setDirectionBackward();
		
         Field fieldWithNoPitfall = new FieldImpl(null, null, false);
		
         when(prince.look(-1)).thenReturn(fieldWithNoPitfall);
		
         final GameRule gameRule = new JumpPitfallGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertNull(action);
         */
    }

    @Test
    public void testJumpForwardWithPitfall() {
        /*
         // arrange
         DirectionResolver.setDirectionForward();
		
         Obstacle obstacle = new ObstacleImpl(Pitfall.PITFALL_NAME, 1, null);
		
         Field fieldWithPitfall = new FieldImpl(null, obstacle, false);
		
         when(prince.look(1)).thenReturn(fieldWithPitfall);
		
         final GameRule gameRule = new JumpPitfallGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertEquals(JumpForward.class.getName(), action.getClass().getName());
         */
    }

    @Test
    public void testJumpBackwardWithPitfall() {
        /*
         // arrange
         DirectionResolver.setDirectionBackward();
		
         Obstacle obstacle = new ObstacleImpl(Pitfall.PITFALL_NAME, 1, null);
		
         Field fieldWithPitfall = new FieldImpl(null, obstacle, false);
		
         when(prince.look(-1)).thenReturn(fieldWithPitfall);
		
         final GameRule gameRule = new JumpPitfallGameRule();
		
         // act
         Action action = gameRule.generateAction(prince);
		
         // assert
         Assert.assertEquals(JumpBackward.class.getName(), action.getClass().getName());
         */
    }

}
