package nick.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nick.pack.models.Worker;
import nick.pack.service.dao.DAO;
import nick.pack.repository.WorkerRepository;

@Service
public class WorkerService implements DAO<Worker, Integer> {
	@Autowired
	public WorkerRepository workerRepository;

	public void insert(Worker entity) {
		// TODO Auto-generated method stub
		workerRepository.saveAndFlush(entity);
	}

	public void update(Worker entity) {
		// TODO Auto-generated method stub
		workerRepository.saveAndFlush(entity);
	}

	public void delete(Worker entity) {
		// TODO Auto-generated method stub
		workerRepository.delete(entity);
	}

	public Worker findById(Integer id) {
		// TODO Auto-generated method stub
		Object obj = workerRepository.findById(id);
		Worker worker = (Worker) obj;
		return worker;
	}

	public List<Worker> selectAll() {
		// TODO Auto-generated method stub
		return workerRepository.findAll();
	}
	
	
}
