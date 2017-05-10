package co.simplon.diaries;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diary {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		private String name;
		
		private Date startDate;
		
		private Date endDate;
		
		private String introduction;
				
		@ManyToOne
		private Promo promo;
				
		@OneToMany(mappedBy = "diary")
		private List <Conclusion> conclusions;
		
		@OneToMany(mappedBy = "diary")
		private List <Question> questions;
}
