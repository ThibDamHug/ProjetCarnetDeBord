package co.simplon.diariesservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.diaries.Question;

@Service
public class QuestionService {
	
	public List <Question> setQuestion (List<Question> questionsList) {
		List <Question> listQuestionFinal = new ArrayList<Question>();
		for (Question question : questionsList) {
		Question questionFinal = new Question();
		questionFinal.setId(question.getId());
		questionFinal.setContent(question.getContent());
		questionFinal.setRole(question.getRole());
		listQuestionFinal.add(questionFinal);
		}
		return listQuestionFinal;
	}

}
