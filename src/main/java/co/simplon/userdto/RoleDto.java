package co.simplon.userdto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RoleDto {
	
	private long id;
	
	private String name;

}
