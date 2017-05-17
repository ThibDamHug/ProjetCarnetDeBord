package co.simplon.usersservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Promo;
import co.simplon.diariesservice.PromoService;
import co.simplon.users.User;
import co.simplon.usersdao.UserDao;

@Service
public class UserService {

	//Cree automatique l'instance et/ou la classe demandé si necessaire
	@Autowired 
	private UserDao userDao;
	
	@Autowired
	private PromoService promoService;
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public void save (User user) {
		userDao.save(user);
	}
	
	public List<User> findAll () {
		List <User> accountList = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans UserDao
		Iterable <User> findAll = userDao.findAll();
		for (User userTemp: findAll) {
			User user = new User();
			user.setId(userTemp.getId());
			user.setFirstname(userTemp.getFirstname());
			user.setLastname(userTemp.getLastname());
			user.setEmail(userTemp.getEmail());
			user.setRole(userTemp.getRole());
			if (userTemp.getPromo() != null) {
			user.setPromo(promoService.setFinalPromo(userTemp.getPromo()));
			}
			if (userTemp.getPair() != null) {
			user.setPair(setFinalPair(userTemp.getPair()));
			}
			accountList.add(user);
		}
		return accountList;
	}
		
	  public User getConnect() {
		  User user = new User();
		  User userFinal = new User();
		  User userPair = new User();
		  Promo promoFinal = new Promo();
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String currentPrincipal = authentication.getName();
		  user = userDao.findByEmail(currentPrincipal);
		  
		  userFinal.setId(user.getId());
		  userFinal.setFirstname(user.getFirstname());
		  userFinal.setLastname(user.getLastname());
		  userFinal.setEmail(user.getEmail());
		  userFinal.setRole(user.getRole());
		  if (user.getPair() != null) {
			  userPair.setId(user.getPair().getId());
			  userPair.setFirstname(user.getPair().getFirstname());
			  if(user.getPair().getPromo() != null) {
				  promoFinal.setId(user.getPair().getPromo().getId());
				  promoFinal.setName(user.getPair().getPromo().getName());
				  userPair.setPromo(promoFinal);
			  }
			  userFinal.setPair(userPair);
		  }
		  if (user.getPromo() != null) {			  
			  userFinal.setPromo(promoService.setFinalPromo(user.getPromo()));
		  }
		  return userFinal;
	  }
	  
	  public List<User> getByRole (String string) {
		  Iterable <User> getByRoleTemp = userDao.findAllByRoleName(string);
		  List <User> getByRole = new ArrayList<User>();
		  for (User userTemp : getByRoleTemp) {
			  User user = new User ();
			  user.setId(userTemp.getId());
			  user.setFirstname(userTemp.getFirstname());
			  user.setLastname(userTemp.getLastname());
			  user.setEmail(userTemp.getEmail());
			  user.setRole(userTemp.getRole());
			  if (userTemp.getPromo() != null) {
				user.setPromo(promoService.setFinalPromo(userTemp.getPromo()));
				}
			  if (userTemp.getPair() != null) {
				user.setPair(setFinalPair(userTemp.getPair()));
				}
			  getByRole.add(user);
		  }
		  return getByRole;
	  }
	    
	  public void update(int id ,User user) {
		  User userFinal = userDao.findOne(id);
		  userFinal.setFirstname(user.getFirstname());
		  userFinal.setLastname(user.getLastname());
		  if (user.getPair() != null) {
			  userFinal.setPair(user.getPair());
		  }
		  userFinal.setPassword(user.getPassword());
		  if (user.getPromo() != null) {
			  userFinal.setPromo(user.getPromo());
		  }
		  userFinal.setRole(user.getRole());
		  userDao.save(userFinal);
	  }
	  
	  
	  private User setFinalPair (User pair) {
			User userFinal = new User();
			userFinal.setId(pair.getId());
			userFinal.setFirstname(pair.getFirstname());
			userFinal.setPromo(promoService.setFinalPromo(pair.getPromo()));
			return userFinal;
	  }
	  
}