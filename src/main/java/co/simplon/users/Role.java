package co.simplon.users;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import co.simplon.diaries.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity


public class Role {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	//Entité esclave lié par List <Role> roles
	//@JsonBackReference
	//@ManyToMany(mappedBy = "roles")
	
	//@OneToMany(mappedBy="role")
	//private List <User> users;
	
	@OneToMany(mappedBy="role")
	private List <Question> questions;
	

}