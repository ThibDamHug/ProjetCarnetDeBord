package co.simplon.userdto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDto {

	private long id;
	
	private String firstname;
	
	private String lastname;
			
	private String email;
	
	private RoleDto roledto;
}
