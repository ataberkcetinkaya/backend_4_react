package berk.rentacar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import berk.rentacar.business.abstracts.CarService;
import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.core.utilities.results.Result;
import berk.rentacar.core.utilities.results.SuccessDataResult;
import berk.rentacar.core.utilities.results.SuccessResult;
import berk.rentacar.dataAccess.abstracts.CarDao;
import berk.rentacar.entities.concretes.Car;

@Service
public class CarManager implements CarService {
	
	private CarDao carDao;

	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public DataResult<List<Car>> getAll() {
		
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(), "Data Listed.");			
	}

	@Override
	public Result add(Car car) {
		this.carDao.save(car);
		return new SuccessResult("Car added.");
	}

	@Override
	public DataResult<Car> getByCarName(String carName) {
		return new SuccessDataResult<Car>
		(this.carDao.getByCarName(carName), "Data Listed.");
	}

	@Override
	public DataResult<Car> getByCarNameAndCategoryId(String carName, int categoryId) {
		return new SuccessDataResult<Car>
		(this.carDao.getByCarNameAndCategory_CategoryId(carName, categoryId), "Data Listed.");
	}

	@Override
	public DataResult<List<Car>> getByCarNameOrCategoryId(String carName, int categoryId) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByCarNameOrCategory_CategoryId(carName, categoryId), "Data Listed.");	
	}

	@Override
	public DataResult<List<Car>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByCategoryIn(categories), "Data Listed.");
	}

	@Override
	public DataResult<List<Car>> getByCarNameContains(String carName) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByCarNameContains(carName), "Data Listed.");
	}

	@Override
	public DataResult<List<Car>> getByCarNameStartsWith(String carName) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByCarNameStartsWith(carName), "Data Listed.");
	}

	@Override
	public DataResult<List<Car>> getByNameAndCategory(String carName, int categoryId) {
		return new SuccessDataResult<List<Car>>
		(this.carDao.getByNameAndCategory(carName, categoryId), "Data Listed.");
	}

	@Override
	public DataResult<List<Car>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Car>>(this.carDao.findAll(pageable).getContent());
	}
}
