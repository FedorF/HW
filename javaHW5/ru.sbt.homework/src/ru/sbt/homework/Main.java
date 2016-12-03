package ru.sbt.homework;
import java.util.Scanner;
import ru.sbt.homework.exceptions.*;
import ru.sbt.homework.server.*;
import ru.sbt.homework.terminal.*;
public class Main {
	
	public static void main(String[] args) {
		PinValidator validator = new PinValidator("5555");
		TerminalServer server = new TerminalServer(500);
		TerminalImpl terminal = new TerminalImpl(server, validator);
		Scanner in = new Scanner(System.in);
		
		
		while (true) {
            validate(in, terminal);
            System.out.println("What would you like to do?\n" +
					"\"b\" - to get balance\n" +
					"\"g\" - to get money\n" +
					"\"a\" - to add money\n");
			chooseAction(in.next(), terminal, in);
			
		}
	}

	private static void chooseAction(String next, TerminalImpl terminal, Scanner in) {
		switch (next) {
		case "a":
			System.out.println("Enter amount:");
			int sum = in.nextInt();
			try {
				terminal.addCash(sum);
			} catch (LostConnectionException e) {
				System.out.println("Error: Connection is lost, try later.");
			}
			catch (InvalidAmountException e) {
				System.out.println("Error: amount has to mulptiple to 100.");
			}
			break;
		case "b":
			try {
				System.out.println(terminal.checkBalance());
			} catch (LostConnectionException e) {
				System.out.println("Error: Connection is lost, try later.");
		    }
			break;
		case "g":
			System.out.println("Enter amount:");
			sum = in.nextInt();
			try {
				terminal.getCash(sum);
						
			} catch (LostConnectionException e) {
				System.out.println("Error: Connection is lost, try later.");
			} catch (NotEnoughMoneyException e) {
				System.out.println("Error: You have not enough money.");
			} catch (InvalidAmountException e) {
				System.out.println("Error: amount has to mulptiple to 100.");
			}
			break;
		default:
			System.out.println("Unknown command.");
		}
	}

	private static void validate(Scanner in, TerminalImpl terminal) {
		while(terminal.isValide() != true) {
			System.out.println("Enter your PIN number:");
			try {
				terminal.checkPin(in.next());
			} catch (InvalidPinException e) {
				System.out.println("Invalid PIN number. You have " + e.getAttempt() + " attempts. " );
			} catch (AccountIsLockedException e) {
				System.out.println("Your card is locked for " + e.getTime() + " seconds. ");
			}
		}
	}


}


