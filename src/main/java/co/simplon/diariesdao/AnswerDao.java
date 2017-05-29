package co.simplon.diariesdao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.simplon.diaries.Answer;

public interface AnswerDao extends CrudRepository<Answer, Long> {

	List<Answer> findAnswerByUserId(int studentId);

}
