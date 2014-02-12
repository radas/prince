package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Use;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.Knight;
import cz.tieto.princegame.domain.Sword;
import cz.tieto.princegame.gamerules.GameRule;

public class KillKnightGameRule implements GameRule {

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
		
		boolean isKnight = Knight.isKnight(obstacle);
		
		if (!isKnight) {
			return null;
		}
		
		boolean hasSword = Sword.hasSword(prince);
		
		if (!hasSword) {
			return null;
		}
		
		boolean isKnightDead = Knight.isKnightDead(obstacle);
		
		if (isKnightDead) {
			
			return null;
			
		}
		
		Equipment sword = Sword.obtainSword(prince);
		
		if (sword == null) {
			
			return null;
			
		}
		
		Action kill = new Use(sword, obstacle);
		
		return kill;
		
	}

}
