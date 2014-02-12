package cz.tieto.princegame.domain;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class Pitfall {
	
	public static String PITFALL_NAME = "pitfall";
	
	public static boolean isPitfall(Obstacle obstacle) {
		
		if (obstacle == null) {
			
			return false;
			
		}
		
		String name = obstacle.getName();
		
		if (name == null) {
			
			return false;
			
		}
		
		return PITFALL_NAME.equalsIgnoreCase(obstacle.getName());
		
	}

}
