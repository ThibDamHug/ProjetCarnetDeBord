package co.simplon.usersservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.users.Role;
import co.simplon.usersdao.RoleDao;

@Service
public class RoleService {
	
	@Autowired 
	private RoleDao roleDao;
		
	public List<Role> findAll() {
		List<Role> rolesList = new ArrayList<Role>(); 
		Iterable<Role> roles = roleDao.findAll();
		for ( Role role : roles) {
			rolesList.add(role);
		}
		return rolesList;
	}
		
}