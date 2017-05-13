package co.simplon.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import co.simplon.diaries.Promo;
import lombok.Getter;
import lombok.Setter;

//Lombok pour creer auto les getter/setter
@Getter
@Setter
//Dit a hibernate que ca correspond a une table
@Entity
//@Table ( si nom different de table name ="" )
//Evite de boucler à l'infini dans manyTomany
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	
	//Cle primaire
	@Id
	//Previent que la cle est genere  automatiquement
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String firstname;
	
	private String lastname;
		
	private String password;
	
	private String email;
	
	@OneToOne
	private User pair;
	
	@ManyToOne
	private Promo promo;
	
// Methode utile pour integrer la derniere maj	
// @UpdateTimestamp
// private Timestamp derniereMaj;
	
	//Entité Maitre
	
//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//	//name = table de joiture;type_id = foreign key de la table actuelle; role_id = fk de la table opposé
//	@JoinTable(name="utilisateur_role", joinColumns = {
//			@JoinColumn(name = "utilisateur_id")},inverseJoinColumns = {@JoinColumn(name ="role_id")
//			})
//	@JsonManagedReference
//	private List <Role> roles ;
	
	@ManyToOne
	private Role role;
	
//	@OneToMany(mappedBy="user")
//	private List<Answer> answers;

//	@OneToMany(mappedBy="user")
//	private List<Conclusion> conclusions;
}
