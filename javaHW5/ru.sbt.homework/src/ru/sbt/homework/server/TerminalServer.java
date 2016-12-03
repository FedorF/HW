package ru.sbt.homework.server;
import ru.sbt.homework.exceptions.*;


public class TerminalServer implements Server {
	private int balance;

	public TerminalServer(int balance) {
		this.balance = balance;
	}



	public void getCash(int amount) throws InvalidAmountException, NotEnoughMoneyException, LostConnectionException {
		if (amount % 100 != 0) {
			throw new InvalidAmountException();
		}
		else if (balance < amount) {
			throw new NotEnoughMoneyException();
		}
		else {
			if (Math.random() < 0.3) {
				throw new LostConnectionException(); 
			}
			else this.balance -= amount;
		}
	}

	public int getBalance() throws LostConnectionException {
		if (Math.random() < 0.3) {
			throw new LostConnectionException(); 
		}
		else return this.balance;
	}

	public void addCash(int amount) throws LostConnectionException, InvalidAmountException {
		if (amount % 100 != 0) {
			throw new InvalidAmountException();
		}
		else {
			if (Math.random() < 0.3) {
				throw new LostConnectionException(); 
			} else this.balance += amount;
		}
	}



}
