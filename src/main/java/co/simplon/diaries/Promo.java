package co.simplon.diaries;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import co.simplon.users.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Promo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Name can't empty!")
	private String name;
	
	@NotBlank(message = "Name can't empty!")
	private Date startDate;
	
	@NotBlank(message = "Name can't empty!")
	private Date endDate;
	
	@OneToMany(mappedBy = "promo")
	private List <User> users;
	
	@OneToMany(mappedBy = "promo")
	private List <Diary> diaries;

}
