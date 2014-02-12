package cz.tieto.princegame.domain;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class Knight {
	
	public static final String KNIGHT_NAME = "knight";
	
	public static boolean isKnight(Obstacle obstacle) {
		
		if (obstacle == null) {
			
			return false;
			
		}
		
		String name = obstacle.getName();
		
		if (name == null) {
			
			return false;
			
		}
		
		return KNIGHT_NAME.equalsIgnoreCase(name);
		
	}
	
	public static boolean isKnightDead(Obstacle obstacle) {

		if (obstacle == null) {
			return true;
		}
		
		String status = obstacle.getProperty("dead");
		
		if (status == null) {
			
			return false;
			
		}
		
		return "true".equals(status);
		
	}

}
