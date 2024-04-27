package vendingmachine;

public class Order {
	
	static Inventory[] stock;
	String orderId; 
	String item; 
	int orderQuantity; 
	double totalAmount;
	
    public void calculateBill() {
        for (Inventory inventory : stock) {
            if (inventory.getItemName().equals(item)) {
                totalAmount = inventory.getPrice() * orderQuantity;
                inventory.setQuantity(inventory.getQuantity() - orderQuantity);
            	updateStock(inventory.getItemId(),inventory.getQuantity());
                break;
            }
        }
    }

    public void updateStock(String itemId, int quantity) {
        for (Inventory inventory : stock) {
            if (inventory.getItemId().equals(itemId)) {
                inventory.setQuantity(quantity);
                break;
            }
        }
    }
	public static Inventory[] getStock() {
		return stock;
	}
	public static void setStock(Inventory[] stock) {
		Order.stock = stock;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
