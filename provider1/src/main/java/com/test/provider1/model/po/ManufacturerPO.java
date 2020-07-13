package com.test.provider1.model.po;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "manufacturer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ManufacturerPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	private String manufacturerId;
    private String manufacturerName;
    private String manufacturerAddress;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturerId", referencedColumnName = "manufacturerId", insertable = false, updatable = false)
	private List<ProductsPO> products;
    public ManufacturerPO(String manufacturerId, String manufacturerName, String manufacturerAddress,
		List<ProductsPO> products) {
		super();
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.manufacturerAddress = manufacturerAddress;
		this.products = products;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerAddress() {
		return manufacturerAddress;
	}

	@Override
	public String toString() {
		return "ManufacturerPO [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", manufacturerAddress=" + manufacturerAddress + ", products=" + products + "]";
	}

	public void setManufacturerAddress(String manufacturerAddress) {
		this.manufacturerAddress = manufacturerAddress;
	}

	public List<ProductsPO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsPO> products) {
		this.products = products;
	}

	public Object getProductsPO() {

		return null;
	}

	public ManufacturerPO() {
		super();
	}
}