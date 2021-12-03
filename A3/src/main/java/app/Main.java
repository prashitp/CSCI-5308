package app;

import app.business.*;
import app.persistence.*;
import app.presentation.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main
{
	static OperationController operationController;
	static IWarehouse warehouse;
	public static void main(String[] args)
	{
		Output.printMessage("Welcome to the warehouse!");
		initialize();
		try {
			String currentDirectory = new java.io.File(".").getCanonicalPath();
			Output.printMessage("Current directory:" + currentDirectory);

			BufferedReader reader = readInput("input.txt");
			String line = reader.readLine();

			while (line != null)
			{
				if (line.length() > 0)
					executeInstruction(line);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (Exception e) {
			Output.printMessage("Error working with filesystem: " + e.getMessage());
		}
		Output.printMessage("Human resources reports " + operationController.getTotalMinutesWorked() + " minutes worked.");
	}

	private static void initialize() {
		warehouse = new Warehouse();
		operationController = new OperationController(warehouse);
	}
	private static void executeInstruction(String line) {
		String[] instruction = line.split(" ");
		String operation = instruction[0];
		String itemName = instruction[1];
		int itemCount;

		if (operation.equals(Constants.RECEIVE_OPERATION)) {
			itemCount = Integer.parseInt(instruction[2]);
			operationController.receiveItem(itemName, itemCount);
		}
		else if (operation.equals(Constants.SHIP_OPERATION)) {
			String account = instruction[2];
			itemCount = Integer.parseInt(instruction[3]);
			operationController.shipItem(itemName, account, itemCount);
		}
		else {
			Output.printMessage("Invalid operation");
		}
	}

	private static BufferedReader readInput(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			Output.printMessage("Error working with filesystem: " + e.getMessage());
		}
		return reader;
	}
}
