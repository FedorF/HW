package ru.sbt.homework.exceptions;

public class InvalidPinException extends Throwable{
	private final int attempt;
	public InvalidPinException(int attempt) {
		this.attempt = attempt;
	}
	public int getAttempt() {
		return attempt;
	}

}
