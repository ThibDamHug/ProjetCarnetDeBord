package co.simplon.diariesservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Promo;
import co.simplon.diariesdao.PromoDao;

@Service
public class PromoService {
	
	@Autowired
	PromoDao promoDao;
	
	public List<Promo> getAllPromo() {
		Iterable<Promo> promos = promoDao.findAll();
		List<Promo> listPromo = new ArrayList<Promo>();
		for (Promo promo : promos) {
			listPromo.add(promo);
		}
		return listPromo;
	}
	
	public void save(Promo promo) {
		 promoDao.save(promo);
	}
	
	public void update(int id ,Promo promo) {
	Promo promoFinal = promoDao.findOne(id);
	promoFinal.setName(promo.getName());
	promoFinal.setStartDate(promo.getStartDate());
	promoFinal.setEndDate(promo.getEndDate());
	promoDao.save(promoFinal);
	}

// Permet de nettoyer les promos dans les autres méthodes
	public Promo setFinalPromo(Promo promo) {
		Promo finalPromo = new Promo();
		finalPromo.setId(promo.getId());
		finalPromo.setName(promo.getName());
		return finalPromo;
	}
}
