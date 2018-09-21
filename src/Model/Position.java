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
			case PG: str += "PG";
			case SG: str += "SG";
			case SF: str += "SF";
			case PF: str += "PF";
			case C: str += "C";
			case COACH: str += "COACH";
		}
		return str;
	}
}
