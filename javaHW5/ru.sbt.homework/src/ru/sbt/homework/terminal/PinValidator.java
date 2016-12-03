package ru.sbt.homework.terminal;

import java.util.Date;
import ru.sbt.homework.exceptions.*;


public class PinValidator  {
	private final String pin;
	private int attempt;
	long startTime = 0;
    private boolean isLocked = false;

	public PinValidator(String pin) {
		this.pin = pin;
		this.attempt = 0;
	}

	public void validate(String pin) throws AccountIsLockedException, InvalidPinException {
		if (this.pin.equals(pin) && isLocked == false) {
			attempt = 0;
		}
		else {
			attempt++;
			if (attempt < 3) {
                throw new InvalidPinException(3 - attempt);

			} 
			else {
                if (startTime == 0) {
                    startTime = System.currentTimeMillis();
                    isLocked = true;
                    throw new AccountIsLockedException(5);

                }
                else {
                    if (((System.currentTimeMillis() - startTime) / 1000) < 5) {
                        isLocked = true;
                        throw new AccountIsLockedException(5 - ((System.currentTimeMillis() - startTime) / 1000) );
                    }
                    else {
                        startTime = 0;
                        attempt = 0;
                        isLocked = false;
                        throw new InvalidPinException(3 - attempt);
                    }
                }

			}
		}
	}
}
