package org.redhat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import org.redhat.model.Order;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PaymentClient {
	
	private static final String POST_ADDRESS = "http://localhost:8080/paymentService/Orders/Order";
	private static final String GET_ORDERS_ADDRESS = "http://localhost:8080/paymentService/Orders";
	private static final String GET_ORDER_ADDRESS = "http://localhost:8080/paymentService/Orders/";

	public String postPaymentOrder(Order order){
		Client client = Client.create();
		WebResource webResource = client.resource(POST_ADDRESS);
		//Create xml file	
		String input = getXml(order);
		ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, input);
		System.out.println("Output from Server .... \n");
		String output = clientResponse.getEntity(String.class);
		System.out.println(output);
		return output;
	}

	private String getXml(Order order) {
		String xml = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(order, stringWriter);
			xml = stringWriter.toString();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}
	

}
