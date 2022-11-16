
public class Assistance {
	String name;
	int id;
	
	//Methods: 
	

	// fix the vending machine method: 
	public void fixMachine() {
		System.out.println("Fixing the Machine...");
		System.out.println("Machine Has been fixed!");
	}
	
	// Refill method
	public void refill(Item item) {
		//Maximum quantity of each item is 5
		if(item.qty<5) {
		System.out.println("Start Refilling the item...");
		// update the quantity of an item to 5 items
		item.qty = 5;
		System.out.println("Refilling is done");
		}
		// if the quantity of an item already 5 
		else {
			System.out.println(item.name + "is full!");
		}
		
		
	}
	

}
