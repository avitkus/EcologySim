package ecologysim;

public interface IAnimal {
	int getAge();
	int getStarvation();
	boolean isFemale();
	boolean isPregnant();
	int getLastPregnancy();
	int setLastPregnancy();
}
