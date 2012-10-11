package org.redhat.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;

@XmlRootElement
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5283503412734595299L;

	@NotNull
	int id;
	
	@NotNull
	private String parentName;
	
	@NotNull
	private String childName;
	
	@NotNull
	private String menu;
	
	@NotNull
	private double price;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
