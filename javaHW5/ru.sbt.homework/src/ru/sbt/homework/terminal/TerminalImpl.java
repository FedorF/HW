package ru.sbt.homework.terminal;

import ru.sbt.homework.server.TerminalServer;
import ru.sbt.homework.exceptions.*;

public class TerminalImpl implements Terminal {
	private final TerminalServer server;
	private final PinValidator pinValidator;
	private boolean isValide;


	public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
		this.pinValidator = pinValidator;
		this.server = server;
		this.isValide = false; 
	}

	public boolean isValide() {
		return this.isValide;
	}

	@Override
	public void checkPin(String pin) throws AccountIsLockedException, InvalidPinException {
		pinValidator.validate(pin);
		this.isValide = true;
	}

	@Override
	public int checkBalance() throws LostConnectionException {

		return server.getBalance();

	}

	@Override
	public void getCash(int cash) throws InvalidAmountException, NotEnoughMoneyException, LostConnectionException {
		server.getCash(cash);

	}

	@Override
	public void addCash(int cash) throws LostConnectionException, InvalidAmountException {
		server.addCash(cash);

	}

}
