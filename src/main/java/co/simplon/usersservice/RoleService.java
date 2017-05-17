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
		List<Role> roleList = new ArrayList<Role>(); 
		Iterable<Role> roles = roleDao.findAll();
		for ( Role role : roles) {
			roleList.add(role);
		}
		return roleList;
	}
	
	public Role findByName(String name) {
		return roleDao.findByName(name);
	}
	
	public Role save(Role role) {
		return roleDao.save(role);
	}
	
}