package ecologysim;

public interface IPlantSpecies extends ISpecies {
	String getName();
	
	double[] getGrowthRate(Season season);
	
	double[] getMaxProduce(Season season);
	String[] getProduce(Season season);
}
