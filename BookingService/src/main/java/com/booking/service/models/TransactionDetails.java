package com.booking.service.models;

public class TransactionDetails {
	
	private int transactionID;

	public TransactionDetails() {
		super();
	}

	public TransactionDetails(int transactionID) {
		super();
		this.transactionID = transactionID;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionID=" + transactionID + "]";
	}
	
	
}
