package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"service","controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate template() {
		
		// para proporcionar las credenciales de forma basica en Authorization 
		// utilizamos un interceptor
		
		BasicAuthenticationInterceptor intercep = new BasicAuthenticationInterceptor("admin", "admin");
		RestTemplate template = new RestTemplate();
		
		template.getInterceptors().add(intercep);
		
		return template;
	}

}
