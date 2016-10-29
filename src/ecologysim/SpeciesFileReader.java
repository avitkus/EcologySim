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
				AnimalType type = AnimalType.parseString(parts[1].trim());
				double pregChance = Double.parseDouble(parts[2].trim());
				int gestationPeriod = Integer.parseInt(parts[3].trim());
				int maxPreg = Integer.parseInt(parts[4].trim());
				int[] offspringCountRange = {Integer.parseInt(parts[5].trim()), Integer.parseInt(parts[6].trim())};
				double[] offspringProbs = {Double.parseDouble(parts[7].trim()), Double.parseDouble(parts[8].trim())};
				int[] matingSeason = {Integer.parseInt(parts[9].trim()), Integer.parseInt(parts[10].trim())};
				double infantSurvivalRate = Double.parseDouble(parts[11].trim());
				int youngAge = Integer.parseInt(parts[12].trim());
				int adultAge = Integer.parseInt(parts[13].trim());
				int oldAge = Integer.parseInt(parts[14].trim());
				int maxAge = Integer.parseInt(parts[15].trim());
				double[] mass = {Double.parseDouble(parts[16].trim()), Double.parseDouble(parts[17].trim())};
				double[] food = {Double.parseDouble(parts[18].trim()), Double.parseDouble(parts[19].trim()), Double.parseDouble(parts[20].trim())};
				String[] foodSources = new String[parts.length - 20];
				int sourceNum = 0;
				for(int i = 21; i < parts.length; i++) {
					foodSources[sourceNum] = parts[i].trim();
				}
				species.add(new AnimalSpecies(name, type, pregChance, gestationPeriod, maxPreg, offspringCountRange,
						offspringProbs, matingSeason, infantSurvivalRate,
						youngAge, adultAge, oldAge, maxAge, mass, food, foodSources));
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
