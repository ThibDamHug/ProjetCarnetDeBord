package co.simplon.diariesservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Diary;
import co.simplon.diariesdao.DiaryDao;

@Service
public class DiaryService {
	
	@Autowired
	DiaryDao diaryDao;
	
	public void save (Diary diary) {
		diaryDao.save(diary);
	}

	public List <Diary>  getDiaries(int roleId, int promoId) {
		List <Diary> listDiaries = new ArrayList<Diary>();
		return listDiaries;
	}}
