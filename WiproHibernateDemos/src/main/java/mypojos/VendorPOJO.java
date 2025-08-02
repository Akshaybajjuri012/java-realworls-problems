package mypojos;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="wipro_hib_vendor")
public class VendorPOJO {
	@Id	
	@Column(name = "vendorno")//primary key
	int vid1;

	@Column(name = "vendorname",length=15)
	String vname1;

	@Column(name = "vendoremail",length=15)
	String vemail;
	@OneToMany(fetch=FetchType.LAZY,targetEntity=CustomerPojo.class,cascade=CascadeType.ALL)
	@JoinColumn(name="vendorfor_id",referencedColumnName="vendorno")//vendorfor_id FOREIGN KEY COLUMN OF CHILD TABLE
	private List<CustomerPojo> customers;

	public List<CustomerPojo> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerPojo> customers) {
		this.customers = customers;
	}

	public int getVid1() {
		return vid1;
	}

	public void setVid1(int vid1) {
		this.vid1 = vid1;
	}

	public String getVname1() {
		return vname1;
	}
	public void setVname1(String vname1) {
		this.vname1 = vname1;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}


}
