package nick.pack.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@OneToMany(mappedBy = "client")
	Set<Bank> banks;
	
	
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
	public Client(String firstName, String lastName, String phone, String email, BankAccount bankAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.bankAccount = bankAccount;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
