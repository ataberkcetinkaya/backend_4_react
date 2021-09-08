package berk.rentacar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import berk.rentacar.business.abstracts.CarService;
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
	public List<Car> getAll() {
		
		return this.carDao.findAll();
	}

}
