package co.simplon.userscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.users.Role;
import co.simplon.usersdao.RoleDao;
import co.simplon.usersservice.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	RoleDao dao;
	
	//Permet de recuperer tous les roles(mockup3)
	@GetMapping
	private List<Role> getRoles() {
		return roleService.findAll();
	}

}
