package cz.tieto.princegame.domain;

public class Health {
	
	public static final int MAX_HEALTH = 6;
	
	private static int actualHeath = 10;

	public static int getActualHeath() {
		return actualHeath;
	}

	public static void setActualHeath(int actualHeath) {
		Health.actualHeath = actualHeath;
	}

}
