package cz.tieto.princegame.domain.weapon;

import java.util.Collection;

import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Prince;

public class Sword {
	
	public static final String SWORD_NAME = "sword";
	
	public static boolean isSword(Equipment equipment) {
		
		if (equipment == null) {
			
			return false;
			
		}
		
		if (equipment.getName().equals(SWORD_NAME)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static Equipment obtainSword(Prince prince) {
		
		Collection<Equipment> col = prince.getInventory();
		
		for (Equipment e : col) {
			
			if (isSword(e)) {
				
				return e;
				
			}
			
		}
		
		return null;
		
	}
	
	public static boolean hasSword(Prince prince) {
		
		Collection<Equipment> equipments = prince.getInventory();
		
		for (Equipment e: equipments) {
			
			boolean isSword = Sword.isSword(e);
			
			if (isSword) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

}
