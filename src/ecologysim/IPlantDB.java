package ecologysim;

public interface IPlantDB {
	void addPlant(IPlantSpecies species, double[] produceMasses, int multiplier);
	void addPlant(IPlantSpecies species, int count, double[] produceMasses, int multiplier);
}
