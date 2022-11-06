package nick.pack.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "worker_status")
	private String workStatus;
	private String phone;
	
	@OneToMany (mappedBy = "worker")
	Set<Bank> banks;
	
	
	public Worker(int id, String firstName, String lastName, String workStatus, String phone) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workStatus = workStatus;
		this.phone = phone;
	}
	public Worker() {
		
	}
	public Worker(String firstName, String lastName, String workStatus, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.workStatus = workStatus;
		this.phone = phone;
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
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return workStatus + ": " + firstName + " " + lastName;
	}
}
