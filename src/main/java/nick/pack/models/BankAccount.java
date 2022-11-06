package nick.pack.models;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "bank_account")
public class BankAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String currency;
	private double amount;
	@Column(name = "amount_of_credit")
	private double amountOfCredit;
	@OneToMany (mappedBy = "bankAccount")
	Set<Client> clients;
	
	public BankAccount(int id, String currency, int amount, int amountOfCredit) {
		super();
		this.id = id;
		this.currency = currency;
		this.amount = amount;
		this.amountOfCredit = amountOfCredit;
	}
	public BankAccount() {
		
	}
	public BankAccount(String currency, double amount, double amountOfCredit) {
		super();
		this.currency = currency;
		this.amount = amount;
		this.amountOfCredit = amountOfCredit;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmountOfCredit() {
		return amountOfCredit;
	}
	public void setAmountOfCredit(double amountOfCredit) {
		this.amountOfCredit = amountOfCredit;
	}
	@Override
	public String toString() {
		return String.format("id=%d, currency=%s, amount=%d, amount of credit=%d", id, currency, amount, amountOfCredit);
	}
}
