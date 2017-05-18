package co.simplon.diariesdao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.simplon.diaries.Diary;

public interface DiaryDao extends CrudRepository<Diary, Long>{

	List<Diary> findAllByPromoId(int promoId);

}
