package myApp.LoginService.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import myApp.LoginService.Util.LoginInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
@Autowired
LoginInterceptor li;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(li).addPathPatterns("/Login");
	}

}
