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

	public List <Diary>  getDiaries(int promoId) {
		List <Diary> listDiariesTemp = diaryDao.findAllByPromoId(promoId);
		List <Diary> listDiaries = new ArrayList<Diary>();
		for (Diary diaryTemp :listDiariesTemp) {
			if (!diaryTemp.getQuestions().isEmpty()) {
				Diary diaryFinal = new Diary();
				diaryFinal.setId(diaryTemp.getId());
				diaryFinal.setName(diaryTemp.getName());
				diaryFinal.setStartDate(diaryTemp.getStartDate());
				diaryFinal.setEndDate(diaryTemp.getEndDate());
				diaryFinal.setQuestions(questionService.setQuestion(diaryTemp.getQuestions()));
				listDiaries.add(diaryFinal);
			}
		}
		return listDiaries;
	}
	
}
