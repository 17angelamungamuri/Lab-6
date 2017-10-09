
public class Order {

	public Order(long acct, long order, String orderDate, String delivDate) {
		long acctNum = acct; 
		long orderNum = order; 
		String creationDate = orderDate; 
		String deliveryDate = delivDate; 
		}

	public long getAcct(long acct) {
		return acct;
	}
	
	public long getOrder(long order) {
		return order;
	}
	
	public String getDates(String ordered, String deliv) {
		return "Ordered: " + ordered + "Due: " + deliv;
	}
	
	public String displayInfo(long acct, long order, String ordered, String due) {
		return acct + " " + order + " " + ordered + " " + due;
	}
		
}
