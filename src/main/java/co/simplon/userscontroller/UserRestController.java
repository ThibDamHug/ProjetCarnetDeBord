package co.simplon.userscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.users.User;
import co.simplon.usersdao.UserDao;
import co.simplon.usersservice.UserService;

@RestController
//@RequestMapping("/users")
//@PreAuthorize("hasRole('ROLE_apprenant','ROLE_tuteur')")
public class UserRestController {     

	  @Autowired
	  
	  private UserService service;
	  
		@Autowired 
		private UserDao dao;
	  
	  //@RequestMapping(method=RequestMethod.GET)
	  //@PreAuthorize("hasRole('ROLE_formateur')")
	  @GetMapping("/users")
	  public List<User> getAll() {
		    return service.findAll();
		  }
	  
	  @GetMapping("/connected")
	  public User connected() {
		  return service.getConnect();
  }
	  
	  @PostMapping("/users")
	  public void create(User user) {
	     service.save(user);
	  }

//	  
//	  @RequestMapping(method=RequestMethod.DELETE, value="{id}")
//	  public void delete(@PathVariable int id) {
//	    Dao.delete(id);
//	  }
//	  
	  @RequestMapping(method=RequestMethod.PUT, value="{id}")
	  public User update(@PathVariable Long id, @RequestBody User contact) {
	    User update = dao.findOne(id);
	    update.setFirstname(contact.getFirstname());
	    return dao.save(update);
	  }
}