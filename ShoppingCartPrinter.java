package labs8;
import java.util.Scanner;
public class ShoppingCartPrinter {
	public static void main(String[] args) {
		   
		Scanner scan = new Scanner(System.in);
	    String itemName = new String();
	    int itemPrice = 0;
	    int itemQty = 0;
	    
	    //prompt user to input the first item's name, price and quantity
	    System.out.println("Item 1");
	    System.out.println("Enter the item name:");
	    itemName = scan.nextLine();
	    System.out.println("Enter the item price:");
	    itemPrice = scan.nextInt();
	    System.out.println("Enter the item quantity:");
	    itemQty = scan.nextInt();
	    System.out.println();
	    
	    //first object of type ItemToPurchase
	    ItemToPurchase item1 = new ItemToPurchase(itemName, itemPrice, itemQty);
	    
	    //scan to allow user to input new string
	    scan.nextLine();
	    
	    //prompt user to input the second item's name, price and quantity
	    System.out.println("Item 2");
	    System.out.println("Enter the item name:");
	    itemName = scan.nextLine();
	    System.out.println("Enter the item price:");
	    itemPrice = scan.nextInt();
	    System.out.println("Enter the item quantity:");
	    itemQty = scan.nextInt();
	    System.out.println();
	    
	    //second object of type ItemToPurchase
	    ItemToPurchase item2 = new ItemToPurchase(itemName, itemPrice, itemQty);
	    
	    //print total cost
	    System.out.println("TOTAL COST");
	    System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + item1.getQuantity() * item1.getPrice() ); 
	    System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + item2.getQuantity() * item2.getPrice() );
	    System.out.println();
	    System.out.println("Total: $" + (item1.getQuantity() * item1.getPrice() + item2.getQuantity() * item2.getPrice()));
	}
}
