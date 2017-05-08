package co.simplon.diariesdao;

import org.springframework.data.repository.CrudRepository;

import co.simplon.diaries.Question;

public interface QuestionDao extends CrudRepository<Question, Long> {

}
