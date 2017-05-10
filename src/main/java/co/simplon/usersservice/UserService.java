package co.simplon.usersservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.users.User;
import co.simplon.usersdao.UserDao;

@Service
public class UserService {

	//Cree automatique l'instance et/ou la classe demandé si necessaire
	@Autowired 
	private UserDao dao;
	
	public List<User> findAll () {
		List <User> accountList = new ArrayList<>();
		Iterable <User> findall = dao.findAll();
		for (User account: findall) {
			accountList.add(account);
		}
		return accountList;
	}
		
	public User findbyEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public List<String> findAllNom() {
		List<String> resultat = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans UserDao
		Iterable<User> select = dao.findAll();
		for (User type : select) {
			User user = new User();
			user.setFirstname(type.getFirstname());
			resultat.add(user.getFirstname());
		}
		return resultat;
	}
	
	public void save(User user) {
		 dao.save(user);

	}
	
	  public User getConnect() {
		  User user = new User();
		  User userfinal = new User();
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String currentPrincipal = authentication.getName();
		  user = dao.findByEmail(currentPrincipal);
		  userfinal.setId(user.getId());
		  userfinal.setEmail(user.getEmail());
		  //userfinal.setRole(user.getRole());
		  userfinal.setPromo(user.getPromo());
		  return userfinal;
	}
}
