package co.simplon.usersservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.userdto.UserDto;
import co.simplon.users.User;
import co.simplon.usersdao.UserDao;

@Service
public class UserService {

	@Autowired 
	
	private UserDao dao;
	
	public List<UserDto> findAll () {
		List <UserDto> accountList = new ArrayList<>();
		Iterable <User> findall = dao.findAll();
		RoleService roleservice = new RoleService();
		for (User account2: findall) {
			UserDto account= new UserDto();
				account.setId(account2.getId());
				account.setFirstname(account2.getFirstname());
				account.setLastname(account2.getLastname());
				account.setEmail(account2.getEmail());
				account.setRoledto(roleservice.descripRole(account2.getRole()));
				accountList.add(account);
		}
		return accountList;
	}
		
	public User findbyEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public List<String> findAllNom() {
		List<String> resultat = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans TypeDao
		Iterable<User> select = dao.findAll();
		for (User type : select) {
			User user = new User();
			user.setFirstname(type.getFirstname());
			resultat.add(user.getFirstname());
		}
		return resultat;
	}
	
	public User save(User user) {
		return dao.save(user);

	}
}
