package ecologysim;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlantDB implements IPlantDB {
	private HashMap<IPlantSpecies, ArrayList<IPlant>> map;
	
	@Override
	public void addPlant(IPlantSpecies species, double[] produceMasses, int multiplier) {
		if(!map.containsKey(species)) {
			map.put(species, new ArrayList<>());
		}
		map.get(species).add(new Plant(species, produceMasses, multiplier));
	}

	@Override
	public void addPlant(IPlantSpecies species, int count, double[] produceMasses, int multiplier) {
		if(!map.containsKey(species)) {
			map.put(species, new ArrayList<>());
		}
		ArrayList<IPlant> curSpecies = map.get(species);
		for(int i = 0; i < count; i ++) {
			curSpecies.add(new Plant(species, produceMasses, multiplier));
		}
	}

	@Override
	public Map<IPlantSpecies, ArrayList<IPlant>> getMap() {
		return map;
	}

}
