package ecologysim;

public interface IAnimalDB {
	void addAnimal(IAnimalSpecies species, int infant, int youth, int adult, int old);
	
	IAnimal getRandom(IAnimalSpecies species);
	IAnimal[] getUniqueRandom(IAnimalSpecies species, int count);
}
