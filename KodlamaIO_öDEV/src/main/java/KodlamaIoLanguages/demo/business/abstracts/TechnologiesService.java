package KodlamaIoLanguages.demo.business.abstracts;

import java.util.List;

import KodlamaIoLanguages.demo.business.requests.CreateTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.DeleteTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.ListedTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.UpdateTechnologiesRequest;
import KodlamaIoLanguages.demo.business.responses.GetAllLanguagesTechnologiesResponse;

public interface TechnologiesService {
	
	List<GetAllLanguagesTechnologiesResponse> getAll();
	
	void add(CreateTechnologiesRequest createLanguagesRequest) throws Exception;
	
	void update(UpdateTechnologiesRequest updateLanguagesTechnologiesRequest, int id) throws Exception;
	
	void delete(DeleteTechnologiesRequest deleteLanguagesTechnologiesRequest);
	
	

}
