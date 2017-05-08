package co.simplon.userscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	  
//	  public Object details() {
//		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		  Object currentPrincipalName =  authentication.getDetails();
//		return currentPrincipalName;
//	  }
	  
//	  public List<Role> roles() {
//	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	  List<Role> currentPrincipalRoles =  authentication.getRoles();
//	  return currentPrincipalRoles;
//  }
	  
//	  public Collection<? extends GrantedAuthority> authorities() {
//		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		  Collection<? extends GrantedAuthority> currentPrincipalAuthorities =  authentication.getAuthorities();
//		  return currentPrincipalAuthorities;
//	  }
	  
//	  public String nom() {
//		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		  String currentPrincipalName = authentication.getName();
//		  return currentPrincipalName;
//	  }
//	  
//	  	  
	  @PostMapping
	  public User create(@RequestBody User user) {
	    return service.save(user);
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