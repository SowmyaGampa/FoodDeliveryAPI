package com.food.delivery.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="address")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addressid")
	private int addressid;
	
	@Column(name="address")
    private String address;
	
	@Column(name="city")
    private String city; 
	
	@Column(name="state")
    private String state;
	
	@Column(name="zipcode")
    private Integer zipcode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressid, String address, String city, String state, Integer zipcode) {
		super();
		this.addressid = addressid;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + "]";
	}
	

}
