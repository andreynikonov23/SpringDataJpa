package nick.pack.models;


import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "bank_account")
public class BankAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String currency;
	private int amount;
	@Column(name = "amount_of_credit")
	private int amountOfCredit;
//	@OneToMany (mappedBy = "bankAccount")
	//Set<Client> clients;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id", nullable = false)
	private Client client;
	
	public BankAccount(int id, String currency, int amount, int amountOfCredit) {
		super();
		this.id = id;
		this.currency = currency;
		this.amount = amount;
		this.amountOfCredit = amountOfCredit;
	}
	public BankAccount() {
		
	}
	
	
	@Override
	public String toString() {
		return String.format("id=%d, currency=%s, amount=%d, amount of credit=%d", id, currency, amount, amountOfCredit);
	}
}
