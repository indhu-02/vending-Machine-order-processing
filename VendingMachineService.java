package vendingmachine;

public class VendingMachineService {
	
	 public String checkInventoryStatus(String item, int orderQuantity) throws ItemOutOfStockException {
	        for (Inventory inventory : Order.stock) {
	            if (inventory.getItemName().equals(item)) {
	                if (inventory.getQuantity() < orderQuantity) {
	                    throw new ItemOutOfStockException();
	                } else {
	                    return "Item in Stock";
	                }
	            }
	        }
	        throw new ItemOutOfStockException(); 
	    }

	    public String validateData(String orderId, String item, int orderQuantity) throws InvalidOrderException, ItemOutOfStockException {
	        
	        if (orderId == null || !orderId.matches("^OR\\d{3}$")) {
	            throw new InvalidOrderException();
	        }
	       
	        
	        if (orderQuantity < 0 || orderQuantity > 10) {
	            throw new InvalidOrderException();
	        }
	       
	        
	        checkInventoryStatus(item, orderQuantity); 
	       
	        return "Valid";
	    }

	    public String generateBill(Order order) {
	        order.calculateBill();
	        return "Order id: " + order.getOrderId() + "\nAmount: Rs." + order.getTotalAmount();
	    }

	    public String processOrder(String orderId, String item, int orderQuantity) {
	        try {
	            validateData(orderId, item, orderQuantity);
	            Order order = new Order();
	            order.setOrderId(orderId);
	            order.setItem(item);
	            order.setOrderQuantity(orderQuantity);
	            return generateBill(order);
	        } catch (InvalidOrderException | ItemOutOfStockException e) {
	            return e.toString();
	        }
	    }

}
