package ecologysim;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public interface IAnimalDB {
	void addAnimal(IAnimalSpecies species, int infant, int youth, int adult, int old);
	
	IAnimal popRandom(IAnimalSpecies species);
	IAnimal[] getUniqueRandom(IAnimalSpecies species, int count);
	List<IAnimal> getAllFemales(IAnimalSpecies species);
	Map<IAnimalSpecies, ArrayList<IAnimal>> getMap();
}
