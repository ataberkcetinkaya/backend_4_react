package berk.rentacar.business.abstracts;

import java.util.List;

import berk.rentacar.entities.concretes.Car;

public interface CarService {
	List<Car> getAll();
}
