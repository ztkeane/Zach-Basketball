package Model;

public enum Position {
	PG, //Point Guard
	SG, //Shooting Guard
	SF, //Small Forward
	PF, //Power Forward
	C,   //Center
	COACH; //Coach
	
	/*
	 * toString
	 * Gives the ability to print the enums.
	 * 
	 * Parameters: None
	 * Returns: None
	 */
	public String toString() {
		String str = "";
		switch(this) {
			case PG: return "PG";
			case SG: return "SG";
			case SF: return "SF";
			case PF: return "PF";
			case C: return "C";
			case COACH: return "COACH";
		}
		return str;
	}
}
