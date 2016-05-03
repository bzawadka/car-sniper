package pl.bzawadka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;

	@Override
	public void run(String... strings) throws Exception {
		this.carRepository.deleteAll();
		carRepository.index(Garage.audiA4());
		carRepository.index(Garage.audiA5());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
