package mypojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wipro_hib_customers")
public class CustomerPojo {
	@Id
	@Column(name = "customerid")
	int custid;

	@Column(name = "customername",length=15)
	String custname;

	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

}
