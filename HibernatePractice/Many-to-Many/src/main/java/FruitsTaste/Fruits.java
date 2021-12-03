package FruitsTaste;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Fruits {

	@Id
	private int id;
	private String name;
	
	@ManyToMany
	private List<Taste> t;
	
	public Fruits() {
		
	}

	public Fruits(int id, String name, List<Taste> t) {
		super();
		this.id = id;
		this.name = name;
		this.t = t;
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

	public List<Taste> getT() {
		return t;
	}

	public void setT(List<Taste> t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Fruits [id=" + id + ", name=" + name + ", t=" + t + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruits other = (Fruits) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}
	
	
}
