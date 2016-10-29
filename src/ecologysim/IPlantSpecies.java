package ecologysim;

public interface IPlantSpecies extends ISpecies {
	String getName();
	
	double[] growthRate(double rainfall, double temp, Season season);
	
	int[] getMaxProduce(Season season);
	String[] getProduce(Season season);
}
