package ecologysim;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpeciesFileReader {
	static List<IAnimalSpecies> processAnimals(Path file) {
		ArrayList<IAnimalSpecies> species = new ArrayList<>();
		try {
			Files.lines(file).filter(line -> !line.isEmpty()).forEach(line -> {
				String[] parts = line.split(",");
				String name = parts[0].trim();
				//name, gestPeriod, maxPreg, minChild, maxChild, minChild, maxProp, minProb,
				//matingStart, matingEnd, infantSurvivalRate, youth, adult, old, max,
				//infantWeight, audltWeight, youthFood, adultFood, oldFood, sources
				int gestationPeriod = Integer.parseInt(parts[1].trim());
				int maxPreg = Integer.parseInt(parts[2].trim());
				int minOffspringCount = Integer.parseInt(parts[3].trim());
				int maxOffspringCount = Integer.parseInt(parts[4].trim());
				double minOffspringProb = Double.parseDouble(parts[5].trim());
				double maxOffspringProb = Double.parseDouble(parts[6].trim());
				int matingStart = Integer.parseInt(parts[7].trim());
				int matingEnd = Integer.parseInt(parts[8].trim());
				double infantSurvivalRate = Double.parseDouble(parts[9].trim());
				int youngAge = Integer.parseInt(parts[10].trim());
				int adultAge = Integer.parseInt(parts[11].trim());
				int oldAge = Integer.parseInt(parts[12].trim());
				int maxAge = Integer.parseInt(parts[13].trim());
				double infantWeight = Double.parseDouble(parts[14].trim());
				double adultWeight = Double.parseDouble(parts[15].trim());
				double youngFood = Double.parseDouble(parts[16].trim());
				double adultFood = Double.parseDouble(parts[17].trim());
				double oldFood = Double.parseDouble(parts[18].trim());
				String[] foodSources = new String[parts.length - 18];
				int sourceNum = 0;
				for(int i = 19; i < parts.length; i++) {
					foodSources[sourceNum] = parts[i].trim();
				}
//				species.add(new AnimalSpecies(name, gestationPeriod, maxPreg, minOffspringCount, maxOffspringCount,
//						minOffspringProb, maxOffspringProb, matingStart, matingEnd, infantSurvivalRate,
//						youngAge, adultAge, oldAge, maxAge, infantWeight, adultWeight, ));
			});
		} catch (IOException e) {
		}
		return species;
	}

	static List<IPlantSpecies> processPlants(Path file) {
		ArrayList<IPlantSpecies> species = new ArrayList<>();
		try {
			Files.lines(file).filter(line -> !line.isEmpty()).forEach(line -> {
				String[] parts = line.split(",");
				String name = parts[0].trim();
				String[] produceNames = new String[(parts.length - 1) / 9];
				double[][] growthRates = new double[(parts.length - 1) / 9][4];
				double[][] maxProduce = new double[(parts.length - 1) / 9][4];
				int curProduce = 0;
				for (int i = 1; i < parts.length; i++) {
					produceNames[curProduce] = parts[i].trim();
					for (int j = 0; j < 4; j++) {
						growthRates[curProduce][j] = Double.parseDouble(parts[i + 1].trim());
						maxProduce[curProduce][j] = Double.parseDouble(parts[i + 2].trim());
						i += 2;
					}
				}
				species.add(new PlantSpecies(name, produceNames, growthRates, maxProduce));
			});
		} catch (IOException e) {
		}
		return species;
	}
}
