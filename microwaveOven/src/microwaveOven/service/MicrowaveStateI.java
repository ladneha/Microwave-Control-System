package microwaveOven.service;

import microwaveOven.util.Results;

public interface MicrowaveStateI {

	public void start(Results result);

	public void stop(Results result);

	public void setClock(Results result);

}
