package co.simplon.diaries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import co.simplon.users.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Conclusion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String content;
	
	@ManyToOne
	private Diary diary;
	
	@ManyToOne
	private User user;

}
