package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class ObstacleDecoratorFactory {

	public static ObstacleDecorator resolveObstacle(Obstacle obstacle) {
		
		String name = obstacle.getName();
		
		if (name ==  null) {
			throw new IllegalArgumentException("Obstacle name can not be null");
		}
		
		if (ChopperDecorator.CHOPPER.equals(name)) {
			return new ChopperDecorator(obstacle);
		}
		
		if (DragonDecorator.DRAGON.equals(name)) {
			return new DragonDecorator(obstacle);
		}
		
		if (KnightDecorator.KNIGHT.equals(name)) {
			return new KnightDecorator(obstacle);
		}
		
		if (PitfallDecorator.PITFALL.equals(name)) {
			return new PitfallDecorator(obstacle);
		}
		
		throw new IllegalArgumentException("Unknown obstacle: " + name);
		
	}

}
