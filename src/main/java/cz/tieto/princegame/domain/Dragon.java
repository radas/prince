package cz.tieto.princegame.domain;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class Dragon {
	
	public static final String DRAGON_NAME = "dragon";
	
	public static boolean isDragon(Obstacle obstacle) {
		
		if (obstacle == null) {
			
			return false;
			
		}
		
		String name = obstacle.getName();
		
		if (name == null) {
			
			return false;
			
		}
		
		return DRAGON_NAME.equalsIgnoreCase(name);
		
	}
	
	public static boolean isDragonDead(Obstacle obstacle) {

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
