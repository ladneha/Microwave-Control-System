package microwaveOven.service;

import microwaveOven.util.Results;

public class Paused implements MicrowaveStateI {

	MicrowaveContext context;

	public Paused(MicrowaveContext context) {
		this.context = context;
	}

	@Override
	public void start(Results result) {
		// TODO Auto-generated method stub
		// go to cooking state to resume cooking
		// System.out.println("Transition : Paused -> Cooking");
		result.storeNewResults("Transition : Paused -> Cooking");
		context.setState(context.cooking);
		// System.out.println("Cooking resumed...");
		result.storeNewResults("Cooking resumed...");
	}

	@Override
	public void stop(Results result) {
		// TODO Auto-generated method stub
		// go to time of the day state and display time of the day
		// System.out.println("Transition : Paused -> Idle");
		result.storeNewResults("Transition : Paused -> Idle");
		context.setState(context.timeOfDay);
		// System.out.println("Cooking Stopped...");
		result.storeNewResults("Cooking Stopped...");
		// System.out.println("Display Time : "+ context.minS +":"+
		// context.secS);
		result.storeNewResults("Display Time : " + context.minS + ":"
				+ context.secS);
	}

	@Override
	public void setClock(Results result) {
		// TODO Auto-generated method stub
		// ignore
		// System.out.println("Need to stop the current operation before proceeding to the next...");
		result.storeNewResults("Need to stop the current operation before proceeding");
	}

}
