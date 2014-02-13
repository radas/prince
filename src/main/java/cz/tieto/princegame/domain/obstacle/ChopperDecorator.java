package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class ChopperDecorator extends ObstacleDecorator {
	
	public static final String CHOPPER = "chopper";
	
	public static final String OPENING = "opening";
	
	public static final String CLOSING = "closing";
	
	public ChopperDecorator(Obstacle obstacle) {
		
		super(obstacle);
		
	}

	@Override
	public boolean isPassableThrough() {
		
		return true;
		
	}

	@Override
	public boolean canBePassedThroughNow() {
		
		String isClosing = getObstacle().getProperty(CLOSING);
		String isOpening = getObstacle().getProperty(OPENING);
		
		if ("true".equals(isOpening) && "false".equals(isClosing)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String getPassThroughAction() {
		
		return "JUMP";
		
	}
	
	@Override
	public boolean isKillable() {
		
		return false;
		
	}

	@Override
	public boolean isDead() {
		throw new UnsupportedOperationException("Can not be applied on Chopper");
	}

	@Override
	public int getWoundOnContact() {
		throw new UnsupportedOperationException("Can not be applied on Chopper");
	}

	@Override
	public boolean canBeJumpedOver() {
		return true;
	}

}
