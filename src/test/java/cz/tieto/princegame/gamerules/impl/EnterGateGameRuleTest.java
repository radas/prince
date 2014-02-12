package cz.tieto.princegame.gamerules.impl;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cz.tieto.princegame.client.gameobject.FieldImpl;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.EnterGate;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.gamerules.GameRule;

public class EnterGateGameRuleTest {
	
	@Mock
	private Prince prince;
	
	@Before
	public void onSetUp() {
		
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void testFieldIsGate() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		Field gateField = new FieldImpl(null, null, true);
		
		when(prince.look(0)).thenReturn(gateField);
		
		final GameRule gameRule = new EnterGateGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertEquals(EnterGate.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testFieldIsNotGate() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		Field gateField = new FieldImpl(null, null, false);
		
		when(prince.look(0)).thenReturn(gateField);
		
		final GameRule gameRule = new EnterGateGameRule();
		
		// act
		Action action = gameRule.generateAction(prince);
		
		// assert
		Assert.assertNull(action);
		
	}

}
