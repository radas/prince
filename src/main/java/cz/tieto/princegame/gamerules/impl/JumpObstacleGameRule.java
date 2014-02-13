package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.obstacle.ObstacleDecorator;
import cz.tieto.princegame.domain.obstacle.ObstacleDecoratorFactory;
import cz.tieto.princegame.gamerules.GameRule;

public class JumpObstacleGameRule implements GameRule {

	@Override
	public Action generateAction(Prince prince) {
		
		int lookByDirection = DirectionResolver.resolveLookByDirection();
		
		Field lookField = prince.look(lookByDirection);
		
		if (lookField == null) {
			
			return null;
			
		}
		
		Obstacle obstacle = lookField.getObstacle();
		
		if (obstacle == null) {
			return null;
		}
		
		ObstacleDecorator decoratedObstacle = ObstacleDecoratorFactory.resolveObstacle(obstacle);
		
		boolean canBeJumpedOver = decoratedObstacle.canBeJumpedOver();
		
		if (!canBeJumpedOver) {
			
			return null;
			
		}
		
		boolean canBeJumpedOverNow = decoratedObstacle.canBePassedThroughNow();
		
		// if obstacle can not be jumped over now, then wait and heal
		if (!canBeJumpedOverNow) {
			
			return new Heal();
			
		}
		
		Action jump = DirectionResolver.resolveJumpByDirection();
		
		return jump;
		
	}

}
