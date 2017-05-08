package co.simplon.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.simplon.users.Role;
import co.simplon.usersservice.UserService;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	UserService service;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService());
	}
	
	@Bean
	UserDetailsService userDetailsService(){
		return new UserDetailsService() {
			
			//Besoin pour le ManytoMany en Lazy
			@Transactional
			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				co.simplon.users.User account = service.findbyEmail(email);
				if(account != null) {
					return new User(account.getPassword(), account.getPassword(), true, true, true, true,
							getAuthorities(account.getRole()));
				} else {
					throw new UsernameNotFoundException ("Impossible de trouver le compte :"+ email +".");
				}
			}
		};
	}
	
	//Creation d'un collection d'autorisation a partir d'une liste de role
	public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		String ROLE_PREFIX = "ROLE_";
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()));
        return list;
    }
}
