package cz.tieto.princegame.gamerules.impl;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Grab;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.gamerules.GameRule;

public class GrabEquipmentGameRule implements GameRule {
	
	@Override
	public Action generateAction(Prince prince) {
		
		Field actual = prince.look(0);
		
		boolean isEquipmentOnActual = isEquipmentOnActual(actual);
		
		if (!isEquipmentOnActual) {
			
			 return null;
			 
		}
		
		Action grab = new Grab();
		
		return grab;
		
	}
	
	private boolean isEquipmentOnActual(Field actual) {
		
		final Equipment e = actual.getEquipment();
		
		if (e != null) {
			
			return true;
			
		}
		
		return false;
		
	}

}
