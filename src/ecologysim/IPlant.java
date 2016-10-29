package ecologysim;

public interface IPlant {
	double[] getProduceMass();
	int getMultiplier();
	
	void grow(Season season);
}
