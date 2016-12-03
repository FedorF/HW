package ru.sbt.homework.server;

import ru.sbt.homework.exceptions.InvalidAmountException;
import ru.sbt.homework.exceptions.LostConnectionException;
import ru.sbt.homework.exceptions.NotEnoughMoneyException;

public interface Server {
	void getCash(int amount) throws InvalidAmountException, NotEnoughMoneyException, LostConnectionException;
	int getBalance() throws LostConnectionException;
	void addCash(int amount) throws LostConnectionException, InvalidAmountException;

}
