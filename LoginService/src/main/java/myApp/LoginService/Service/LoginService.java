package myApp.LoginService.Service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	boolean ValidateUser(String name, String passWord);

}
