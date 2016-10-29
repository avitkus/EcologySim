package ecologysim;

import java.util.ArrayList;
import java.util.Map;

public interface IPlantDB {
	void addPlant(IPlantSpecies species, double[] produceMasses, int multiplier);
	void addPlant(IPlantSpecies species, int count, double[] produceMasses, int multiplier);
	Map<IPlantSpecies, ArrayList<IPlant>> getMap();
}
