package ecologysim;

public interface IAnimal {
	int getAge();
	int age();
	int getStarvation();
	boolean isFemale();
	boolean isPregnant();
	void setIsPregnant(boolean isPregnant);
	int getLastPregnancy();
	void setLastPregnancy(int lastPreganancy);
	int getNumberOfPregnancies();
	void setNumberOfPregnancies(int number);
}
