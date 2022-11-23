package KodlamaIoLanguages.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import KodlamaIoLanguages.demo.DataAccess.abstracts.TechnologiesRepository;
import KodlamaIoLanguages.demo.business.abstracts.TechnologiesService;
import KodlamaIoLanguages.demo.business.requests.CreateTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.DeleteTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.ListedTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.UpdateTechnologiesRequest;
import KodlamaIoLanguages.demo.business.responses.GetAllLanguagesTechnologiesResponse;
import KodlamaIoLanguages.demo.entities.concretes.Technologies;

public class TechnologiesManager implements TechnologiesService {
	
	
	
	private TechnologiesRepository languagesTechnologiesRepository;
	
	

	public TechnologiesManager(TechnologiesRepository languagesTechnologiesRepository) {
		
		this.languagesTechnologiesRepository = languagesTechnologiesRepository;
	}



	@Override
	public List<GetAllLanguagesTechnologiesResponse> getAll() {
		// TODO Auto-generated method stub
		
		List<Technologies> technologies= languagesTechnologiesRepository.findAll();
		List<GetAllLanguagesTechnologiesResponse> languagesTechnologiesResponse=new ArrayList<GetAllLanguagesTechnologiesResponse>();
		
		for(Technologies lt: technologies) {
			GetAllLanguagesTechnologiesResponse responseItem=new GetAllLanguagesTechnologiesResponse();
			responseItem.setId(lt.getID());
			responseItem.setName(lt.getName());
			languagesTechnologiesResponse.add(responseItem);
		}
		return languagesTechnologiesResponse;
	}



	
	

	@Override
	public void add(CreateTechnologiesRequest createTechnologiesRequest) throws Exception {
		// TODO Auto-generated method stub
		Technologies technologies= new Technologies();
		technologies.setName(createTechnologiesRequest.getName());
		
		if(technologies.getName().isBlank()|| technologies.getName().isEmpty()) {
			throw new Exception(" The name can't be blank or empty");
		}
		
		else if(IsExist(technologies.getName())) {
			throw new  Exception("The technology has  already been added");
		}
		
	}



	private boolean IsExist(String name) {
		// TODO Auto-generated method stub
		List<Technologies> technologies= languagesTechnologiesRepository.findAll();
		
		for(Technologies tch: technologies) {
			if(tch.getName().equals(technologies)) {
				return true;
			}
		}
		return false;
	}



	@Override
	public void update(UpdateTechnologiesRequest updateLanguagesTechnologiesRequest, int id) throws Exception {
		// TODO Auto-generated method stub
		Technologies technology=languagesTechnologiesRepository.findById(id).get();
		
		if(updateLanguagesTechnologiesRequest.getName().isBlank() || updateLanguagesTechnologiesRequest.getName().isEmpty() ) {
			throw new Exception("The name field can't be blank or  empty");
		}
		
		else if(IsExist(updateLanguagesTechnologiesRequest.getName())) {
			throw new Exception("The technology has already been in the list");
		}
		technology.setName(updateLanguagesTechnologiesRequest.getName());
	}



	@Override
	public void delete(DeleteTechnologiesRequest deleteLanguagesTechnologiesRequest) {
		// TODO Auto-generated method stub
		
		
		
	}



	


	
	
}
