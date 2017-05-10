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
	PromoDao dao;
	
	public List<Promo> getAllPromo() {
		Iterable<Promo> promos = dao.findAll();
		List<Promo> listPromo = new ArrayList<Promo>();
		for (Promo promo : promos) {
			listPromo.add(promo);
		}
		return listPromo;
	}
	
	public void save(Promo promo) {
		 dao.save(promo);
	}
	
	public void update(Promo promo) {
	Promo promofinal = dao.findOne(promo.getId());
	promofinal.setName(promo.getName());
	promofinal.setStartDate(promo.getStartDate());
	promofinal.setEndDate(promo.getEndDate());
	dao.save(promofinal);
	}
}
