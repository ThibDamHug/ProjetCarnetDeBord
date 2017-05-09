package co.simplon.userdto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RoleDto {
	
	private long id;
	
	private String name;

}
