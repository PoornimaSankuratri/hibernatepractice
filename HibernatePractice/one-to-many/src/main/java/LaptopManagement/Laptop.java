package LaptopManagement;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Laptop {

	@Id
	private int id;
	private String name;
	
	@ManyToOne
	private StudentDetails s;
	
	public Laptop() {
		
	}


	public Laptop(int id, String name, StudentDetails s) {
		this.id = id;
		this.name = name;
		this.s = s;
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


	public StudentDetails getS() {
		return s;
	}


	public void setS(StudentDetails s) {
		this.s = s;
	}


	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", s=" + s + "]";
	}

	
}
