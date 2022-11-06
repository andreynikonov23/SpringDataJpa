package nick.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nick.pack.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
//	@Query("SELECT * FROM bank WHERE name = :name")
//	Bank findByName(@Param("name") String name);
	@Query("select b from Bank b where b.name = :name")
    Bank findByName(@Param("name") String name);
}
