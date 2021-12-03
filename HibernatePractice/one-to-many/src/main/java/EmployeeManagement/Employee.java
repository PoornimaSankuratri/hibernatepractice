package EmployeeManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	
	@ManyToOne
	private Designation d ;
	
	public Employee() {
		
	}

	public Employee(int id, String name, Designation d) {
		super();
		this.id = id;
		this.name = name;
		this.d = d;
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

	public Designation getD() {
		return d;
	}

	public void setD(Designation d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", d=" + d + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
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
