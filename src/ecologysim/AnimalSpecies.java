package ecologysim;

public class AnimalSpecies implements IAnimalSpecies{
	
	private String name;
	private AnimalType animalType;
	private double pregnancyChance;
	private int gestationPeriod;
	private int maxPregnancies;
	private int[] offspringCountRange;
	private double[] offspringCountLiklihood;
	private int[] matingSeason;
	private double infantSurvivalRate;
	private int youthAge;
	private int adultAge;
	private int oldAge;
	private int maxAge;
	private double[] mass;
	private double[] foodRequired;
	private String[] foodSources;
	
	public AnimalSpecies(String name, AnimalType animalType, double pregnancyChance, int gestationPeriod, 
			int maxPregnancies, int[] offspringCountRange, double[] offspringCountLiklihood, int[] matingSeason, 
			double infantSurvivalRate, int youthAge, int adultAge, int oldAge, int maxAge, double[] mass, 
			double[] foodRequired, String[] foodSources) {
		this.name = name;
		this.animalType = animalType;
		this.pregnancyChance = pregnancyChance;
		this.gestationPeriod = gestationPeriod;
		this.maxPregnancies = maxPregnancies;
		this.offspringCountRange = offspringCountRange;
		this.offspringCountLiklihood = offspringCountLiklihood;
		this.matingSeason = matingSeason;
		this.infantSurvivalRate = infantSurvivalRate;
		this.youthAge = youthAge;
		this.adultAge = adultAge;
		this.oldAge = oldAge;
		this.maxAge = maxAge;
		this.mass = mass;
		this.foodSources = foodSources;	
	}

	@Override
	public Kingdom getKingdom() {
		return Kingdom.ANIMAL;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public AnimalType getAnimalType() {
		return animalType;
	}

	@Override
	public double getPregnancyChance() {
		return pregnancyChance;
	}

	@Override
	public int getGestationPeriod() {
		return gestationPeriod;
	}

	@Override
	public int getMaxPregnancies() {
		return maxPregnancies;
	}

	@Override
	public int[] getOffspringCountRange() {
		return offspringCountRange;
	}

	@Override
	public double[] getOffspringCountLiklihood() {
		return offspringCountLiklihood;
	}

	@Override
	public int[] getMatingSeason() {
		return matingSeason;
	}

	@Override
	public double getInfantSurvivateRate() {
		return infantSurvivalRate;
	}

	@Override
	public int getYouthAge() {
		return youthAge;
	}

	@Override
	public int getAdultAge() {
		return adultAge;
	}

	@Override
	public int getOldAge() {
		return oldAge;
	}

	@Override
	public int getMaxAge() {
		return maxAge;
	}

	@Override
	public double getEdibleMass(int age) {
		double edibleMass;
		double m = (mass[1] - mass[0])/adultAge;
		if (age < adultAge) {
			edibleMass = m*age + mass[0];
		} else {
			edibleMass = mass[1];
		}
		return edibleMass;
	}

	@Override
	public double getFoodRequired(int age, Season season) {
		double food;
		if (age < youthAge) {
			food = 0;
		} else if (age < adultAge) {
			food = foodRequired[0];
		} else if (age < oldAge) {
			food = foodRequired[1];
		} else {
			food = foodRequired[2];
		}
		return food;
	}

	@Override
	public String[] getFoodSources() {
		return foodSources;
	}

}
