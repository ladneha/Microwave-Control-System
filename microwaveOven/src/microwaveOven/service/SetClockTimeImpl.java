package microwaveOven.service;

import microwaveOven.util.Results;

public class SetClockTimeImpl implements MicrowaveStateI {

	MicrowaveContext context;

	public SetClockTimeImpl(MicrowaveContext context) {
		this.context = context;
	}

	@Override
	public void start(Results result) {
		// TODO Auto-generated method stub
		// display time of the day and go to time of the day state
		// System.out.println("Transition : Setting Time -> Idle");
		result.storeNewResults("Transition : Setting Time -> Idle");
		context.setState(context.timeOfDay);

		// System.out.println("Display Time : "+ context.minS +":"+
		// context.secS);
		result.storeNewResults("Display Time : " + context.minS + ":"
				+ context.secS);
	}

	@Override
	public void stop(Results result) {
		// TODO Auto-generated method stub
		// do nothing
		// System.out.println("Transition : Setting Time -> Idle");
		result.storeNewResults("Transition : Setting Time -> Idle");
		context.setState(context.timeOfDay);
		// System.out.println("Display Time : "+ context.minS +":"+
		// context.secS);
		result.storeNewResults("Display Time : " + context.minS + ":"
				+ context.secS);

	}

	@Override
	public void setClock(Results result) {
		// TODO Auto-generated method stub

	}

}
