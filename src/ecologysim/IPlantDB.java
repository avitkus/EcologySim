package ecologysim;

public interface IPlantDB {
	void addPlant(IPlantSpecies species, int[] produceMasses, int multiplier);
	void addPlant(IPlantSpecies species, int count, int[] produceMasses, int multiplier);
}
