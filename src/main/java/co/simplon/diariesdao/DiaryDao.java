package co.simplon.diariesdao;

import org.springframework.data.repository.CrudRepository;

import co.simplon.diaries.Diary;

public interface DiaryDao extends CrudRepository<Diary, Long>{

}
