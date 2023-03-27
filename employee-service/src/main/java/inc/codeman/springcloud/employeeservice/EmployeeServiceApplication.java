package inc.codeman.springcloud.employeeservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Employee Microservice Documentation",description = "Spring Boot REST API Documentation for Employee Spring Boot Microservice",version = "v1.0",contact = @Contact(name="Codeman",email="codemanrkg@gmail.com",url="https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173/")))
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
//
	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}

//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
