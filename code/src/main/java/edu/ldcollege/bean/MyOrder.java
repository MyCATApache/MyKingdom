package edu.ldcollege.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MyOrder {

	public interface ForUnpdate {
	};

	public interface ForGrounding {
	};

	private Integer id;
	@Size(min = 3, max = 6, message = "{myorder.name.invalid} ")
	private String name;
	@Min(9)
	@Max(99)
	private int price;

	@NotNull(groups = { ForGrounding.class })
	private Integer shopId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "MyOrder [id=" + id + ", name=" + name + ", price=" + price + ", shopId=" + shopId + "]";
	}

	 
}
