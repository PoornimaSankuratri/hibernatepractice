package StudentManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Branch {

	@Id
	private int branchid;
	private String branchname;

	@OneToOne(mappedBy = "b")
	private StudentDetails s;
	
	public Branch() {
		
	}

	public Branch(int branchid, String branchname, StudentDetails s) {
		this.branchid = branchid;
		this.branchname = branchname;
		this.s = s;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public StudentDetails getS() {
		return s;
	}

	public void setS(StudentDetails s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Branch [branchid=" + branchid + ", branchname=" + branchname + ", s=" + s + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (branchid != other.branchid)
			return false;
		if (branchname == null) {
			if (other.branchname != null)
				return false;
		} else if (!branchname.equals(other.branchname))
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
}
