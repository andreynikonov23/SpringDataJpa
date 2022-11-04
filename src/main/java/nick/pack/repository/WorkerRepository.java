package nick.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nick.pack.models.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
