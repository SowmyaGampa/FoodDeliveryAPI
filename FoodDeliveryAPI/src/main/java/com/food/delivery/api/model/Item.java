package com.food.delivery.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemid")
	private int itemid;
	
	@Column(name="itemname")
	private String itemname;
	
	@Column(name="quantity")
    private int quantity;
	
	@Column(name="price")
    private double price; 			// price is quantity * unitPrice

	public Item() {

	}

	public Item(int itemid, String itemname, int quantity, double price) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.quantity = quantity;
		this.price = price;
	}





	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	

}
