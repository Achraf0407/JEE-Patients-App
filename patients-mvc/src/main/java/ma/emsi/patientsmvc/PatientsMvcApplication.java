package ma.emsi.patientsmvc;
 import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null, "Hassan", new Date(), false,130));
			patientRepository.save(new Patient(null, "Karim", new Date(), true,102));
			patientRepository.save(new Patient(null, "achraf", new Date(), false,183));
			patientRepository.save(new Patient(null, "siham", new Date(), true,215));
		
			patientRepository.findAll().forEach(p ->{
				System.out.println(p.getNom());
			});
		};
	}
}

