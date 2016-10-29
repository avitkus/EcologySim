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
	
	static public Season fromInt(int i) {
		switch(i) {
			case 0:
				return SPRING;
			case 1:
				return SUMMER;
			case 2:
				return FALL;
			default:
				return WINTER;
		}
	}
}
