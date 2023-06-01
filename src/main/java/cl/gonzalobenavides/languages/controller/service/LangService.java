package cl.gonzalobenavides.languages.controller.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gonzalobenavides.languages.controller.repository.LangRepository;
import cl.gonzalobenavides.languages.model.Language;

@Service
public class LangService {

	@Autowired
	LangRepository repo;
	
	public Language findById(Long id) {
		Optional<Language> lang = repo.findById(id);
		
		if(lang.isPresent())
			return lang.get();
		else 
			throw new NoSuchElementException();
	}
	
	public List<Language> findAllLanguages(){
		return repo.findAll();
	}
	
	public void saveLanguage(Language newLang) {
		repo.save(newLang);
	}
	
	public void deleteLanguage(Language newLang) {
		repo.delete(newLang);
	}
	
}
