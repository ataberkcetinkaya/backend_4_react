package berk.rentacar.business.abstracts;

import java.util.List;

import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.core.utilities.results.Result;
import berk.rentacar.entities.concretes.Car;

public interface CarService {
	DataResult<List<Car>> getAll();
	Result add(Car car);
	
	DataResult<Car> getByCarName(String carName);
	
	DataResult<Car> getByCarNameAndCategoryId(String carName, int categoryId);
	
	DataResult<List<Car>> getByCarNameOrCategoryId(String carName, int categoryId);

	DataResult<List<Car>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Car>> getByCarNameContains(String carName);
	
	DataResult<List<Car>> getByCarNameStartsWith(String carName);
	
	DataResult<List<Car>> getByNameAndCategory(String carName, int categoryId);
}
