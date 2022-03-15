package academy.lgs.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import academy.lgs.service.StudentService;
import academy.lgs.service.impl.StudentServiceImpl;

@Configuration
public class CustomConfiguration {

	@Bean
	public StudentService getStudentDaoImpl() {
		return new StudentServiceImpl();
	}
}
