package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.EnterGate;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.gamerules.GameRule;

public class EnterGateGameRule implements GameRule {

	@Override
	public Action generateAction(Prince prince) {
		
		Field actual = prince.look(0);
		
		final boolean isGate = actual.isGate();
		
		if (isGate) {
			
			Action enterGate = new EnterGate();
			return enterGate;
			
		}
		
		return null;
		
	}

}
