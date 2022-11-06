package nick.pack.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
public class Bank {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "worker")
	private Worker worker;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "client")
	private Client client;
	
	
	public Bank(int id, Worker worker, Client client) {
		super();
		this.id = id;
		this.worker = worker;
		this.client = client;
	}
	public Bank() {
		
	}
	public Bank(String name, Worker worker, Client client) {
		super();
		this.name = name;
		this.worker = worker;
		this.client = client;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return String.format("%s: worker (%s); client (%s)", name, worker, client);
	}
}
