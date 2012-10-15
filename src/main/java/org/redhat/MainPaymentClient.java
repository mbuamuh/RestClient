package org.redhat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.redhat.model.Order;

public class MainPaymentClient {
	
	public static void main(String args[]) throws IOException{
		
		File inputFile = new File(args[0]);	
//		File inputFile = new File("/tmp/Order.xml");
		Order order = getOrderFromXml(inputFile );
		PaymentClient paymentClient = new PaymentClient();
		paymentClient.postPaymentOrder(order);
	}

	private static Order getOrderFromXml(File inputFile) {
	Order order = null;
	
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
       order = (Order) unmarshaller.unmarshal(inputFile);
	
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return order;
	}

}
