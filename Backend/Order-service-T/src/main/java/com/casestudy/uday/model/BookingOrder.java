package com.casestudy.uday.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Orders")
public class BookingOrder {



	@Id
	private String id;
	private String source;
	private String destination;
	private String nooftickets;

	public BookingOrder() {

	}

	public BookingOrder(String id, String source, String destination, String nooftickets) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.nooftickets = nooftickets;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNooftickets() {
		return nooftickets;
	}

	public void setNooftickets(String nooftickets) {
		this.nooftickets = nooftickets;
	}

	@Override
	public String toString() {
		return "BookingOrder{" +
				"id='" + id + '\'' +
				", source='" + source + '\'' +
				", destination='" + destination + '\'' +
				", nooftickets='" + nooftickets + '\'' +
				'}';
	}
}