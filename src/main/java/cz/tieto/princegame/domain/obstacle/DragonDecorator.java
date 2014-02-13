package cz.tieto.princegame.domain.obstacle;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class DragonDecorator extends ObstacleDecorator {
	
	public static final String DRAGON = "dragon";
	
	public static final int WOUND_ON_CONTACT = 3;
	
	public DragonDecorator(Obstacle obstacle) {
		
		super(obstacle);
		
	}

	@Override
	public boolean isPassableThrough() {
		
		return false;
		
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
