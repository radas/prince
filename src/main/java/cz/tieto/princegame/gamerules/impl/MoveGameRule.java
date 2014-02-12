package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.Chopper;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.Dragon;
import cz.tieto.princegame.domain.Knight;
import cz.tieto.princegame.domain.Pitfall;
import cz.tieto.princegame.domain.Sword;
import cz.tieto.princegame.gamerules.GameRule;

public class MoveGameRule implements GameRule {

	@Override
	public Action generateAction(Prince prince) {
		
		int lookByDirection = DirectionResolver.resolveLookByDirection();
		
		Field lookField = prince.look(lookByDirection);
		
		if (lookField == null) {
			
			DirectionResolver.changePrinceDirection();
			Action action = getAction(prince);
			return action;
			
		}
		
		Obstacle obstacle = lookField.getObstacle();
		
		// if there is any obstacle, we can only move through dead knight
		if (obstacle != null) {
			
			boolean isKnightDead = isKnightDead(obstacle);
			
			if (isKnightDead) {
				
				// if knight is dead, we can move in this direction
				Action move = DirectionResolver.resolveMoveByDirection();
				return move;
				
			}
			
			boolean isDragonDead = isDragonDead(obstacle);
			
			if (isDragonDead) {
				
				// if dragon is dead, we can move in this direction
				Action move = DirectionResolver.resolveMoveByDirection();
				return move;
				
			}
			
			boolean isUnknownObstacle = isUnknownObstacle(obstacle);
			
			if (isUnknownObstacle) {
				Action action = getAction(prince);
				return action;
			}
			
			DirectionResolver.changePrinceDirection();
			
		}
		
		Action action = getAction(prince);
		return action;
		
	}
	
	private boolean isUnknownObstacle(Obstacle obstacle) {
		
		boolean isDragon = Dragon.isDragon(obstacle);
		boolean isKnight = Knight.isKnight(obstacle);
		boolean isChopper = Chopper.isChooper(obstacle);
		boolean isPitfall = Pitfall.isPitfall(obstacle);
		
		if (isDragon) {
			return false;
		}
		
		if (isKnight) {
			return false;
		}
		
		if (isChopper) {
			return false;
		}
		
		if (isPitfall) {
			return false;
		}
		
		return true;
	}

	private boolean isKnightDead(Obstacle obstacle) {
		
		boolean isKnight = Knight.isKnight(obstacle);
		
		if (!isKnight) {
			
			return false;
			
		}
		
		boolean isKnightDead = Knight.isKnightDead(obstacle);
		
		if (isKnightDead) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	private boolean isDragonDead(Obstacle obstacle) {
		
		boolean isDragon = Dragon.isDragon(obstacle);
		
		if (!isDragon) {
			
			return false;
			
		}
		
		boolean isDragonDead = Dragon.isDragonDead(obstacle);
		
		if (isDragonDead) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	private Action getAction(Prince prince) {
		
		int actualLook = DirectionResolver.resolveLookByDirection();
		
		Field actualLookField = prince.look(actualLook);
		
		Obstacle actualObstacle = actualLookField.getObstacle();
		
		boolean isPitfall = Pitfall.isPitfall(actualObstacle);
		
		boolean isChopper = Chopper.isChooper(actualObstacle);
		
		if (isPitfall) {
			
			Action move = DirectionResolver.resolveJumpByDirection();
			return move;
			
		} else if (isChopper) {
			
			if (Chopper.isMovable(actualObstacle)) {
				
				Action move = DirectionResolver.resolveJumpByDirection();
				return move;
				
			} else {
				return new Heal();
			}
			
			
		} else {
		
			Action move = DirectionResolver.resolveMoveByDirection();
			return move;
		
		}
		
	}

}
