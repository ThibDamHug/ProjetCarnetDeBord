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
	private RoleDao dao;
		
	public List<Role> findAll() {
		List<Role> RoleList = new ArrayList<Role>(); 
		Iterable<Role> roles = dao.findAll();
		for ( Role role : roles) {
			RoleList.add(role);
		}
		return RoleList;
	}
	
	public Role findByName(String name) {
		return dao.findByName(name);
	}
	
	public Role save(Role role) {
		return dao.save(role);
	}
	
}