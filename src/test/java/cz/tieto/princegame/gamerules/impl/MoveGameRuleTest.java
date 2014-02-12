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
import cz.tieto.princegame.common.action.MoveBackward;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.Knight;
import cz.tieto.princegame.domain.Pitfall;
import cz.tieto.princegame.gamerules.GameRule;

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
		DirectionResolver.setDirectionForward();
		
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
		DirectionResolver.setDirectionBackward();
		
		Field fieldWithNoObstacle = new FieldImpl(null, null, false);
		
		when(prince.look(-1)).thenReturn(fieldWithNoObstacle);
		
		final GameRule gameRule = new MoveGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testMoveForwardWithObstacle() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		Obstacle obstacle = new ObstacleImpl(Pitfall.PITFALL_NAME, 1, null);
		
		Field fieldWithObstacle = new FieldImpl(null, obstacle, false);
		
		when(prince.look(1)).thenReturn(fieldWithObstacle);
		
		final GameRule gameRule = new MoveGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testMoveBackwardWithObstacle() {
		
		// arrange
		DirectionResolver.setDirectionBackward();
		
		Obstacle obstacle = new ObstacleImpl(Pitfall.PITFALL_NAME, 1, null);
		
		Field fieldWithObstacle = new FieldImpl(null, obstacle, false);
		
		when(prince.look(-1)).thenReturn(fieldWithObstacle);
		
		final GameRule gameRule = new MoveGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testMoveForwardWithDeadKnight() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("dead", "true");
		
		Obstacle obstacle = new ObstacleImpl(Knight.KNIGHT_NAME, 1, map);
		
		Field fieldWithObstacle = new FieldImpl(null, obstacle, false);
		
		when(prince.look(1)).thenReturn(fieldWithObstacle);
		
		final GameRule gameRule = new MoveGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testMoveBackwardWithDead() {
		
		// arrange
		DirectionResolver.setDirectionBackward();
		
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("dead", "true");
		
		Obstacle obstacle = new ObstacleImpl(Knight.KNIGHT_NAME, 1, map);
		
		Field fieldWithObstacle = new FieldImpl(null, obstacle, false);
		
		when(prince.look(-1)).thenReturn(fieldWithObstacle);
		
		final GameRule gameRule = new MoveGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());
	}
	
	@Test
	public void testMoveForwardWithUnknownObstacle() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		Obstacle obstacle = new ObstacleImpl("unknown", 1, null);
		
		Field fieldWithObstacle = new FieldImpl(null, obstacle, false);
		
		when(prince.look(1)).thenReturn(fieldWithObstacle);
		
		final GameRule gameRule = new MoveGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());
		
	}
	
	

}
