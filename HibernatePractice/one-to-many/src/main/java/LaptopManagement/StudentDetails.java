package LaptopManagement;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StudentDetails {

	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "s")
	private List<Laptop> list;
	
	public StudentDetails() {
		
	}


	public StudentDetails(int id, String name, List<Laptop> list) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Laptop> getList() {
		return list;
	}


	public void setList(List<Laptop> list) {
		this.list = list;
	}
	

}