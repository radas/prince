package cz.tieto.princegame.domain;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class Chopper {
	
	public static String CHOPPER_NAME = "chopper";
	
	public static boolean isChooper(Obstacle obstacle) {
		
		if (obstacle == null) {
			
			return false;
			
		}
		
		String name = obstacle.getName();
		
		if (name == null) {
			
			return false;
			
		}
		
		return CHOPPER_NAME.equalsIgnoreCase(obstacle.getName());
		
	}

	public static boolean isMovable(Obstacle obstacle) {
		String isClosing = obstacle.getProperty("closing");
		String isOpening = obstacle.getProperty("opening");
		
		if ("true".equals(isOpening) && "false".equals(isClosing)) {
			return true;
		}
		return false;
	}

}
