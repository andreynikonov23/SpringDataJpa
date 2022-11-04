package nick.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nick.pack.models.Client;
import nick.pack.service.dao.DAO;
import nick.pack.repository.ClientRepository;

@Service
public class ClientService implements DAO<Client, Integer> {
	@Autowired
	public ClientRepository clientRepository;

	public void insert(Client entity) {
		// TODO Auto-generated method stub
		clientRepository.saveAndFlush(entity);
	}

	public void update(Client entity) {
		// TODO Auto-generated method stub
		clientRepository.saveAndFlush(entity);
	}

	public void delete(Client entity) {
		// TODO Auto-generated method stub
		clientRepository.saveAndFlush(entity);
	}

	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		Object obj = clientRepository.findById(id);
		Client client = (Client) obj;
		return client;
	}

	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}
	
}
