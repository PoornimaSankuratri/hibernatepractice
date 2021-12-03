package StudentManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StudentDetails {

	@Id
	private int rollno;
	private String name;

	@OneToOne
	private Branch b;
	
	public StudentDetails() {
		
	}

	public StudentDetails(int rollno, String name, Branch b) {
		this.rollno = rollno;
		this.name = name;
		this.b = b;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Branch getB() {
		return b;
	}

	public void setB(Branch b) {
		this.b = b;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDetails other = (StudentDetails) obj;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollno != other.rollno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", b=" + b + "]";
	}

}
