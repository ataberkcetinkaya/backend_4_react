package berk.rentacar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import berk.rentacar.business.abstracts.CarService;
import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.core.utilities.results.Result;
import berk.rentacar.entities.concretes.Car;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarsController {
	
	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getall")
	public DataResult<List<Car>> getAll(){
		return this.carService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Car car) {
		return this.carService.add(car);
	}
	
	@GetMapping("/getByCarName")
	public DataResult<Car> getByCarName(@RequestParam String carName) {
		return this.carService.getByCarName(carName);
	}
}
