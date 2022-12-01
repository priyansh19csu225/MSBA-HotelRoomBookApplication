package com.booking.service.models;


public class CancellationDetails {

	private String message;
	

	public CancellationDetails() {
		super();
	}

	public CancellationDetails(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "CancellationDetails [message=" + message +" ]";
	}
	

}
