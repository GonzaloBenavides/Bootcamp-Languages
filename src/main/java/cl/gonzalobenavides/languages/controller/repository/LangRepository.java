package cl.gonzalobenavides.languages.controller.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.gonzalobenavides.languages.model.Language;

@Repository
public interface LangRepository extends CrudRepository<Language, Long>{

	List<Language> findAll();
}
