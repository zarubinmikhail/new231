package new231.crud.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
	@Query(value = "SELECT u FROM User u WHERE u.name LIKE '%' || :keyword || '%'" + " OR u.email LIKE '%' || :keyword || '%'" +
			" OR u.address LIKE '%' || :keyword || '%'")
	public List<User> search(@Param("keyword") String keyword);
}
