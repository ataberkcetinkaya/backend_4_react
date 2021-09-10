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
import berk.rentacar.entities.dtos.CarWithCategoryDto;

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
	
	@GetMapping("/getCarWithCategoryDetails")
	public DataResult<List<CarWithCategoryDto>> getCarWithCategoryDetails(){
		return this.carService.getCarWithCategoryDetails();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Car car) {
		return this.carService.add(car);
	}
	
	@GetMapping("/getByCarName")
	public DataResult<Car> getByCarName(@RequestParam String carName) {
		return this.carService.getByCarName(carName);
	}
	
	@GetMapping("/getByCarNameAndCategoryId")
	public DataResult<Car> 
	getByCarNameAndCategoryId(@RequestParam ("carName") String carName, @RequestParam ("categoryId") int categoryId) {
		return this.carService.getByCarNameAndCategoryId(carName, categoryId);
	}
	
	@GetMapping("/getByCarNameContains")
	public DataResult<List<Car>> getByCarNameContains(@RequestParam String carName) {
		return this.carService.getByCarNameContains(carName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Car>> getAll(int pageNo, int pageSize) {
		return this.carService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Car>> getAllSorted() {
		return this.carService.getAllSorted();
	}
}
