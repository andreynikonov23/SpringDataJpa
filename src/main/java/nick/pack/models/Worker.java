package nick.pack.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column(name = "work_status")
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
	
	
	@Override
	public String toString() {
		return workStatus + ": " + firstName + " " + lastName;
	}
}
