package ecologysim;

public class PlantSpecies implements IPlantSpecies {

	private String name;
	private String[][] produces;
	private double[][] growthRates;
	private double[][] maxProduce;
	
	
	@Override
	public Kingdom getKingdom() {
		return Kingdom.PLANT;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double[] getGrowthRate(Season season) {
		return growthRates[Season.toInt(season)];
	}

	@Override
	public double[] getMaxProduce(Season season) {
		return maxProduce[Season.toInt(season)];
	}

	@Override
	public String[] getProduce(Season season) {
		return produces[Season.toInt(season)];
	}

}
