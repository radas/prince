package cz.tieto.princegame.domain;

import junit.framework.Assert;

import org.junit.Test;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.action.JumpForward;
import cz.tieto.princegame.common.action.MoveBackward;
import cz.tieto.princegame.common.action.MoveForward;
import cz.tieto.princegame.domain.DirectionResolver;

public class DirectionResolverTest {

	@Test
	public void testResolveLookByDirectionForward() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		// act
		int look = DirectionResolver.resolveLookByDirection();
		
		// assert
		Assert.assertEquals(1, look);
		
	}
	
	@Test
	public void testResolveLookByDirectionBackward() {
		
		// arrange
		DirectionResolver.setDirectionBackward();
		
		// act
		int look = DirectionResolver.resolveLookByDirection();
		
		// assert
		Assert.assertEquals(-1, look);
		
	}
	
	@Test
	public void testResolveJumpByDirectionForward() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		// act
		Action action = DirectionResolver.resolveJumpByDirection();
		
		// assert
		Assert.assertEquals(JumpForward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testResolveJumpByDirectionBackward() {
		
		// arrange
		DirectionResolver.setDirectionBackward();
		
		// act
		Action action = DirectionResolver.resolveJumpByDirection();
		
		// assert
		Assert.assertEquals(JumpBackward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testResolveMoveByDirectionForward() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		// act
		Action action = DirectionResolver.resolveMoveByDirection();
		
		// assert
		Assert.assertEquals(MoveForward.class.getName(), action.getClass().getName());
		
	}

	@Test
	public void testResolveMoveByDirectionBackward() {
		
		// arrange
		DirectionResolver.setDirectionBackward();
		
		// act
		Action action = DirectionResolver.resolveMoveByDirection();
		
		// assert
		Assert.assertEquals(MoveBackward.class.getName(), action.getClass().getName());
		
	}
	
	@Test
	public void testChangePrinceDirection() {
		
		// arrange
		DirectionResolver.setDirectionForward();
		
		// act
		DirectionResolver.changePrinceDirection();
		
		// assert
		Assert.assertEquals(Direction.BACKWARD, DirectionResolver.getDirection());
		
	}
	
}
