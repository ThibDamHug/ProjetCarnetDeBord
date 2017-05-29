package co.simplon.usersservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Conclusion;
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
		List <User> usersList = new ArrayList<>();
		//La requete findAll n'est meme pas a specifier dans UserDao
		Iterable <User> findAll = userDao.findAll();
		for (User userTemp: findAll) {
			usersList.add(setFinalUser(userTemp));
		}
		return usersList;
	}
		
	  public User getConnect() {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String currentPrincipal = authentication.getName();
		  User user = userDao.findByEmail(currentPrincipal);
		  User userFinal = setFinalUser(user);
		  return userFinal;
	  }
	  
	  public List<User> userListgetByRole (String string) {
		  Iterable <User> getByRoleTemp = userDao.findAllByRoleName(string);
		  List <User> getByRole = new ArrayList<User>();
		  for (User userTemp : getByRoleTemp) {
			  getByRole.add(setFinalUser(userTemp));
		  }
		  return getByRole;
	  }
	  
		public List<User> getUserListWithoutConclusion(int diaryId,int promoId) {
			Iterable <User> getAllFromAPromo = userDao.findAllByPromoId(promoId); 
			List <User> getWithoutConclusion = new ArrayList<User>();
			for (User userTemp : getAllFromAPromo){
						if (!userTemp.getConclusionsList().isEmpty()) {
							List<Conclusion> conclusionListTemp = userTemp.getConclusionsList();				
							List<Conclusion> conclusionListTemp2 = new ArrayList<Conclusion>();
							for (Conclusion conclusionTemp : conclusionListTemp) {
								if (conclusionTemp.getDiary().getId() == diaryId) {
									conclusionListTemp2.add(conclusionTemp);
								}
							}
							if (conclusionListTemp2.isEmpty()){
								getWithoutConclusion.add(setFinalUser(userTemp));
							}
						}
			}
		return getWithoutConclusion;
		}
	    
	  public void update(int id ,User user) {
		  User userFinal = userDao.findOne(id);
		  userFinal = setFinalUser(user);
		  userDao.save(userFinal);
	  }
	  
	  /////////////////////////////////////// Methodes Privés ///////////////////////////////////////////
	  
	  private User setFinalPair (User pair) {
			User userFinal = new User();
			userFinal.setId(pair.getId());
			userFinal.setFirstname(pair.getFirstname());
			userFinal.setPromo(promoService.setFinalPromo(pair.getPromo()));
			return userFinal;
	  }

	  private User setFinalUser (User user) {
			User userFinal = new User();
			userFinal.setId(user.getId());
			userFinal.setFirstname(user.getFirstname());
			userFinal.setLastname(user.getLastname());
			userFinal.setPassword(user.getPassword());
			userFinal.setEmail(user.getEmail());
			userFinal.setRole(user.getRole());
			if (user.getPromo() != null) {
				userFinal.setPromo(promoService.setFinalPromo(user.getPromo()));
			}
			if (user.getPair() != null) {
				userFinal.setPair(setFinalPair(user.getPair()));
				}
			return userFinal;
	  }
	  
}