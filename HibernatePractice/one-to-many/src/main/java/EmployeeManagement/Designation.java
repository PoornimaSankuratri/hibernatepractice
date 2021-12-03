package EmployeeManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Designation {
	
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "d")
	private List<Employee> list;
	
	public Designation() {
		
	}

	public Designation(int id, String name, List<Employee> e) {
		super();
		this.id = id;
		this.name = name;
		this.list = e;
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

	public List<Employee> getE() {
		return list;
	}

	public void setE(List<Employee> e) {
		this.list = e;
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", name=" + name + ", e=" + list + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Designation other = (Designation) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
