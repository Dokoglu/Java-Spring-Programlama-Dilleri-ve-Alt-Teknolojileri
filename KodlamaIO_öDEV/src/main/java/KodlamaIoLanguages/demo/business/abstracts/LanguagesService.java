package KodlamaIoLanguages.demo.business.abstracts;

import java.util.List;

import KodlamaIoLanguages.demo.business.requests.CreateLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.DeleteLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.ListedLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.UpdateLanguagesRequest;
import KodlamaIoLanguages.demo.business.responses.GetAllProgrammingLanguagesResponse;

public interface LanguagesService {
	 
	List<GetAllProgrammingLanguagesResponse> getAll();
	
	void add(CreateLanguagesRequest createLanguagesRequest) throws Exception;
	
	void update(UpdateLanguagesRequest updateLanguagesRequest, int id) throws Exception;
	
	void delete(DeleteLanguagesRequest deleteLanguagesRequest, int id);
	
	

}
