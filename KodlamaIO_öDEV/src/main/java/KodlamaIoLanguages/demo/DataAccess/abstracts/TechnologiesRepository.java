package KodlamaIoLanguages.demo.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIoLanguages.demo.entities.concretes.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies,Integer>{
	
	

}
