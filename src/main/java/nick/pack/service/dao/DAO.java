package nick.pack.service.dao;

import java.util.List;

public interface DAO<Entity, ID> {
	void insert(Entity entity);
	void update(Entity entity);
	void delete(Entity entity);
	Entity findById(ID id);
	List<Entity> selectAll();
}
