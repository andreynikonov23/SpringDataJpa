package nick.pack.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Bank {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Worker worker;
	@ManyToOne (fetch = FetchType.EAGER)
	private Client client;
	
	
	public Bank(int id, Worker worker, Client client) {
		super();
		this.id = id;
		this.worker = worker;
		this.client = client;
	}
	public Bank() {
		
	}
	
	
	@Override
	public String toString() {
		return name;
	}
}
