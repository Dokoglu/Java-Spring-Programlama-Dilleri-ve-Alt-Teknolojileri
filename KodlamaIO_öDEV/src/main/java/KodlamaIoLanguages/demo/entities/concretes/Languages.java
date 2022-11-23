package KodlamaIoLanguages.demo.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Table(name="Languages")
@Getter
@Setter
@AllArgsConstructor

@Entity
public class Languages {
	
	public Languages() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	
	@OneToMany (mappedBy="language", cascade = CascadeType.ALL) 
	private List<Technologies> technologies;
}
