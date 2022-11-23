package KodlamaIoLanguages.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIoLanguages.demo.DataAccess.abstracts.LanguageRepository;
import KodlamaIoLanguages.demo.business.abstracts.LanguagesService;
import KodlamaIoLanguages.demo.business.requests.CreateLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.DeleteLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.ListedLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.UpdateLanguagesRequest;
import KodlamaIoLanguages.demo.business.responses.GetAllProgrammingLanguagesResponse;
import KodlamaIoLanguages.demo.entities.concretes.Languages;

@Service
public class LanguagesManager implements LanguagesService {
	
	private LanguageRepository programmingLanguageRepository;
	
	@Autowired
	public LanguagesManager(LanguageRepository programmingLanguageRepository) {
		
		this.programmingLanguageRepository = programmingLanguageRepository;
	}


	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		// TODO Auto-generated method stub
		List<Languages> programmingLanguages= programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse=new ArrayList<GetAllProgrammingLanguagesResponse>();
		
	
		
		for(Languages pl: programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			
			responseItem.setId(pl.getId());
			responseItem.setName(pl.getName());
			
			programmingLanguagesResponse.add(responseItem);
		}
		return programmingLanguagesResponse;
	}


	@Override
	public void add(CreateLanguagesRequest createLanguagesRequest) throws Exception {
		// TODO Auto-generated method stub
		Languages languages= new Languages();
		languages.setName(createLanguagesRequest.getName());
		
		if(createLanguagesRequest.getName().isBlank()){
			throw new Exception("Name field can't be blank");
		}
		else if(IsUniqe(createLanguagesRequest.getName())) {
			throw new Exception("This name is already created");
		}
	
	}
	private boolean IsUniqe(String name) {
		// TODO Auto-generated method stub
		List<Languages> languages=programmingLanguageRepository.findAll();
		for(Languages pl: languages) {
			if(pl.getName().equals(languages)) {
				return true;
			}
			
			}
		return false;
		}
		
	


	@Override
	public void update(UpdateLanguagesRequest updateLanguagesRequest, int id) throws Exception {
		// TODO Auto-generated method stub
		Languages languages = programmingLanguageRepository.findById(id).get();
			if(updateLanguagesRequest.getName().isEmpty()|| updateLanguagesRequest.getName().isBlank()) {
				throw new Exception(" It doesn't exist");
			}
			
			else if(IsUniqe(updateLanguagesRequest.getName())) {
				throw new Exception("The language is already exist");
			}
			
			languages.setName(updateLanguagesRequest.getName());
			this.programmingLanguageRepository.save(languages);
		
	}

	@Override
	public void delete(DeleteLanguagesRequest deleteLanguagesRequest, int id) {
		// TODO Auto-generated method stub
		this.programmingLanguageRepository.deleteById(deleteLanguagesRequest.getId());
		
		
	}




	


	
	
	

	

	
	
	

}
