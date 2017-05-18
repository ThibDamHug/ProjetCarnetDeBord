package co.simplon.diariescontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.diaries.Diary;
import co.simplon.diariesservice.DiaryService;

@RestController
@RequestMapping("/diary")
public class DiaryRestController {
	
	@Autowired
	DiaryService diaryService;
	
	@GetMapping
	public List <Diary> listDiaries (@RequestParam Optional<Integer> roleId, Optional<Integer> promoId) {
		return diaryService.getDiaries (promoId.get());
	}
	
	//Permet de creer un carnet (mockup10)
	@PreAuthorize("has_role('ROLE_formateur')")
	@PostMapping
	public void create(@RequestBody Diary diary) {
	    diaryService.save(diary);
	  }


}
