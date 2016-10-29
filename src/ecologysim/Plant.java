package ecologysim;

public class Plant implements IPlant {
	
	private double[] produceMass;
	private final int multiplier;
	private final IPlantSpecies species;
	
	public Plant(IPlantSpecies species, double[] produceMass, int multiplier) {
		this.species = species;
		this.produceMass = new double[produceMass.length];
		for(int i = 0; i < produceMass.length; i ++) {
			this.produceMass[i] = produceMass[i] * multiplier;
		}
		this.multiplier = multiplier;
	}

	@Override
	public double[] getProduceMass() {
		return produceMass;
	}

	@Override
	public int getMultiplier() {
		return multiplier;
	}

	@Override
	public void grow(Season season) {
		double[] growths = species.getGrowthRate(season);
		double[] max = species.getMaxProduce(season);
		for(int i = 0; i < produceMass.length; i ++) {
			produceMass[i] = Math.min(max[i], produceMass[i] + growths[i]);
		}
	}

}
