package KodlamaIoLanguages.demo.webApiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIoLanguages.demo.business.abstracts.LanguagesService;
import KodlamaIoLanguages.demo.business.requests.CreateLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.DeleteLanguagesRequest;
import KodlamaIoLanguages.demo.business.requests.UpdateLanguagesRequest;
import KodlamaIoLanguages.demo.business.responses.GetAllProgrammingLanguagesResponse;
import KodlamaIoLanguages.demo.entities.concretes.Languages;


@RestController
@RequestMapping(" /api/programmingLanguages")

public class ProgrammingLanguagesController {
	
	private LanguagesService programmingLanguagesService;
	
	@Autowired
	public ProgrammingLanguagesController(LanguagesService programmingLanguagesService) {
		
		this.programmingLanguagesService = programmingLanguagesService;
	}
	
	@GetMapping("/getAll")
	
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		
		return programmingLanguagesService.getAll();
		
	}
	
	@PostMapping("/add")
	public void add(CreateLanguagesRequest createProgrammingLanguagesRequest) throws Exception {
		this.programmingLanguagesService.add(createProgrammingLanguagesRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguagesRequest deleteLanguagesRequest) {
		this.programmingLanguagesService.delete(deleteLanguagesRequest, deleteLanguagesRequest.getId());
	}
	
	@PutMapping("/update{id}")
	public void update(@PathVariable("id") int id, @RequestBody UpdateLanguagesRequest updateLanguagesRequest) throws Exception {
		
		this.programmingLanguagesService.update(updateLanguagesRequest,id);
		
	}
	
	

}
