
public class Item {
//attributes: 
	//item name:
	String name =" ";
	// item price
	double price = 0;
	// item code:
	int code = 0;
	//item quantity 
	int qty = 0;
	
	Item(String name, double price,int code, int qty){
		this.name = name;
		this.price = price;
		this.code = code;
		this.qty = qty;
		
	}
//Methods:
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQty() {
		return this.qty;
	}
	
	// decrement method:
	public int decrementQty() {
		this.qty--;
		return this.qty;
	}
	
	
	
}
