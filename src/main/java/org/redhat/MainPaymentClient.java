package org.redhat;

import org.redhat.model.Order;

public class MainPaymentClient {
	
	public static void main(String args[]){
		
		PaymentClient paymentClient = new PaymentClient();
		// To do: create an xml or csv file to read all the orders from and instead of declaring them manually in the main class
		Order order1 = new Order();
		order1.setChildName("Thomas");
		order1.setId(1);
		order1.setMenu("menu2");
		order1.setParentName("Chris");
		order1.setPrice(30.0);
		
		Order order2 = new Order();
		order2.setChildName("Peter");
		order2.setId(2);
		order2.setMenu("menu3");
		order2.setParentName("Fred");
		order2.setPrice(50.5);
		
		Order order3 = new Order();
		order3.setChildName("Steve");
		order3.setId(3);
		order3.setParentName("Jackson");
		order3.setMenu("menu4");
		order3.setPrice(23.5);
		
		paymentClient.postPaymentOrder(order1);
		paymentClient.postPaymentOrder(order2);
		paymentClient.postPaymentOrder(order3);
		
	
	}

}
