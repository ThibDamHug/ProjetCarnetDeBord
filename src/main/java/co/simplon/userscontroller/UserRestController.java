package co.simplon.userscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.userdto.UserDto;
import co.simplon.users.User;
import co.simplon.usersservice.UserService;

@RestController
@RequestMapping("/users")
//@PreAuthorize("hasRole('ROLE_apprenant','ROLE_tuteur')")
public class UserRestController {     

	  @Autowired
	  
	  private UserService service;
	  
	  //@RequestMapping(method=RequestMethod.GET)
	  //@PreAuthorize("hasRole('ROLE_formateur')")
	  @GetMapping
	  public List<UserDto> getAll() {
		    return service.findAll();
		  }
	  
	  
	  @PostMapping
	  public void create(User user) {
	     service.save(user);
	  }

//	  
//	  @RequestMapping(method=RequestMethod.DELETE, value="{id}")
//	  public void delete(@PathVariable int id) {
//	    Dao.delete(id);
//	  }
//	  
//	  @RequestMapping(method=RequestMethod.PUT, value="{id}")
//	  public Account update(@PathVariable int id, @RequestBody Account contact) {
//	    Account update = Dao.findOne(id);
//	    update.setUsername(contact.getUsername());
//	    return Dao.save(update);
//	  }

}