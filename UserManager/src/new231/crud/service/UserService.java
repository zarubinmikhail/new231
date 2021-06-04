package new231.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import new231.crud.model.User;
import new231.crud.model.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User get(Long id) {
		Optional<User> user = repo.findById(id);
		return user.get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<User> search(String keyword){
		return repo.search(keyword);
	}
}
