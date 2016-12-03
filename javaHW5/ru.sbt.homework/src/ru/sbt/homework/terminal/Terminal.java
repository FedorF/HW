package ru.sbt.homework.terminal;

import ru.sbt.homework.exceptions.AccountIsLockedException;
import ru.sbt.homework.exceptions.InvalidAmountException;
import ru.sbt.homework.exceptions.InvalidPinException;
import ru.sbt.homework.exceptions.LostConnectionException;
import ru.sbt.homework.exceptions.NotEnoughMoneyException;

public interface Terminal {
	void checkPin(String pin) throws AccountIsLockedException, InvalidPinException;
	int checkBalance() throws LostConnectionException; 
	void getCash(int cash) throws InvalidAmountException, NotEnoughMoneyException, LostConnectionException;
	void addCash(int cash) throws LostConnectionException, InvalidAmountException;
}
