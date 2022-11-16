import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Variables to start the vending machine:
		int choose;
		int clientOption;
		int assistanceOption;
		String chooseAgain;
		String useMachine;
		String refillItemName;
		System.out.println("Welcome to Vending Machine");
		System.out.println("Choose your status?");
		System.out.println("1. Client");
		System.out.println("2. AngryClient");
		System.out.println("3. Assistance");
		choose = input.nextInt();
		
		// Normal Client:
		if(choose == 1) {
			Client client = new Client();
			do {
				System.out.println("Choose an option: ");
				System.out.println("1. Use the machine");
				System.out.println("2. Call Assistance");
				clientOption = input.nextInt();
				// if the client choose to use the machine
				if(clientOption == 1)  {
				
				do {
					client.displayItems();
					client.chooseItem();
					client.insertCoin();
					client.confirmMsg();
					//ask the user again if they want to continue buying from the machine
					System.out.println("Would you like to choose another item? y/n");
					chooseAgain = input.next();
					
				}while(chooseAgain.equalsIgnoreCase("y"));
			}
				// if client choose to call assistance:
				else if (clientOption == 2) {
					System.out.println("Calling Assistance...");
					System.out.println("You have called Assistance");
				}
				//if client choose a wrong choice
				else {
					System.out.println("Wrong choice");
				}
				// ask the user to use the maching after calling the assistance
				System.out.println("Do you want to use the machine now? y/n? ");
				useMachine = input.next();
				
			}while(useMachine.equalsIgnoreCase("y"));
	}
		
		//Angry Client: 
		else if(choose==2) {
			AngryClient angry = new AngryClient();
			do {
				System.out.println("Choose an option: ");
				System.out.println("1. Use the machine");
				System.out.println("2. Call Assistance");
				clientOption = input.nextInt();
				// if the client choose to use the machine
				if(clientOption == 1)  {
				
				do {
					angry.displayItems();
					angry.chooseItem();
					angry.insertCoin();
					angry.kickMachine();
					//ask the user again if they want to continue buying from the machine
					System.out.println("Would you like to choose another item? y/n");
					chooseAgain = input.next();
					
				}while(chooseAgain.equalsIgnoreCase("y"));
			}
				// if angry client choose to call assistance:
				else if (clientOption == 2) {
					System.out.println("Calling Assistance...");
					System.out.println("You have called Assistance");
				}
				//if angry client choose a wrong choice
				else {
					System.out.println("Wrong choice");
				}
				// ask the angry client to use the maching after calling the assistance
				System.out.println("Do you want to use the machine? y/n? ");
				useMachine = input.next();
				
			}while(useMachine.equalsIgnoreCase("y"));
			
		}
		//Assistance person:
		else if(choose ==3) {
			Assistance ass = new Assistance();
			System.out.println("Enter your name:");
			ass.name = input.next();
			System.out.println("Enter your ID");
			ass.id = input.nextInt();
			
			System.out.println("Choose an Option:");
			System.out.println("1. Fix the machine");
			System.out.println("2. Refill the machine");
			assistanceOption = input.nextInt();
			// if assistace person choose to fix the machine 
			if(assistanceOption == 1) {
				ass.fixMachine();
			}
			// if assistance person choose to refill an item in the machine
			else if(assistanceOption ==2) {
				//crate a new object from VendingMachine class:
				VendingMachine vm = new VendingMachine();
				System.out.println("Enter name of the item that you want to refill:");
				refillItemName = input.next();
				//Beverages items:
				for(int i=0; i<vm.Beverages.length; i++) {
					if(vm.Beverages[i].name.equalsIgnoreCase(refillItemName) ) {
						ass.refill(vm.Beverages[i]);
					}
				}
				
				// Snakes Items:
				for(int i=0; i<vm.Snakes.length; i++) {
					if(vm.Snakes[i].name.equalsIgnoreCase(refillItemName) ) {
						ass.refill(vm.Snakes[i]);
					}
				}
			}
			// if assistance person choose a wrong choice
			else {
				System.out.println("Wrong Choice");
			}
			
			
		}
			
		
}

}
