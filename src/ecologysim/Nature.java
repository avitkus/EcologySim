package ecologysim;

import java.util.List;
import java.util.Set;

public class Nature implements INature{
	
	private IAnimalDB animals;
	private IPlantDB plants;
	private int week;
	private int year;
	
	public Nature(IAnimalDB animals, IPlantDB plants) {
		this.animals = animals;
		this.plants = plants;
		
		this.week = 0;
	}

	@Override
	public void age() {
		animals.getMap().forEach((species, animals) -> animals.removeIf(animal -> animal.age() > species.getMaxAge()));
		plants.getMap().forEach((species, plants) -> plants.forEach(plant -> plant.grow(getSeason())));
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reproduce() {
		Set<IAnimalSpecies> speciesSet = animals.getMap().keySet();
		IAnimalSpecies[] speciesList = speciesSet.toArray(new IAnimalSpecies[speciesSet.size()]);
		for (int i = 0; i < speciesList.length; i++) {
			List<IAnimal> females = animals.getAllFemales(speciesList[i]);
			
			int[] season = speciesList[i].getMatingSeason();
			if (week%52 >= season[0] && week%52 <= season[1]) {
				for (int j = 0; j < females.size(); j++) {
					if (!females.get(j).isPregnant()) {
						//fix pregnancy rate
						if (Math.random() > 0.5 && 
								females.get(j).getAge() < speciesList[i].getOldAge() &&
								females.get(j).getAge() >= speciesList[i].getAdultAge()) {//make counts
							females.get(j).setIsPregnant(true);
							females.get(j).setLastPregnancy(week);
						} else if (females.get(j).isPregnant() && 
								females.get(j).getLastPregnancy()+speciesList[i].getGestationPeriod() == week) {
							//Fix Probabilities
							animals.addAnimal(speciesList[i], 2, 0, 0, 0);
						}
					}
				}
			} else {
				for (int j = 0; j < females.size(); j++) {
					if (females.get(j).isPregnant() && 
							females.get(j).getLastPregnancy()+speciesList[i].getGestationPeriod() == week) {
						//Fix Probabilities
						animals.addAnimal(speciesList[i], 2, 0, 0, 0);
					}
				}
			}
		}
		
	}

	@Override
	public int getWeekRaw() {
		return week;
	}

	@Override
	public int getWeekofYear() {
		return week%52;
	}

	@Override
	public int getYear() {
		year = (int) Math.floor(week/52);
		return year;
	}

	@Override
	public Season getSeason() {
		int currentweek = (week%52)/13;
		return Season.fromInt(currentweek);
	}

	@Override
	public INatureData getState() {
		return null;
	}

}
