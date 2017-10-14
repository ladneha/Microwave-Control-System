package microwaveOven.service;

import microwaveOven.util.Results;

public class Cooking implements MicrowaveStateI {

	MicrowaveContext context;

	public Cooking(MicrowaveContext context) {
		this.context = context;
	}

	@Override
	public void start(Results result) {
		// TODO Auto-generated method stub
		// System.out.println("Already started in cooking mode...");
		result.storeNewResults("Already started in cooking mode...");

	}

	@Override
	public void stop(Results result) {
		// TODO Auto-generated method stub
		// go to paused state
		// System.out.println("Transition : Cooking -> Paused");
		result.storeNewResults("Transition : Cooking -> Paused");
		context.setState(context.paused);
		// System.out.println("Cooking Paused...");
		result.storeNewResults("Cooking Paused...");
		// to cancel again press stop/cancel
	}

	@Override
	public void setClock(Results result) {
		// TODO Auto-generated method stub
		// System.out.println("Stop the current operation before going to the next...");
		result.storeNewResults("Stop the current operation before going to the next...");
		// ignore
	}

}
