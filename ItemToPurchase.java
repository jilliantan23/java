package labs8;

public class ItemToPurchase {
	   //private fields
	   private String item;
	   private int price;
	   private int quantity;
	   
	   //constructor initializing item to itemName, price to itemPrice...
	   public ItemToPurchase(String itemName, int itemPrice, int itemQuantity) {
	      item = itemName;
	      price = itemPrice;
	      quantity = itemQuantity;
	   }
	   
	   //default constructor
	   public ItemToPurchase() {
	      String itemName = "";
	      int itemPrice = 0;
	      int itemQuantity = 0;
	   }
	   
	   //public member methods
	   public void setName(String itemName) {
	      item = itemName;
	      return;
	   }
	   public String getName() {
	      return item;
	   }
	   public void setPrice(int itemPrice) {
	      price = itemPrice;
	      return;
	   }
	   public int getPrice() {
	      return price;
	   }
	   public void setQuantity(int itemQuantity) {
	      quantity = itemQuantity;
	      return;
	   }
	   public int getQuantity() {
	      return quantity;
	   }
	}