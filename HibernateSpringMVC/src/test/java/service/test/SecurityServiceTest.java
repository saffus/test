package service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.app.config.entity.User;
import com.app.config.enums.EncryptionAlgorithm;
import com.app.config.repo.UserRepo;
import com.app.config.root.security.CustomUserDetailsService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {
	
	@InjectMocks
	private CustomUserDetailsService cu;
	
	@Mock
	UserRepo ur;
	
	@Test
	public void loadUserTest() {
		User u = new User("saffan","admin", EncryptionAlgorithm.BCRYPT );
		
		Mockito.when(ur.getUser("saffan")).thenThrow(UsernameNotFoundException.class);
		
		String us =	cu.loadUserByUsername("saffan").getUsername();
		
		Assertions.assertEquals("saffan",us);
			
		
	}
	
	
	

}
