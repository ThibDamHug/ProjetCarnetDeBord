package co.simplon.usersdao;

import org.springframework.data.repository.CrudRepository;

import co.simplon.users.User;

public interface UserDao extends CrudRepository<User, Integer> {
	
	public User findByEmail(String email);
	
	public Iterable<User> findAllByRoleName(String string);

	public User findOne(int id);

	
//	Permet de creer des methodes via Crud 
//	public Iterable<User> findByRoleId(long id);
//	public void deleteByPassword(String password);
	
//	Permet de creer des methodes non comprise par Hibernate
//	@Query("select `firstname` from `Utilisateur`")
//	public List<String> findfirstname();
	
}
