package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Grab;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.Sword;
import cz.tieto.princegame.gamerules.GameRule;

public class GrabSwordGameRule implements GameRule {

	@Override
	public Action generateAction(Prince prince) {
		
		Field actual = prince.look(0);
		
		boolean isSwordOnActual = isSwordOnActual(actual);
		
		if (isSwordOnActual) {
			 Action grab = new Grab();
			 return grab;
		}
		
		return null;
		
	}
	
	private boolean isSwordOnActual(Field actual) {
		
		final Equipment e = actual.getEquipment();
				
		boolean isSwordOnActual = Sword.isSword(e);
		
		return isSwordOnActual;
		
	}

}
