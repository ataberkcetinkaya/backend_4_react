package berk.rentacar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import berk.rentacar.entities.concretes.Car;
import berk.rentacar.entities.dtos.CarWithCategoryDto;

public interface CarDao extends JpaRepository<Car, Integer>{
//tablodan hangisini seçeceğine karar verdirtiyoruz. Car içerisinde PK integer.
		
		Car getByCarName(String carName);
		
		Car getByCarNameAndCategory_CategoryId(String carName, int categoryId);
		
		List<Car> getByCarNameOrCategory_CategoryId(String carName, int categoryId);

		List<Car> getByCategoryIn(List<Integer> categories);

		List<Car> getByCarNameContains(String carName);
		
		List<Car> getByCarNameStartsWith(String carName);
		
		@Query("From Car where carName=:carName and category.categoryId=:categoryId")
		List<Car> getByNameAndCategory(String carName, int categoryId);

		@Query("Select new berk.rentacar.entities.dtos.CarWithCategoryDto(p.id, p.carName, c.categoryName) From Category c Inner Join c.cars p")
		List<CarWithCategoryDto> getCarWithCategoryDetails();
		
}
