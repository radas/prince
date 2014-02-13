package cz.tieto.princegame.domain.prince;

public class PrinceInstance {
	
	private static PrinceDTO prince;
	
	private PrinceInstance() {
		
	}

	public static PrinceDTO getPrince() {
		return prince;
	}

	public static void setPrince(PrinceDTO prince) {
		PrinceInstance.prince = prince;
	}

}
