package co.simplon.diariesservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.diaries.Question;
import co.simplon.diariesdao.QuestionDao;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public void saveQuestionsList (List<Question> questionsList) {
		for (Question question: questionsList) {
			questionDao.save(question);
		}
		
	}

	  /////////////////////////////////////// Methodes Privés ///////////////////////////////////////////
	
	public List <Question> QuestionsList (List<Question> questionsList) {
		List <Question> QuestionsListFinal = new ArrayList<Question>();
		for (Question question : questionsList) {
		Question questionFinal = new Question();
		questionFinal.setId(question.getId());
		questionFinal.setContent(question.getContent());
		questionFinal.setRole(question.getRole());
		QuestionsListFinal.add(questionFinal);
		}
		return QuestionsListFinal;
	}

}
