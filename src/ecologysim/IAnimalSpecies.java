package ecologysim;

public interface IAnimalSpecies extends ISpecies {
	String getName();
	AnimalType getAnimalType();
	
	int getPregnancyChance();
	int getGestationPeriod();
	int getMaxPregnancies();
	
	int[] getOffspringCountRange();
	int[] getOffspringCountWeights();
	int[] getMatingSeason();
	double getInfantSurvivateRate();
	
	int getYouthAge();
	int getAdultAge();
	int getOldAge();
	int getMaxAge();
	
	int getEdibleMass(int age);
	
	int getFoodRequired(int age, Season season);
	
	String[] getFoodSources();
}
