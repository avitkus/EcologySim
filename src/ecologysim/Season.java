package ecologysim;

public enum Season {
	SPRING, SUMMER, FALL, WINTER;
	
	static public int toInt(Season season) {
		switch(season) {
			case SPRING:
				return 0;
			case SUMMER:
				return 1;
			case FALL:
				return 2;
			default:
				return 3;
		}
	}
}
