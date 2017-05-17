package co.simplon.diariescontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.diaries.Promo;
import co.simplon.diariesservice.PromoService;

@RestController
@RequestMapping("/promos")
public class PromoRestController {
	
	@Autowired
	PromoService promoservice;

	//Permet de recuperer toutes les promos(mockup 5)
	@GetMapping
	public List<Promo> getAllPromo() {
		return promoservice.getAllPromo();
	}
	
	//Permet de creer une promo (mockup3)
	@PreAuthorize("has_role('ROLE_administrateur')")
	@PostMapping
	public void create(@RequestBody Promo promo) {
	    promoservice.save(promo);
	  }
	
	//Permet de modifier une promo(mockup 7)
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Promo promo) {
		promoservice.update(id, promo);
	}

}
