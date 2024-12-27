package POJO_with_ParameterizedConstructor;

public class Transaction {
    private String id;
    private double amount;
    private String currency;
    private String timestamp;
    private String status;
    private Details details;
	public Transaction(String id, double amount, String currency, String timestamp, String status, Details details) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.timestamp = timestamp;
		this.status = status;
		this.details = details;
	}

    }

