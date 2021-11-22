package co.edu.uis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  
  public  LoadDatabase() {
	// TODO Auto-generated constructor stub
}
  @Bean
  CommandLineRunner initDatabase(BookRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Book("El Principito", "Antoine de Saint-Exupéry", "FR", "Ficción", 180)));
      log.info("Preloading " + repository.save(new Book("Rebelión en la Granja", "George Orwell", "EN", "Sátira Política", 200)));
      log.info("Preloading " + repository.save(new Book("Mil Años de Soledad", "Gabriel García Márquez", "ES", "Realismo Mágico", 500)));
    };
  }
}