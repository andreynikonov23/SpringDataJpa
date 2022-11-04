package nick.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nick.pack.models.Bank;
import nick.pack.service.dao.DAO;
import nick.pack.repository.BankRepository;

@Service
public class BankService implements DAO<Bank, Integer> {
	@Autowired
	private BankRepository bankRepository;

	public void insert(Bank entity) {
		// TODO Auto-generated method stub
		bankRepository.saveAndFlush(entity);
	}

	public void update(Bank entity) {
		// TODO Auto-generated method stub
		bankRepository.saveAndFlush(entity);
	}

	public void delete(Bank entity) {
		// TODO Auto-generated method stub
		bankRepository.delete(entity);
	}

	public Bank findById(Integer id) {
		// TODO Auto-generated method stub
		Object obj = bankRepository.findById(id);
		Bank bank =(Bank) obj;
		return bank;
	}

	public List<Bank> selectAll() {
		// TODO Auto-generated method stub
		return bankRepository.findAll();
	}
	
	public Bank findByName(String name) {
		return bankRepository.findByName(name);
	}

}
