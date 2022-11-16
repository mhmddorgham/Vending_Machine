import java.util.Scanner;

// VendingMachine class extend from Item class

public class VendingMachine{
	Scanner input = new Scanner(System.in);
	//Attributes:
	int choiceByCode;
	String choosedItem;
	double itemCost;
	double insertedMoney;
	double oldMoney = 0;
	boolean invalidCode;
	String again ="";
	Item[] Beverages = new Item[3];
	Item[] Snakes = new Item[3];
	
	//constructor: inetilizes three types of beverages and snakes
	public VendingMachine() {
		//Beverages 
		Beverages[0] = new Item("Soda", 3, 100, 5);
		Beverages[1] = new Item("Juice", 2,101, 5);
		Beverages[2] = new Item("Water", 1,102, 5);
		
		
		//Snakes 
		Snakes[0] = new Item("Snicker", 3,200, 5);
		Snakes[1] = new Item("Chipps", 2,201, 5);
		Snakes[2] = new Item("KitKat", 1,202, 5);
	}
	
//Methods:
	// A method that displays goods in the machine: 
	public void displayItems() {
		System.out.println("Here are the goods:");
		
		//Display Beverages products:
		System.out.println("Beverages:");
		for(int i=0; i<Beverages.length; i++ ) {
			System.out.println((i+1) + ". " + Beverages[i].name + "  " + "         Price: AED " + Beverages[i].price + "           Quantity: " + Beverages[i].qty + "     Code: " +Beverages[i].code );
		}
		
		System.out.println(" ");
	//Display Snakes products:
		System.out.println("Snakes:");
		for(int i=0; i<Snakes.length; i++ ) {
			System.out.println((i+1) + ". " + Snakes[i].name + "  " +"        Price: AED " + Snakes[i].price + "          Quantity: " + Snakes[i].qty + "     Code: " +Snakes[i].code);
		
		}
		System.out.println(" ");
		System.out.println("--------- You are looking to the machine now! ----------");
		System.out.println(" ");

		
		
			
		
	}
//Choosing item method:
public void chooseItem(){
	//Check the all items are fully filled before starting the program:
	// loop through every product in the machine:
	//Check Beverages:
	for(int i=0; i<Beverages.length; i++ ) {
		if(Beverages[i].qty ==0) {
			System.out.println("!!!!!!!!!" + Beverages[i].name + " is out of stock, Need to call assistance" + "!!!!!!!!!");
			System.out.println("------------------------  Calling Assistance... ---------------------");
			Assistance ass = new Assistance();
			ass.refill(Beverages[i]);
			System.out.println("\n After refilling the machine:");
			displayItems();
		}
	}
	
	//Check Snakes:
	for(int i=0; i<Snakes.length; i++ ) {
		if(Snakes[i].qty ==0) {
			System.out.println("!!!!!!!!!" + Snakes[i].name + " is out of stock, Need to call assistance" + "!!!!!!!!!");
			System.out.println("------------------------  Calling Assistance... ---------------------");
			Assistance ass = new Assistance();
			ass.refill(Snakes[i]);
			System.out.println("\nAfter refilling the machine:");
			displayItems();
		}
	}
	
do {
	
System.out.println("Enter item's code: ");	
choiceByCode = input.nextInt();
// set invalid Code variable to false: 
invalidCode = false;
// set chooedItem the the name of item the user chooses
if(choiceByCode == 100) {
	// set good information
	choosedItem = Beverages[0].name;
	itemCost = Beverages[0].price;
}

else if(choiceByCode == 101) {
	// set good information
	choosedItem = Beverages[1].name;
	itemCost = Beverages[1].price;
}

else if(choiceByCode == 102) {
	// set good information
	choosedItem = Beverages[2].name;
	itemCost = Beverages[2].price;
}

else if(choiceByCode == 200) {
	// set good information
	choosedItem = Snakes[0].name;
	itemCost = Snakes[0].price;
}

else if(choiceByCode == 201) {
	// set good information
	choosedItem = Snakes[1].name;
	itemCost = Snakes[1].price;
}

else if(choiceByCode == 202) {
	// set good information
	choosedItem = Snakes[1].name;
	itemCost = Snakes[1].price;

}
//if the entered code was wrong
else {
	System.out.println("Sorry, the code is wrong");
	invalidCode = true;
}
//Ask Only if user did not choose a good or enter a wrong code:
if(invalidCode) {
System.out.println("Would you like to try again? y or n");
again = input.next();
}
// otherwise, do not loop on the code:
else {
	break;
}
	
}while(again.equalsIgnoreCase("y"));

}

//insertMoney Method:
public void insertCoin() {
	
	//Check if there is a previus money:
	if(insertedMoney>=itemCost) {
		return;
	}
	else {
		// inorder to add the old money with the new inserted money
		oldMoney = insertedMoney;
		insertedMoney = 0;
	do {
		System.out.println("Please add money:");
		insertedMoney = input.nextDouble();
		
		if(insertedMoney< itemCost) {
			System.out.println("Sorry, inserted money is not enough");
			System.out.println("Would you like to add money again? y/n");
			again = input.next();
		}
		else {
			break;
		}
	}while(again.equalsIgnoreCase("y"));
	
	System.out.println("You put AED " + insertedMoney);
	}
}

public void confirmMsg() {
	
	//add old money to the new inserted mony:
	insertedMoney += oldMoney;
	//Set old money to be zero so it does not add every time:
	oldMoney = 0;
	System.out.println(" ");
	System.out.println("Your item: " + choosedItem + " and it costs AED " + itemCost);
	System.out.println("Inserted Money: AED " + insertedMoney );
	System.out.println("Confirm? y or n?");
	again = input.next();
	
	if(again.equalsIgnoreCase("y")) {
		
		//After taking confirmation from the client, loop through all items,
		// and once you find the choosed item, decrement the item in the machine by one.
		// Check beverages products:
		for(int i=0; i<Beverages.length; i++) {
			if(Beverages[i].name.equalsIgnoreCase(choosedItem)) {
				Beverages[i].decrementQty();
			}
		}
		// Check beverages products:
		for(int i=0; i<Snakes.length; i++) {
			if(Snakes[i].name.equalsIgnoreCase(choosedItem)) {
				Snakes[i].decrementQty();
			}
		}
		//Retrive good:
		System.out.println("Your Item is "+ choosedItem);
		//Retrieve coins: 
		//subtract the item cost form total money 
		insertedMoney = insertedMoney -itemCost; 
		System.out.println("Reminder: " + insertedMoney);
	}
	else {
		System.out.println("Would you like to choose another item y/n");
		again = input.next();
		if(again.equalsIgnoreCase("y")) {
			chooseItem();
			insertCoin();
			confirmMsg();
		}
		else {
			System.out.println("Exit the machine");
		}
	}
	
}
	
}
