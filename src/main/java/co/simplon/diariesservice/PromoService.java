package co.simplon.diariesservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Promo;
import co.simplon.diariesdao.PromoDao;
import co.simplon.diariesdto.PromoDto;

@Service
public class PromoService {
	
	@Autowired
	PromoDao dao;
	
	public List<PromoDto> getAllPromo() {
		Iterable<Promo> promos = dao.findAll();
		List<PromoDto> listPromo = new ArrayList<PromoDto>();
		for (Promo promo : promos) {
			PromoDto dto = new PromoDto();
			dto.setId(promo.getId());
			dto.setName(promo.getName());
			dto.setStartDate(promo.getStartDate());
			dto.setEndDate(promo.getEndDate());
			listPromo.add(dto);
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
