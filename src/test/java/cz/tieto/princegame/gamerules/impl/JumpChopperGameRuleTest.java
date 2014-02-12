package cz.tieto.princegame.gamerules.impl;

import static org.junit.Assert.*;
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
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.Chopper;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.Pitfall;
import cz.tieto.princegame.gamerules.GameRule;

public class JumpChopperGameRuleTest {

	@Mock
	private Prince prince;

	@Before
	public void onSetUp() {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testJumpForwardNoChopper() {

		// arrange
		DirectionResolver.setDirectionForward();

		Field fieldWithNoChopper = new FieldImpl(null, null, false);

		when(prince.look(1)).thenReturn(fieldWithNoChopper);

		final GameRule gameRule = new JumpChopperGameRule();

		// act
		Action action = gameRule.generateAction(prince);

		// assert
		Assert.assertNull(action);

	}

	@Test
	public void testJumpBackwardNoChopper() {

		// arrange
		DirectionResolver.setDirectionBackward();

		Field fieldWithNoChopper = new FieldImpl(null, null, false);

		when(prince.look(-1)).thenReturn(fieldWithNoChopper);

		final GameRule gameRule = new JumpChopperGameRule();

		// act
		Action action = gameRule.generateAction(prince);

		// assert
		Assert.assertNull(action);

	}

	@Test
	public void testJumpForwardWithChopper() {

		// arrange
		DirectionResolver.setDirectionForward();

		Map<String, String> map = new HashMap<String, String>();

		map.put("closing", "false");
		map.put("opening", "true");

		Obstacle obstacle = new ObstacleImpl(Chopper.CHOPPER_NAME, 1, map);

		Field fieldWithChopper = new FieldImpl(null, obstacle, false);

		when(prince.look(1)).thenReturn(fieldWithChopper);

		final GameRule gameRule = new JumpChopperGameRule();

		// act
		Action action = gameRule.generateAction(prince);

		// assert
		Assert.assertEquals(JumpForward.class.getName(), action.getClass()
				.getName());

	}

	@Test
	public void testJumpBackwardWithChopper() {

		// arrange
		DirectionResolver.setDirectionBackward();
		
		Map<String, String> map = new HashMap<String, String>();

		map.put("closing", "false");
		map.put("opening", "true");

		Obstacle obstacle = new ObstacleImpl(Chopper.CHOPPER_NAME, 1, map);

		Field fieldWithChopper = new FieldImpl(null, obstacle, false);

		when(prince.look(-1)).thenReturn(fieldWithChopper);

		final GameRule gameRule = new JumpChopperGameRule();

		// act
		Action action = gameRule.generateAction(prince);

		// assert
		Assert.assertEquals(JumpBackward.class.getName(), action.getClass()
				.getName());

	}
	
	@Test
	public void testJumpBackwardWithClosedChopper() {

		// arrange
		DirectionResolver.setDirectionBackward();
		
		Map<String, String> map = new HashMap<String, String>();

		map.put("closing", "true");
		map.put("opening", "true");

		Obstacle obstacle = new ObstacleImpl(Chopper.CHOPPER_NAME, 1, map);

		Field fieldWithChopper = new FieldImpl(null, obstacle, false);

		when(prince.look(-1)).thenReturn(fieldWithChopper);

		final GameRule gameRule = new JumpChopperGameRule();

		// act
		Action action = gameRule.generateAction(prince);

		// assert
		Assert.assertNull(action);

	}

}
