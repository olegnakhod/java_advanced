package academy.lgs.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import academy.lgs.conf.CustomConfiguration;
import academy.lgs.domain.Student;
import academy.lgs.service.StudentService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(CustomConfiguration.class);
		
		StudentService sts = context.getBean(StudentService.class);

		sts.create(new Student(1,"Paulo",19));
		sts.create(new Student(2,"Maria", 21));
		System.out.println(sts.read(1));
		System.out.println(sts.readAll());
		sts.update(2);
		System.out.println(sts.read(2));
		sts.delete(2);
		System.out.println(sts.readAll());
	}

}
