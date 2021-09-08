package berk.rentacar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cars")
@Data
public class Car {
	
	@Id
	@GeneratedValue
	@Column(name="car_id")
	private int id;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="car_name")
	private String carName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	public Car() {}
	
	public Car(int id, int categoryId, String carName, double unitPrice, short unitsInStock, String quantityPerUnit) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.carName = carName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}
}
