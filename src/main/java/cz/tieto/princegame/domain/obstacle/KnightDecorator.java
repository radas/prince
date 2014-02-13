package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class KnightDecorator extends ObstacleDecorator {
	
	public static final String KNIGHT = "knight";
	
	public static final int WOUND_ON_CONTACT = 1;
	
	public KnightDecorator(Obstacle obstacle) {
		
		super(obstacle);
		
	}

	@Override
	public boolean isPassableThrough() {
		
		return true;
		
	}

	@Override
	public boolean canBePassedThroughNow() {
		
		return false;
	}
	
	@Override
	public String getPassThroughAction() {
		
		return "JUMP";
		
	}
	
	@Override
	public boolean isKillable() {
		
		return true;
		
	}

	@Override
	public boolean isDead() {
		
		String dead = getObstacle().getProperty("dead");
		
		if (dead == null) {
			
			return false;
			
		}
		
		return "true".equals(dead);
		
	}
	
	@Override
	public boolean canBeJumpedOver() {
		return false;
	}

	@Override
	public int getWoundOnContact() {
		return WOUND_ON_CONTACT;
	}

}
