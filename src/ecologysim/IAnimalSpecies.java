package ecologysim;

public interface IAnimalSpecies extends ISpecies {
	String getName();
	AnimalType getAnimalType();
	
	double getPregnancyChance();
	int getGestationPeriod();
	int getMaxPregnancies();
	
	int[] getOffspringCountRange();
	double[] getOffspringCountLiklihood();
	int[] getMatingSeason();
	double getInfantSurvivateRate();
	
	int getYouthAge();
	int getAdultAge();
	int getOldAge();
	int getMaxAge();
	
	double getEdibleMass(int age);
	
	double getFoodRequired(int age, Season season);
	
	String[] getFoodSources();
}
