package berk.rentacar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import berk.rentacar.business.abstracts.CarService;
import berk.rentacar.entities.concretes.Car;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	
	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getall")
	public List<Car> getAll(){
		return this.carService.getAll();
	}
}
