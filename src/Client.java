
public class Client extends VendingMachine {
	//Attributes: 
	String name;
	int id;
	
	
	//constructor: 
	public Client(){
		name = "";
		id = 0;
	};
	//Constructor with given inputs:
	public Client(String name, int id){
		this.name = name;
		this.id = id;
	}

}
