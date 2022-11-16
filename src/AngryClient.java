
public class AngryClient extends Client {
	//default constructor:
	public AngryClient() {
		super.name = "";
		super.id = 0;
	}
	//Constructor with given inputs:
	public AngryClient(String name, int id) {
		super.name = name;
		super.id = id;
	}
	
	//Kick Machine Method in angry clinet instead of confirm msg:
	public void kickMachine() {
		//add old money to the new inserted mony:
		insertedMoney += oldMoney;
		//make old money to be zero so it does not add every time:
		oldMoney = 0;
		System.out.println("Kick Machine to get item? y/n ");
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
