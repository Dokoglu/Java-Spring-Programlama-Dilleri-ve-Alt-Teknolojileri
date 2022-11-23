package KodlamaIoLanguages.demo.DataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIoLanguages.demo.entities.concretes.Languages;

public interface LanguageRepository extends JpaRepository<Languages,Integer> {
	
	

}
