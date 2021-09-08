package berk.rentacar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import berk.rentacar.business.abstracts.CarService;
import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.core.utilities.results.SuccessDataResult;
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
}
