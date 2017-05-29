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
	
	@Autowired
	QuestionService questionService;
	
	public void save (Diary diary) {
		diaryDao.save(diary);
	}
	
	public List <Diary> getDiariesWithoutQuestions (int promoId) {
		List <Diary> listDiariesTemp = diaryDao.findAllByPromoId(promoId);
		List <Diary> listDiaries = new ArrayList<Diary>();
		for (Diary diaryTemp :listDiariesTemp) {
			if (diaryTemp.getQuestions().isEmpty()) {
				listDiaries.add(setFinalDiary(diaryTemp));
			}
		}
		return listDiaries;
	}

	public List <Diary>  getDiariesWithQuestions(int promoId) {
		List <Diary> listDiariesTemp = diaryDao.findAllByPromoId(promoId);
		List <Diary> listDiaries = new ArrayList<Diary>();
		for (Diary diaryTemp :listDiariesTemp) {
			if (!diaryTemp.getQuestions().isEmpty()) {
				listDiaries.add(setFinalDiary(diaryTemp));
			}
		}
		return listDiaries;
	}
	
	
	  /////////////////////////////////////// Methodes Privés ///////////////////////////////////////////

	private Diary setFinalDiary(Diary diary) {
		Diary diaryFinal = new Diary();
		diaryFinal.setId(diary.getId());
		diaryFinal.setName(diary.getName());
		diaryFinal.setStartDate(diary.getStartDate());
		diaryFinal.setEndDate(diary.getEndDate());
		diaryFinal.setQuestions(questionService.QuestionsList(diary.getQuestions()));
		return diaryFinal;
	}
}
