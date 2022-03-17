package academy.lgs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import academy.lgs.domain.University;
import academy.lgs.repository.UniversityRepository;
import academy.lgs.service.UniversityService;

@SpringBootApplication(scanBasePackages={"academy.lgs.repository", "academy.lgs.service"})
@EnableJpaRepositories(basePackageClasses = UniversityRepository.class)
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService service = ctx.getBean(UniversityService.class);
		
		University university = new University();
		university.setAdress("Lviv");
		university.setLevelAcreditation(4);
		university.setName("LDFA");
		university.setQuantityInstituts(2);
		university.setQuantityStudents(1500);
		
		University university2 = new University();
		university2.setAdress("Lutsk");
		university2.setLevelAcreditation(4);
		university2.setName("LNTU");
		university2.setQuantityInstituts(7);
		university2.setQuantityStudents(5500);
		
		University university3 = new University();
		university3.setAdress("Kyiv");
		university3.setLevelAcreditation(4);
		university3.setName("NAU");
		university3.setQuantityInstituts(4);
		university3.setQuantityStudents(25000);
		
		University university4 = new University();
		university4.setAdress("Lviv");
		university4.setLevelAcreditation(4);
		university4.setName("LNAU");
		university4.setQuantityInstituts(6);
		university4.setQuantityStudents(18000);
		
		University university5 = new University();
		university5.setAdress("Odesa");
		university5.setLevelAcreditation(4);
		university5.setName("ODUVS");
		university5.setQuantityInstituts(7);
		university5.setQuantityStudents(8000);
		
//		service.save(university);
//		service.save(university2);
//		service.save(university3);
//		service.save(university4);
//		service.save(university5);
		 Application.separator();
		System.out.println(service.findById((long)1));
		
		University universityUpp = service.findById((long)1);
		universityUpp.setQuantityStudents(5000);
		service.update(universityUpp);
		System.out.println(service.findById((long)1));
		Application.separator();
		service.findAll().stream().forEach(System.out::println);
		Application.separator();
		service.deleteById((long)4);
		Application.separator();
		service.findAll().stream().forEach(System.out::println);
	}
	
	private static void separator() {
		System.out.println("------------------------------------");
	}

}
