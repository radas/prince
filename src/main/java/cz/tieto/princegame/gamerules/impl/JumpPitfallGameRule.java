package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.DirectionResolver;
import cz.tieto.princegame.domain.Pitfall;
import cz.tieto.princegame.gamerules.GameRule;

public class JumpPitfallGameRule implements GameRule {

	@Override
	public Action generateAction(Prince prince) {
		
		int lookByDirection = DirectionResolver.resolveLookByDirection();
		
		Field lookField = prince.look(lookByDirection);
		
		if (lookField == null) {
			
			return null;
			
		}
		
		Obstacle obstacle = lookField.getObstacle();
		
		boolean isPitfall = Pitfall.isPitfall(obstacle);
		
		if (isPitfall) {

			Action jumpPitfall = DirectionResolver.resolveJumpByDirection();
			return jumpPitfall;
			
		}
		
		return null;
		
	}

}
