package co.simplon.userscontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.users.User;
import co.simplon.usersservice.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {     

	  @Autowired
	  
	  private UserService service;
	   
	  //Permet de recuperer les utilisateurs en fonction des roles(mockup 4 et 5)
	  //@RequestMapping(method=RequestMethod.GET)
	  @PreAuthorize("hasRole('ROLE_administrateur')")  
	  @GetMapping
	  public List<User> getRoleFonction (@RequestParam Optional<String> role) {
		  if (role.isPresent()) {
			  return service.getByRole(role.get()); 
		  }
		  
		  else {
			  return service.findAll();
		  }
	  }
	  
	  //Permet de creer un utilisateur (mockup3)
	  @PreAuthorize("hasRole('ROLE_administrateur')")
	  @PostMapping
	  public void create(@RequestBody User user) {
	     service.save(user);
	  }
	  
	  //Permet de modifier un utilisateur (mockup4 et 8)
	  @PreAuthorize("hasRole('ROLE_administrateur')")
	  @PutMapping("/{id}")
	  public void update(@PathVariable int id, @RequestBody User user) {
	     service.update(id, user);
	  }
	  
	  //Permet de recuperer l'utilisateur connecte (mockup1)
	  @GetMapping("/connected")
	  public User connected() {
		  return service.getConnect();
	  }
	  
}