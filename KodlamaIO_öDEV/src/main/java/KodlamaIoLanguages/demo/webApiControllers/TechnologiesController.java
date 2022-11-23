package KodlamaIoLanguages.demo.webApiControllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIoLanguages.demo.business.abstracts.TechnologiesService;
import KodlamaIoLanguages.demo.business.requests.CreateTechnologiesRequest;
import KodlamaIoLanguages.demo.business.requests.DeleteTechnologiesRequest;
import KodlamaIoLanguages.demo.business.responses.GetAllLanguagesTechnologiesResponse;

@RestController
@RequestMapping("/api/technologiesController")

public class TechnologiesController {
	
	private TechnologiesService technologiesService;

	public TechnologiesController(TechnologiesService technologiesService) {
		
		this.technologiesService = technologiesService;
	}
	
	@GetMapping("/getAll/")
	
	public List<GetAllLanguagesTechnologiesResponse> getAll(){
		return this.technologiesService.getAll();
	}
	
	@PostMapping("/add")
	
	public void add(CreateTechnologiesRequest createTechnologiesRequest) throws Exception {
		
		this.technologiesService.add(createTechnologiesRequest);
		
	}
	
	@DeleteMapping("/delete")
	
	public void delete(DeleteTechnologiesRequest deleteTechnologiesRequest) {
		this.technologiesService.delete(deleteTechnologiesRequest);
	}
	

}
