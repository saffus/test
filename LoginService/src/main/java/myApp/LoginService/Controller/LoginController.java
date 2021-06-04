package myApp.LoginService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myApp.LoginService.ServiceImpl.LoginServiceImpl;
import myApp.LoginService.Transfer.LoginResponse;

@RestController
public class LoginController {

	@Autowired
	LoginServiceImpl ls;
	@Autowired
	LoginResponse resp;
	
	private int i =14;

	@RequestMapping(name = "/Login", method = RequestMethod.GET)
	public ResponseEntity<LoginResponse> LoginValidation(@RequestParam("uname") String name,
			@RequestParam("pwd") String pwd) {
		resp.setMessage("ValidUser");

		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "1");

		return new ResponseEntity<>(resp, headers, HttpStatus.OK);

	}

	/**
	 * @return
	 */
	@RequestMapping("/errorLogin")
	public ResponseEntity<LoginResponse> ErrorLogin() {
		System.out.println("insidervice");

		resp.setErrorMessage("Invalid user: Login Failed");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("status", "2");

		return new ResponseEntity<>(resp,headers, HttpStatus.OK);

	}

}
