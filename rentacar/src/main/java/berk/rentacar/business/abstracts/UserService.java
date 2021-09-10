package berk.rentacar.business.abstracts;

import berk.rentacar.core.entities.User;
import berk.rentacar.core.utilities.results.DataResult;
import berk.rentacar.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
