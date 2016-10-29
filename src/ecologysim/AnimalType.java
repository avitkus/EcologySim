package ecologysim;

public enum AnimalType {
	CARNIVORE, HERBIVORE, OMNIVORE;
	
	public static AnimalType parseString(String str) {
		if (str.equalsIgnoreCase("carnivore")) {
			return CARNIVORE;
		} else if (str.equalsIgnoreCase("herbivore")) {
			return HERBIVORE;
		} else {
			return OMNIVORE;
		}
	}
}
