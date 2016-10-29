package ecologysim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class AnimalDB implements IAnimalDB{
private HashMap<IAnimalSpecies, ArrayList<IAnimal>> map;
	
	@Override
	public void addAnimal(IAnimalSpecies species, int infant, int youth, int adult, int old) {
		boolean isFemale;
		if(!map.containsKey(species)) {
			map.put(species, new ArrayList<>());
		}
		
		Random rand = new Random();
		
		for (int i = 0; i < infant; i++) {
			if (Math.random() < 0.5) {
				isFemale = true;
			} else {
				isFemale = false;
			}
			int age = rand.nextInt(species.getYouthAge());
			map.get(species).add(new Animal(age, isFemale));
		}
		
		for (int i = 0; i < youth; i++) {
			if (Math.random() < 0.5) {
				isFemale = true;
			} else {
				isFemale = false;
			}
			int age = rand.nextInt((species.getAdultAge() - species.getYouthAge())) + species.getYouthAge();
			map.get(species).add(new Animal(age, isFemale));
		}
		
		for (int i = 0; i < adult; i++) {
			if (Math.random() < 0.5) {
				isFemale = true;
			} else {
				isFemale = false;
			}
			int age = rand.nextInt((species.getOldAge() - species.getAdultAge())) + species.getAdultAge();
			map.get(species).add(new Animal(age, isFemale));
		}
		
		for (int i = 0; i < youth; i++) {
			if (Math.random() < 0.5) {
				isFemale = true;
			} else {
				isFemale = false;
			}
			int age = rand.nextInt((species.getMaxAge() - species.getOldAge())) + species.getOldAge();
			map.get(species).add(new Animal(age, isFemale));
		}
	}

	@Override
	public IAnimal popRandom(IAnimalSpecies species) {
		ArrayList<IAnimal> animalList = map.get(species);
		Random  rand = new Random();
		int index = rand.nextInt(animalList.size());
		IAnimal animal = animalList.get(index);
		animalList.remove(index);
		return animal;
	}

	@Override
	public IAnimal[] getUniqueRandom(IAnimalSpecies species, int count) {
		ArrayList<IAnimal> animalList = map.get(species);
		IAnimal[] animals = new IAnimal[count];
		ArrayList<Integer> indicies = new ArrayList<Integer>();
		
		for (int i = 0; i < count; i++) {
			indicies.add(i);
		}
		for (int i = 0; i < count; i++) {
			Collections.shuffle(indicies);
			int index = indicies.get(0);
			indicies.remove(0);
			animals[i] = animalList.get(index);
		}
		return animals;
	}

	@Override
	public List<IAnimal> getAllFemales(IAnimalSpecies species) {
		List<IAnimal> femaleList = map.get(species).stream().
				filter(animal -> animal.isFemale()).collect(Collectors.toList());
		return femaleList;
	}
	
	public Map<IAnimalSpecies, ArrayList<IAnimal>> getMap() {
		return map;
	}
}
