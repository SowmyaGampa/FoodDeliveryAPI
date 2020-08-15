package com.food.delivery.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "userid")
	private String userid;

	private String orderStatus;

	@OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private List<Item> items = new ArrayList<>();

	@OneToMany(fetch = FetchType.EAGER, targetEntity = DeliveryInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<DeliveryInfo> deliveryInfo;

	@Column(name = "totalcost")
	private double totalcost;

	@Column(name = "note")
	private String note;

	@Column(name = "creation_time")
	private LocalDate creationTime;

	@Column(name = "last_modify_time")
	private LocalDate lastModifyTime;


	public Order() {

	}

	public Order(int id, String userid, String orderStatus, List<Item> items, List<DeliveryInfo> deliveryInfo,
			double totalcost, String note, LocalDate creationTime, LocalDate lastModifyTime) {
		super();
		this.id = id;
		this.userid = userid;
		this.orderStatus = orderStatus;
		this.items = items;
		this.deliveryInfo = deliveryInfo;
		this.totalcost = totalcost;
		this.note = note;
		this.creationTime = creationTime;
		this.lastModifyTime = lastModifyTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<DeliveryInfo> getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(List<DeliveryInfo> deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDate creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDate getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(LocalDate lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	private double calculateTotalCost(List<Item> items) {
		double cost = 0L;
		for (Item item : items) {
			cost += item.getPrice() * 100;
		}
		return cost / 100.0;
	}

}
