package ecologysim;

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
		animals.getMap().entrySet()
			.forEach(entry -> entry.getValue().removeIf(animal -> animal.age() > entry.getKey().getMaxAge()));
		
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reproduce() {
		// TODO Auto-generated method stub
		
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
