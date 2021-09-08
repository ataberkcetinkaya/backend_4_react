package berk.rentacar.business.abstracts;

import java.util.List;

import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.entities.concretes.Car;

public interface CarService {
	DataResult<List<Car>> getAll();
}
