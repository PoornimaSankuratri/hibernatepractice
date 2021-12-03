package FruitsTaste;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Taste {

	@Id
	private int id;
	private String taste;
	
	@ManyToMany(mappedBy = "t")
	private List<Fruits> fruit;
	
	public Taste() {
		
	}

	public Taste(int id, String taste, List<Fruits> fruit) {
		super();
		this.id = id;
		this.taste = taste;
		this.fruit = fruit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public List<Fruits> getFruit() {
		return fruit;
	}

	public void setFruit(List<Fruits> fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "Taste [id=" + id + ", taste=" + taste + ", fruit=" + fruit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taste other = (Taste) obj;
		if (fruit == null) {
			if (other.fruit != null)
				return false;
		} else if (!fruit.equals(other.fruit))
			return false;
		if (id != other.id)
			return false;
		if (taste == null) {
			if (other.taste != null)
				return false;
		} else if (!taste.equals(other.taste))
			return false;
		return true;
	}
	
	
}
