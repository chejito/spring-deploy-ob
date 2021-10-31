package es.sergiomendez.ejercicio1;

import es.sergiomendez.ejercicio1.entities.Laptop;
import es.sergiomendez.ejercicio1.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio1Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// Crear laptop
		Laptop laptop1 = new Laptop(null, "Lenovo", "IdeaPad3", "Windows 10 Home", "Intel Core i3-1115G4", "Intel UHD Graphics", 2020, 8, 256, 14);
		Laptop laptop2 = new Laptop(null, "Acer", "Nitro 5 AN515-55", "No OS", "Intel Core i5-10300H", "Nvidia RTX2060", 2021, 16, 512, 15.6);

		repository.save(laptop1);
		System.out.println(laptop1 + " ha sido creada.");
		repository.save(laptop2);
		System.out.println(laptop2 + " ha sido creada.");

	}

}
