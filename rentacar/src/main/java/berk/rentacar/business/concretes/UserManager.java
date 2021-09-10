package berk.rentacar.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import berk.rentacar.business.abstracts.UserService;
import berk.rentacar.core.dataAccess.UserDao;
import berk.rentacar.core.entities.User;
import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.core.utilities.results.Result;
import berk.rentacar.core.utilities.results.SuccessDataResult;
import berk.rentacar.core.utilities.results.SuccessResult;

public class UserManager implements UserService {

	private UserDao userDao; //sağ-click > source > generate constructor using fields
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added.");
	}	
		
	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"User found.");
	}

}
