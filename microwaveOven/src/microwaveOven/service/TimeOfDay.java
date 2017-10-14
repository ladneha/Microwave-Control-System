package microwaveOven.service;

import microwaveOven.util.Results;

public class TimeOfDay implements MicrowaveStateI {

	MicrowaveContext context;

	public TimeOfDay(MicrowaveContext context) {
		this.context = context;
	}

	@Override
	public void start(Results result) {
		// TODO Auto-generated method stub
		// System.out.println("Transition : Idle -> Cooking");
		result.storeNewResults("Transition : Idle -> Cooking");
		context.setState(context.cooking);
		// System.out.println("Cooking started for "+ context.minC + ":"+
		// context.secC);
		result.storeNewResults("Cooking started for " + context.minC + ":"
				+ context.secC);
	}

	@Override
	public void stop(Results result) {
		// TODO Auto-generated method stub
		// System.out.println("Need to start some operation for stoping.. ");
		result.storeNewResults("Need to start some operation for stoping.. ");
	}

	@Override
	public void setClock(Results result) {
		// TODO Auto-generated method stub
		// System.out.println("Transition : Idle -> Setting Time");
		result.storeNewResults("Transition : Idle -> Setting Time");
		context.setState(context.setTime);
		// System.out.println("Time of the day set "+ context.minS +":"+
		// context.secS);
		result.storeNewResults("Time of the day set " + context.minS + ":"
				+ context.secS);
	}

}
