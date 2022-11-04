package nick.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nick.pack.models.BankAccount;
import nick.pack.service.dao.DAO;
import nick.pack.repository.BankAccountRepository;

@Service
public class BankAccountService implements DAO<BankAccount, Integer> {
		@Autowired
		private BankAccountRepository bankAccountRepository;
		
	
		public void insert(BankAccount entity) {
			// TODO Auto-generated method stub
			bankAccountRepository.saveAndFlush(entity);
		}
	
		public void update(BankAccount entity) {
			// TODO Auto-generated method stub
			bankAccountRepository.saveAndFlush(entity);
		}
	
		public void delete(BankAccount entity) {
			// TODO Auto-generated method stub
			bankAccountRepository.delete(entity);
		}
	
		public BankAccount findById(Integer id) {
			// TODO Auto-generated method stub
			Object obj = bankAccountRepository.findById(id);
			BankAccount bankAccount = (BankAccount) obj;
			return bankAccount;
		}
	
		public List<BankAccount> selectAll() {
			// TODO Auto-generated method stub
			return bankAccountRepository.findAll();
		}
}
