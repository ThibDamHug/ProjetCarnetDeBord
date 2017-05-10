package co.simplon.diariescontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	@GetMapping
	public List<Promo> getAllPromo() {
		return promoservice.getAllPromo();
	}
	
	//@PreAuthorize("has_role('ROLE_administrateur')")
	@PostMapping
	public void create(@RequestBody Promo promo) {
	    promoservice.save(promo);
	  }
	
	@PutMapping
	public void update(@RequestBody Promo promo) {
		promoservice.save(promo);
	}

}
