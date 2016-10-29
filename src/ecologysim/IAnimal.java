package ecologysim;

public interface IAnimal {
	int getAge();
	int getStarvation();
	boolean isFemale();
	boolean isPregnant();
	void setIsPregnant(boolean isPregnant);
	int getLastPregnancy();
	void setLastPregnancy(int lastPreganancy);
}
