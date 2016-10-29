package ecologysim;

import java.util.Arrays;

public class PlantSpecies implements IPlantSpecies {

	private String name;
	private String[] produces;
	private double[][] growthRates;
	private double[][] maxProduce;	
	
	public PlantSpecies(String name, String[] produces, double[][] growthRates, double[][] maxProduce) {
		super();
		this.name = name;
		this.produces = Arrays.copyOf(produces, produces.length);
		this.growthRates = new double[growthRates.length][growthRates[0].length];
		for(int i = 0; i < growthRates.length; i ++) {
			this.growthRates[i] = Arrays.copyOf(growthRates[i], growthRates[0].length);
		}
		this.maxProduce = new double[maxProduce.length][maxProduce[0].length];
		for(int i = 0; i < maxProduce.length; i ++) {
			this.maxProduce[i] = Arrays.copyOf(maxProduce[i], maxProduce[0].length);
		}
	}

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
	public String[] getProduces() {
		return produces;
	}

}
