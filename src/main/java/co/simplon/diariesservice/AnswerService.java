package co.simplon.diariesservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Answer;
import co.simplon.diariesdao.AnswerDao;

@Service
public class AnswerService {
	
	@Autowired
	AnswerDao answerDao;

	public List<Answer> getAnswersList(int studentId, int diaryId) {
		Iterable <Answer> AnswerList = answerDao.findAnswerByUserId(studentId);
		List <Answer> answersListFinal = new ArrayList<Answer>();
		List <Answer> answersListTemp = new ArrayList<Answer>();
		for (Answer answerTemp : AnswerList) {
			if(answerTemp.getQuestion().getDiary().getId() == diaryId) {
				answersListTemp.add(setFinalAnswer(answerTemp));
			}
			if(answersListTemp.size() == 10) {
				answersListFinal = answersListTemp;
			} 
		}
		return answersListFinal;
	}
	
	  /////////////////////////////////////// Methodes Privés ///////////////////////////////////////////

	public Answer setFinalAnswer(Answer answer) {
		Answer finalAnswer = new Answer();
		finalAnswer.setId(answer.getId());
		finalAnswer.setContent(answer.getContent());
		return finalAnswer;
	}
}
