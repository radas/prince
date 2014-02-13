package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Grab;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.obstacle.ObstacleDecorator;
import cz.tieto.princegame.domain.obstacle.ObstacleDecoratorFactory;
import cz.tieto.princegame.gamerules.GameRule;

public class MoveGameRule implements GameRule {

	@Override
	public Action generateAction(Prince prince) {
		
		int lookByDirection = DirectionResolver.resolveLookByDirection();
		
		Field lookField = prince.look(lookByDirection);
		
		// game scene boundary reached, change direction and continue on move/jump
		if (lookField == null) {
			
			DirectionResolver.changePrinceDirection();
			Action action = getActionWithObstacle(prince);
			return action;
			
		}
		
		Obstacle obstacle = lookField.getObstacle();
		
		// if there is no obstacle we can move
		if (obstacle == null) {
			Action move = DirectionResolver.resolveMoveByDirection();
			return move;
		}
		
		ObstacleDecorator decoratedObstacle = ObstacleDecoratorFactory.resolveObstacle(obstacle);
		
		if (decoratedObstacle.isKillable()) {
			
			boolean isDead = decoratedObstacle.isDead();
			
			if (isDead) {
				Action move = DirectionResolver.resolveMoveByDirection();
				return move;
			}
			
		}
		
		// there is obstacle, but we can not move in this direction,
		// so change prince direction and get appropriate action
		DirectionResolver.changePrinceDirection();
		
		Action action = getActionWithObstacle(prince);
		return action;
		
	}
	
	private Action getActionWithObstacle(Prince prince) {
		
		int actualLook = DirectionResolver.resolveLookByDirection();
		
		Field actualLookField = prince.look(actualLook);
		
		Obstacle actualObstacle = actualLookField.getObstacle();
		
		if (actualObstacle == null) {
			Action move = DirectionResolver.resolveMoveByDirection();
			return move;
		}
		
		ObstacleDecorator decoratedObstacle = ObstacleDecoratorFactory.resolveObstacle(actualObstacle);
		
		boolean isKillable = decoratedObstacle.isKillable();
		
		if (isKillable) {
			
			boolean isDead = decoratedObstacle.isDead();
			
			if (isDead) {
				Action move = DirectionResolver.resolveMoveByDirection();
				return move;
			}
			
		}
		
		boolean isJumpable = decoratedObstacle.canBeJumpedOver();
		
		if (!isJumpable) {
			//throw new IllegalStateException("Can not resolve move action");
			return new Grab();
		}
		
		boolean canBeJumpedNow = decoratedObstacle.canBePassedThroughNow();
		
		if (!canBeJumpedNow) {
			return new Grab();
		}
		
		Action move = DirectionResolver.resolveJumpByDirection();
		return move;
		
	}

}
