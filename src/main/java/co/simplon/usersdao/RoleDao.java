package co.simplon.usersdao;

import org.springframework.data.repository.CrudRepository;

import co.simplon.users.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
	
	
}
