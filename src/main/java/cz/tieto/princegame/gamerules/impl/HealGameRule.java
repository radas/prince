package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.Health;
import cz.tieto.princegame.domain.Knight;
import cz.tieto.princegame.gamerules.GameRule;

public class HealGameRule implements GameRule {
	
	@Override
	public Action generateAction(Prince prince) {
		
		if ((Health.getActualHeath() - prince.getHealth()) >= 1) {
			
			return null;
			
		}
		
		// if there is no need for healing, return null;
		if (prince.getHealth() >= Health.MAX_HEALTH) {
			
			return null;
			
		}
		
		int lookByDirection = DirectionResolver.resolveLookByDirection();
		
		Field lookField = prince.look(lookByDirection);
		
		Obstacle obstacle = lookField.getObstacle();
		
		boolean isKnight = Knight.isKnight(obstacle);
		
		if (isKnight) {
			
			boolean isDead = Knight.isKnightDead(obstacle);
			
			if (isDead) {
				
				// obstacle is knight, but it is dead, so we can heal on this position
				Health.setActualHeath(prince.getHealth());
				return new Heal();
				
			} else {
				
				// if obstacle is knight that is not dead, we can not heal on this position,
				// return null action now, then action resolution will go to
				// default action that is move back
				return null;
				
			}
			
		}
		
		Health.setActualHeath(prince.getHealth());
		
		return new Heal();
		
	}

}
