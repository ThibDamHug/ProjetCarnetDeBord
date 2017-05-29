package co.simplon.diariescontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.diaries.Answer;
import co.simplon.diariesservice.AnswerService;

@RestController
@RequestMapping("/answers")
public class AnswerRestController {
	
	@Autowired
	private AnswerService answerService;
	
	//Permet de recuperer toutes les reponses pour rediger les conclusions(mockup 11)
	@GetMapping
	public List <Answer> AnswersList (@RequestParam Optional<Integer> studentId, @RequestParam Optional<Integer> diaryId) {
		return answerService.getAnswersList(studentId.get(), diaryId.get());
	}
}
