package microwaveOven.service;

import microwaveOven.util.Results;

public class MicrowaveContext {

	MicrowaveStateI timeOfDay;
	MicrowaveStateI cooking;
	MicrowaveStateI paused;
	MicrowaveStateI setTime;
	String minS;
	String secS;
	String minC;
	String secC;
	Results result;
	MicrowaveStateI state;

	public MicrowaveContext(Results res) {
		timeOfDay = new TimeOfDay(this);
		cooking = new Cooking(this);
		paused = new Paused(this);
		setTime = new SetClockTimeImpl(this);

		state = timeOfDay;
		result = res;
	}

	public void start() {
		state.start(result);
	}

	public void stop() {
		state.stop(result);
	}

	public void setClock() {
		state.setClock(result);
	}

	void setState(MicrowaveStateI state) {
		this.state = state;
	}

	public MicrowaveStateI getTimeOfDay() {
		return this.state;
	}

	public MicrowaveStateI getCooking() {
		return this.state;
	}

	public MicrowaveStateI getPaused() {
		return this.state;
	}

	public MicrowaveStateI getSetTime() {
		return this.state;
	}

	public void setTime(String m, String s) {
		// TODO Auto-generated method stub
		minS = m;
		secS = s;
	}

	public void cookTime(String m, String s) {
		// TODO Auto-generated method stub
		minC = m;
		secC = s;
	}
}
