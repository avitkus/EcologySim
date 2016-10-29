package ecologysim;

public class Animal implements IAnimal{
	private int age;
	private int starvation;
	private boolean isFemale;
	private boolean isPregnant;
	private int lastPregnancy;
	
	public Animal(int age, boolean isFemale) {
		this.age = age;
		this.isFemale = isFemale;
		
		starvation = 0;
		isPregnant = false;
		lastPregnancy = 0;
	}
	
	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public int age() {
		age++;
		return age;
	}

	@Override
	public int getStarvation() {
		return starvation;
	}

	@Override
	public boolean isFemale() {
		return isFemale;
	}

	@Override
	public boolean isPregnant() {
		return isPregnant;
	}

	@Override
	public void setIsPregnant(boolean isPregnant) {
		this.isPregnant = isPregnant;
	}
	
	@Override
	public int getLastPregnancy() {
		return lastPregnancy;
	}

	@Override
	public void setLastPregnancy(int lastPregnancy) {
		this.lastPregnancy = lastPregnancy;
	}


}
