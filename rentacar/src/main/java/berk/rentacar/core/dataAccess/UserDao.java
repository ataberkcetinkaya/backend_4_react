package berk.rentacar.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import berk.rentacar.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
