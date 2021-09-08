package berk.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import berk.rentacar.entities.concretes.Car;

public interface CarDao extends JpaRepository<Car, Integer>{

	//tablodan hangisini seçeceğine karar verdirtiyoruz. Car içerisinde PK integer.
}
