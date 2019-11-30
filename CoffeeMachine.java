package com.miniprojectcoffeemachine.main;

import java.util.Scanner;


/* Created by: James McCoy
 * Created on: 10/16/19
 * Updated on: 
 * Version: 1.0
 * 
 * 
 * Requirements:
 * 
 * Upgrade your knowledge of methods - set the machine to perform three basic actions: collect the money, renew the supplies, and serve the coffee.
 * 
 * Description
 * 
 * Let's simulate an actual coffee machine. It has a limited supply of water, milk, coffee beans, and disposable cups. Also, it counts how much money it gets for selling coffee. The coffee machine has several options: first, it needs to be able to sell coffee. It can make different varieties of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, except that all of them requires only one disposable cup. Second, the coffee machine should be able to get replenished by a special worker. Third, another special worker should be able to take money from the coffee machine.
 * Write the program that can do one of these actions at a time. It reads one line from standard input, which can be "buy", "fill", "take". If you want to buy some coffee, input "buy". If you are a special worker and you think that it is time to fill out all the supplies for the coffee machine, input "fill". If you are another special worker and it is time to take the money from the coffee machine, input "take".
 * If the user writes "buy" then he must choose one of three varieties of coffee that the coffee machine can make: espresso, latte, or cappuccino.
 * For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
 * For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
 * And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
 * If the user writes "fill", the program should ask him how much water, milk, coffee beans and how many disposable cups he wants to add into the coffee machine.
 * If the user writes "take" the program should give him all the money that it earned from selling coffee.
 * At the moment, the coffee machine has $550, 1200 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.
 * Write the program that prints the coffee machine’s state, processes one query from the user, and also prints the coffee machine’s state after that. Try to use methods to implement every action that the coffee machine can do.
 * 
 * Output example
 * An espresso should be as number 1 in the list, a latte as number 2 and a cappuccino as number 3.
 * Options also should be named as "buy", "fill", "take".
 * 
 * The coffee machine has:
 * 1200 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 550 of money
 * 
 * Write action (buy, fill, take): buy
 * 
 * What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: 3
 * 
 * The coffee machine has:
 * 1000 of water
 * 440 of milk
 * 108 of coffee beans
 * 8 of disposable cups
 * 556 of money
 * 
 * or,
 * 
 * The coffee machine has:
 * 1200 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 550 of money
 * 
 * Write action (buy, fill, take): fill
 * Write how many ml of water do you want to add: 2000
 * Write how many ml of milk do you want to add: 500
 * Write how many grams of coffee beans do you want to add: 100
 * Write how many disposable cups of coffee do you want to add: 10
 * 
 * The coffee machine has:
 * 3200 of water
 * 1040 of milk
 * 220 of coffee beans
 * 19 of disposable cups
 * 550 of money
 * 
 * or,
 * 
 * The coffee machine has:
 * 1200 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 550 of money
 * 
 * Write action (buy, fill, take): take
 * I gave you $550
 * 
 * The coffee machine has:
 * 1200 of water
 * 540 of milk
 * 120 of coffee beans
 * 9 of disposable cups
 * 0 of money
 * 
 * 
 * OUTPUT
 *	-Buy?
 *		-Espresso
 *			-$4
 *		-Latte
 *			-$7
 *		-Cappuccino
 *			-$6
 *		-Print state of coffee machine
 *	-Fill?
 *		-"How much water would you like to add?"
 *			-Provide capacity
 *			-Provide current amount
 *			-Provide amount needed to reach capacity
 *		-"How much milk would you like to add?"
 * 			-Provide capacity
 *			-Provide current amount
 *			-Provide amount needed to reach capacity
 *		-"How many disposable cups would you like to add?"
 *			-Provide capacity
 *			-Provide current amount
 *			-Provide amount needed to reach capacity
 *		-Print state of coffee machine
 *
 *	-Take?	
 * 
 * 
 * 
 * COFFEE MACHINE MENU
 * 1 Buy
 * 2 Fill
 * 3 Take
 * 4 Remaining
 * 5 Exit
 * ENTER YOUR CHOICE [1 - 5]
 */

public class CoffeeMachine {
	static int waterSupply = 1200;
	static int milkSupply = 540;
	static int beansSupply = 120;
	static int cupsSupply = 9;
	static int cups = 0;
	static int moneySupply = 550;
	static int money = 0;
	static int water = 0;
	static int milk = 0;
	static int beans = 0;
	static final int CUPESPRESSOWATERMIN = 250;
	static final int CUPLATTEWATERMIN = 350;
	static final int CUPCAPPUCCINOWATERMIN = 200;
	static final int CUPLATTEMILKMIN = 75;
	static final int CUPCAPPUCCINOMILKMIN = 100;
	static final int CUPESPRESSOBEANSMIN = 16;
	static final int CUPLATTEBEANSMIN = 20;
	static final int CUPCAPPUCCINOBEANSMIN = 12;
	static final int CUPESPRESSOMONEYMIN = 4;
	static final int CUPLATTEMONEYMIN = 7;
	static final int CUPCAPPUCCINOMONEYMIN = 6;
	
	
	public static void main(String[] args) {
		
		getMainMenuUserSelection();

	} //main method
	
	
	public static void getMainMenuUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printMainMenu();
			do {
				System.out.printf("\nEnter the Text Corresponding to Your Choice (ex: 1 = 'Buy') ");
				choice = sc.next().toLowerCase();
//				System.out.println((!(choice.equals("Buy")  || (!(choice.equals("Fill"))) || (!(choice.equals("Take"))) || (!(choice.equals("Remaining"))) || (!(choice.equals("Exit"))) ) ? "Invalid Entry" : "Valid Entry"));
			} while (!((choice.equals("buy") || (choice.equals("fill") || (choice.equals("take") || (choice.equals("remaining") || (choice.equals("exit"))))))));
			getMainMenuChoice(choice);
		} while (!(choice.equals("exit")));
	} //getMainMenuUserInput method
	
	
	public static void getMainMenuChoice(String choice) {
		switch (choice) {
		case "buy":
			getBuyMenuUserSelection();
			break;
		case "fill":
			getFillMenuUserSelection();
			break;
		case "take":
			getTakeMenuUserSelection();
			break;
		case "remaining":
			getRemainingMenuUserSelection();
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	} //getMainMenuChoices method
	
	
	public static void printMainMenu() {
		System.out.println("\nMain Menu");
		System.out.println("1. Buy ");
		System.out.println("2. Fill ");
		System.out.println("3. Take ");
		System.out.println("4. Remaining ");
		System.out.println("5. Exit ");
	}
	
	
	public static void printBuyMenu () {
	
	System.out.println("\nWhat do you want to buy?");
	System.out.println("1. Espresso ");
	System.out.println("2. Latte ");
	System.out.println("3. Cappuccino ");
	System.out.println("4. Exit ");
	}
	
	
	public static void printFillMenu () {
	
	System.out.println("\nWhat do you want to add to the coffee machine?");
	System.out.println("1. Water ");
	System.out.println("2. Milk ");
	System.out.println("3. Beans ");
	System.out.println("4. Cups ");
	System.out.println("5. Exit ");
	}
	
	public static void printTakeMenu () {
		
	System.out.println("\nDo you want to take the coffee machine's money or exit?");
	System.out.println("1. Take ");
	System.out.println("2. Exit ");
	}
	
	
	public static void printRemainingMenu () {
		
	System.out.println("\nDo you want to view the coffee machine's inventory or exit?");
	System.out.println("1. View ");
	System.out.println("2. Exit ");
	}
	
	
	public static void getBuyMenuUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printBuyMenu();
			do {
				System.out.printf("\nEnter the Text Corresponding to Your Choice (ex: 1 = 'Espresso') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("espresso") || (choice.equals("latte") || (choice.equals("cappuccino") || (choice.equals("exit")))))));
			getBuyMenuChoice(choice);
		} while (!(choice.equals("exit")));
	}
	
	
	public static void getFillMenuUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printFillMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Water') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("water") || (choice.equals("milk") || (choice.equals("beans") || (choice.equals("cups") || (choice.equals("exit"))))))));
			getFillMenuChoice(choice);
		} while (!(choice.equals("exit")));
	}
	
	
	public static void getTakeMenuUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printTakeMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Take') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("take") || (choice.equals("exit")))));
			getTakeMenuChoice(choice);
		} while (!(choice.equals("exit")));
	}
	
	
	public static void getRemainingMenuUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printRemainingMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'View') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("view") || (choice.equals("exit")))));
			getRemainingMenuChoice(choice);
		} while (!(choice.equals("exit")));
	}
	
	
	public static void getBuyMenuChoice(String choice) {
		switch (choice) {
		case "espresso":
			getEspressoUserSelection();
			break;
		case "latte":
			getLatteUserSelection();
			break;
		case "cappuccino":
			getCappuccinoeUserSelection();
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getFillMenuChoice(String choice) {
		switch (choice) {
		case "water":
			getAddWaterUserSelection();
			break;
		case "milk":
			getAddMilkUserSelection();
			break;
		case "beans":
			getAddBeansUserSelection();
			break;
		case "cups":
			getAddCupsUserSelection();
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getTakeMenuChoice(String choice) {
		switch (choice) {
		case "take":
			getTakeAction();
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getRemainingMenuChoice(String choice) {
		switch (choice) {
		case "view":
			getRemainingAction();
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getEspressoUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printEspressoMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
//				System.out.println((!(choice.equals("Buy")  || (!(choice.equals("Fill"))) || (!(choice.equals("Take"))) || (!(choice.equals("Remaining"))) || (!(choice.equals("Exit"))) ) ? "Invalid Entry" : "Valid Entry"));
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getEspressoChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	}
	
	
	public static void getLatteUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printLatteMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
//				System.out.println((!(choice.equals("Buy")  || (!(choice.equals("Fill"))) || (!(choice.equals("Take"))) || (!(choice.equals("Remaining"))) || (!(choice.equals("Exit"))) ) ? "Invalid Entry" : "Valid Entry"));
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getLatteChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	} //getEspressoUserInput method
	
	
	public static void getCappuccinoeUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printCappuccinoMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
//				System.out.println((!(choice.equals("Buy")  || (!(choice.equals("Fill"))) || (!(choice.equals("Take"))) || (!(choice.equals("Remaining"))) || (!(choice.equals("Exit"))) ) ? "Invalid Entry" : "Valid Entry"));
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getCappuccinoChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	}
	
	
	public static void getAddWaterUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printAddWaterMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
//				System.out.println((!(choice.equals("Buy")  || (!(choice.equals("Fill"))) || (!(choice.equals("Take"))) || (!(choice.equals("Remaining"))) || (!(choice.equals("Exit"))) ) ? "Invalid Entry" : "Valid Entry"));
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getAddWaterChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	}
	
	
	public static void getAddMilkUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printAddMilkMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getAddMilkChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	}
	
	
	public static void getAddBeansUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printAddBeansMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getAddBeansChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	}
	
	
	public static void getAddCupsUserSelection() {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			printAddCupsMenu();
			do {
				System.out.printf("Enter the Text Corresponding to Your Choice (ex: 1 = 'Y') ");
				choice = sc.next().toLowerCase();
			} while (!((choice.equals("y") || (choice.equals("n") || (choice.equals("exit"))))));
			getAddCupsChoice(choice);
		} while (!((choice.equals("exit") || (choice.equals("n")))));
	}
	
	
	public static void printEspressoMenu() {
		System.out.println("\nEspresso is $" + CUPESPRESSOMONEYMIN + " per cup. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void printLatteMenu() {
		System.out.println("\nLatte is $" + CUPLATTEMONEYMIN + " per cup. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void printCappuccinoMenu() {
		System.out.println("\nCappuccino is $" + CUPCAPPUCCINOMONEYMIN + " per cup. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void printAddWaterMenu() {
		System.out.println("\nCurrent water supply is " + waterSupply + "ml. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void printAddMilkMenu() {
		System.out.println("\nCurrent milk supply is " + milkSupply + "ml. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void printAddBeansMenu() {
		System.out.println("\nCurrent beans supply is " + beansSupply + "g. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void printAddCupsMenu() {
		System.out.println("\nCurrent cups supply is " + cupsSupply + " cups. Continue?");
		System.out.println("1. Y");
		System.out.println("2. N");
		System.out.println("3. Exit");
	}
	
	
	public static void getEspressoChoice(String choice) {
		switch (choice) {
		case "y":
			getEspressoOrdered();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getLatteChoice(String choice) {
		switch (choice) {
		case "y":
			getLatteOrdered();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getCappuccinoChoice(String choice) {
		switch (choice) {
		case "y":
			getCappuccinoOrdered();
			break;
		case "n":
			break;
		case "Exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getAddWaterChoice(String choice) {
		switch (choice) {
		case "y":
			getAddWaterAction();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getAddMilkChoice(String choice) {
		switch (choice) {
		case "y":
			getAddMilkAction();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getAddBeansChoice(String choice) {
		switch (choice) {
		case "y":
			getAddBeansAction();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getAddCupsChoice(String choice) {
		switch (choice) {
		case "y":
			getAddCupsAction();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getTakeChoice(String choice) {
		switch (choice) {
		case "y":
			getTakeAction();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getRemainingChoice(String choice) {
		switch (choice) {
		case "y":
			getRemainingAction();
			break;
		case "n":
			break;
		case "exit":
			break;
		default:
			System.out.println("Invalid Entry ");
		}
	}
	
	
	public static void getEspressoOrdered() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nEspresso Order");
		do {
			System.out.printf("Enter the amount of espresso cups you would like to buy (1-" + cupsSupply + "): ");
			cups = sc.nextInt();
			System.out.printf("Please confirm the $" + (cups*CUPESPRESSOMONEYMIN) + " payment amount for " + cups + " cup(s) of espresso by re-entering the payment amount: ");
			money = sc.nextInt();
			if (cups<1 || cups >cupsSupply || money != CUPESPRESSOMONEYMIN * cups) 
				System.out.println("Invalid entry. Please enter the correct number of cups and corresponding payment amount: ");
		} while (cups<1 || cups >cupsSupply || money != CUPESPRESSOMONEYMIN * cups); // up to 10 cups
		// Check for cups print
//		System.out.println("You want " + cups + " cups!");
//		System.out.println("Here they are!");
		
		if (isEnoughWaterEspresso(cups) && isEnoughCups(cups)) {
			System.out.println("\nPreparing your cups..Please wait...");
			System.out.println("Your " + cups + " cups of espresso are ready!");
			updateWaterSupplyEspresso(cups);
			updateBeansSupplyEspresso(cups);
			updateCupsSupply(cups);
			updateMoneySupply(cups);
			System.out.println(waterSupply + "ml of water remaining");
			System.out.println(beansSupply + "g of beans remaining");
			System.out.println(cupsSupply + " cups remaining");
			System.out.println("$" + moneySupply + " collected from sales");
		} else {
			System.out.println("Insufficient supply. Enough water for " + (int)(waterSupply / CUPESPRESSOWATERMIN) + " cups. Enough cups for " + cupsSupply + " drinks");
		}	
	}
	
	
	public static void getLatteOrdered() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nLatte Order");
		do {
			System.out.printf("Enter the amount of latte cups you would like to buy (1-" + cupsSupply + "): ");
			cups = sc.nextInt();
			System.out.printf("Please confirm the $" + (cups*CUPLATTEMONEYMIN) + " payment amount for " + cups + " cup(s) of latte by re-entering the payment amount: ");
			money = sc.nextInt();
			if (cups<1 || cups >cupsSupply || money != CUPLATTEMONEYMIN * cups) 
				System.out.println("Invalid entry. Please enter the correct number of cups and corresponding payment amount: ");
		} while (cups<1 || cups >cupsSupply || money != CUPLATTEMONEYMIN * cups); // up to 10 cups
		// Check for cups print
//		System.out.println("You want " + cups + " cups!");
//		System.out.println("Here they are!");
		
		if (isEnoughWaterLatte(cups) && isEnoughCups(cups)) {
			System.out.println("Preparing your cups..Please wait...");
			System.out.println("Your " + cups + " cups of latte are ready!");
			updateWaterSupplyLatte(cups);
			updateMilkSupplyLatte(cups);
			updateBeansSupplyLatte(cups);
			updateCupsSupply(cups);
			updateMoneySupply(cups);
			System.out.println(waterSupply + "ml of water remaining");
			System.out.println(beansSupply + "g of beans remaining");
			System.out.println(cupsSupply + " cups remaining");
			System.out.println("$" + moneySupply + " collected from sales");
		} else {
			System.out.println("Insufficient supply. Enough water for " + (int)(waterSupply / CUPLATTEWATERMIN) + " cups. Enough cups for " + cupsSupply + " drinks");
		}	
	}
	
	
	public static void getCappuccinoOrdered() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nCappuccino Order");
		do {
			System.out.printf("Enter the amount of cappuccino cups you would like to buy (1-" + cupsSupply + "): ");
			cups = sc.nextInt();
			System.out.printf("Please confirm the $" + (cups*CUPCAPPUCCINOMONEYMIN) + " payment amount for " + cups + " cup(s) of cappuccino by re-entering the payment amount: ");
			money = sc.nextInt();
			if (cups<1 || cups >cupsSupply || money != CUPCAPPUCCINOMONEYMIN * cups) 
				System.out.println("Invalid entry. Please enter the correct number of cups and corresponding payment amount: ");
		} while (cups<1 || cups >cupsSupply || money != CUPCAPPUCCINOMONEYMIN * cups); // up to 10 cups
		// Check for cups print
//		System.out.println("You want " + cups + " cups!");
//		System.out.println("Here they are!");
		
		if (isEnoughWaterCappuccino(cups) && isEnoughCups(cups)) {
			System.out.println("Preparing your cups..Please wait...");
			System.out.println("Your " + cups + " cups of cappuccino are ready!");
			updateWaterSupplyCappuccino(cups);
			updateMilkSupplyCappuccino(cups);
			updateBeansSupplyCappuccino(cups);
			updateCupsSupply(cups);
			updateMoneySupply(cups);
			System.out.println(waterSupply + "ml of water remaining");
			System.out.println(beansSupply + "g of beans remaining");
			System.out.println(cupsSupply + " cups remaining");
			System.out.println("$" + moneySupply + " collected from sales");
		} else {
			System.out.println("Insufficient supply. Enough water for " + (int)(waterSupply / CUPCAPPUCCINOWATERMIN) + " cups. Enough cups for " + cupsSupply + " drinks");
		}	
	}
	
	
	public static void getAddWaterAction() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nAdd Water");
		do {
			System.out.printf("Enter the amount of water you would like to add to the coffee machine: ");
			water = sc.nextInt();
			if (water < 1) 
				System.out.println("Invalid entry. Please enter water amount greater than 1");
		} while (water < 1);
		
		if (water > 1) {
			System.out.println("You added " + water + "ml of water to the coffee machine");
			updateAddToWaterSupply(water);
			System.out.println(waterSupply + "ml of water is remaining");
		} else {
			System.out.println("Error. Please enter a water amount greater than 1");
		}	
	}
	
	
	public static void getAddMilkAction() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nAdd Milk");
		do {
			System.out.printf("Enter the amount of milk you would like to add to the coffee machine: ");
			milk = sc.nextInt();
			if (milk < 1) 
				System.out.println("Invalid entry. Please enter milk amount greater than 1");
		} while (milk < 1);
		
		if (milk > 1) {
			System.out.println("You added " + milk + "ml of milk to the coffee machine");
			updateAddToMilkSupply(milk);
			System.out.println(milkSupply + "ml of milk is remaining");
		} else {
			System.out.println("Error. Please enter a milk amount greater than 1");
		}	
	}
	
	
	public static void getAddBeansAction() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nAdd Beans");
		do {
			System.out.printf("Enter the amount of beans you would like to add to the coffee machine: ");
			beans = sc.nextInt();
			if (beans < 1) 
				System.out.println("Invalid entry. Please enter beans amount greater than 1");
		} while (beans < 1);
		
		if (beans > 1) {
			System.out.println("You added " + beans + "g of beans to the coffee machine");
			updateAddToBeansSupply(beans);
			System.out.println(beansSupply + "g of beans are remaining");
		} else {
			System.out.println("Error. Please enter a beans amount greater than 1");
		}	
	}
	
	
	public static void getAddCupsAction() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nAdd Cups");
		do {
			System.out.printf("Enter the amount of cups you would like to add to the coffee machine: ");
			cups = sc.nextInt();
			if (cups < 1) 
				System.out.println("Invalid entry. Please enter cups amount greater than 1");
		} while (cups < 1);
		
		if (cups > 1) {
			System.out.println("You added " + cups + " cups to the coffee machine");
			updateAddToCupsSupply(cups);
			System.out.println(cupsSupply + " cups are remaining");
		} else {
			System.out.println("Error. Please enter a cups amount greater than 1");
		}	
	}
	
	
	public static void getTakeAction() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("\nTake Money");
		do {
			System.out.printf("Enter the amount of money you would like to take from the coffee machine: ");
			money = sc.nextInt();
			if (money < 1) 
				System.out.println("Invalid entry. Please enter a money amount greater than 1");
		} while (money < 1);
		
		if (money > 1) {
			System.out.println("You withdrew $" + money + " from the coffee machine");
			updateTakeMoneySupply(money);
			System.out.println("$" + moneySupply + " is remaining");
		} else {
			System.out.println("Error. Please enter a dollar amount greater than 1");
		}	
	}
	
	
	public static void getRemainingAction() {
		
		System.out.println("\nThe coffee machine has: ");
		System.out.println(waterSupply + "ml of water");
		System.out.println(milkSupply + "ml of milk");
		System.out.println(beansSupply + "g of beans");
		System.out.println(cupsSupply + " disposable cups");
		System.out.println("$" + moneySupply + " of cash on hand");
		
	}
	
	
	public static boolean isEnoughWaterEspresso (int pcups) {
		int maxCups = waterSupply / CUPESPRESSOWATERMIN;
		if (pcups > maxCups)
			return false;
		else
			return true;
	}
	
	
	public static boolean isEnoughWaterLatte (int pcups) {
		int maxCups = waterSupply / CUPLATTEWATERMIN;
		if (pcups > maxCups)
			return false;
		else
			return true;
	}
	
	
	public static boolean isEnoughWaterCappuccino (int pcups) {
		int maxCups = waterSupply / CUPCAPPUCCINOWATERMIN;
		if (pcups > maxCups)
			return false;
		else
			return true;
	}		
	
	
	public static boolean isEnoughCups (int pcups) {
		int maxCups = cupsSupply;
		if (pcups > maxCups)
			return false;
		else
			return true;
	}
	
	
	
	
	public static int calcEspressoWaterUse (int pcups) {
		int espressoWater = pcups * CUPESPRESSOWATERMIN;
		
		return espressoWater;
	}
	
	
	public static int calcLatteWaterUse (int pcups) {
		int latteWater = pcups * CUPLATTEWATERMIN;
		
		return latteWater;
	}
	
	
	public static int calcCappuccinoWaterUse (int pcups) {
		int cappuccinoWater = pcups * CUPCAPPUCCINOWATERMIN;
		
		return cappuccinoWater;
	}
	
	
	public static int calcLatteMilkUse (int pcups) {
		int latteMilk = pcups * CUPLATTEMILKMIN;
		
		return latteMilk;
	}
	
	
	public static int calcCappuccinoMilkUse (int pcups) {
		int cappuccinoMilk = pcups * CUPCAPPUCCINOMILKMIN;
		
		return cappuccinoMilk;
	}
	
	
	public static int calcEspressoBeansUse (int pcups) {
		int espressoBeans = pcups * CUPESPRESSOBEANSMIN;
		
		return espressoBeans;
	}
	
	
	
	
	public static int calcLatteBeansUse (int pcups) {
		int latteBeans = pcups * CUPLATTEBEANSMIN;
		
		return latteBeans;
	}	
	
	
	public static int calcCappuccinoBeansUse (int pcups) {
		int cappuccinoBeans = pcups * CUPCAPPUCCINOBEANSMIN;
		
		return cappuccinoBeans;
	}

	
	public static void updateWaterSupplyEspresso (int pcups) {
		waterSupply = waterSupply - calcEspressoWaterUse(pcups);
		// Water supply check
	}
	
	
	public static void updateWaterSupplyLatte (int pcups) {
		waterSupply = waterSupply - calcLatteWaterUse(pcups);
		// Water supply check
	}
	
	
	public static void updateWaterSupplyCappuccino (int pcups) {
		waterSupply = waterSupply - calcCappuccinoWaterUse(pcups);
		// Water supply check
	}
	
	
	public static void updateMilkSupplyLatte (int pcups) {
		milkSupply = milkSupply - calcLatteMilkUse(pcups);
		// Water supply check
	}
	
	
	public static void updateMilkSupplyCappuccino (int pcups) {
		milkSupply = milkSupply - calcCappuccinoMilkUse(pcups);
		// Water supply check
	}
	
	
	public static void updateBeansSupplyEspresso (int pcups) {
		beansSupply = beansSupply - calcEspressoBeansUse(pcups);
	}
	
	
	public static void updateBeansSupplyLatte (int pcups) {
		beansSupply = beansSupply - calcLatteBeansUse(pcups);
	}
	
	
	public static void updateBeansSupplyCappuccino (int pcups) {
		beansSupply = beansSupply - calcCappuccinoBeansUse(pcups);
	}
	
	
	public static void updateCupsSupply (int pcups) {
		cupsSupply = cupsSupply - cups;
	}
	
	
	public static void updateMoneySupply (int pcups) {
		moneySupply = moneySupply + money;
	}
	
	
	public static void updateAddToWaterSupply (int water) {
		waterSupply = waterSupply + water;
	}
	
	
	public static void updateAddToMilkSupply (int milk) {
		milkSupply = milkSupply + milk;
	}
	
	
	public static void updateAddToBeansSupply (int beans) {
		beansSupply = beansSupply + beans;
	}
	
	public static void updateAddToCupsSupply (int cups) {
		cupsSupply = cupsSupply + cups;
	}
	
	
	public static void updateTakeMoneySupply (int money) {
		moneySupply = moneySupply - money;
	}
	

} //class