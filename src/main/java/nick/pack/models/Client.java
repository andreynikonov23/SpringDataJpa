package nick.pack.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "first_name")
	private String firstName;
	@Column (name = "last_name")
	private String lastName;
	private String phone;
	private String email;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "bank_account")
	private BankAccount bankAccount;
	
	
	public Client(int id, String firstName, String lastName, String phone, String email, BankAccount bankAccount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.bankAccount = bankAccount;
	}
	public Client() {
		
	}
	
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
