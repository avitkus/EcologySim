package ecologysim;

public interface INature {
	void age();
	void eat();
	void reproduce();
	
	int getWeekRaw();
	int getWeekofYear();
	int getYear();
	
	Season getSeason();
	
	INatureData getState();
}
