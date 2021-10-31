package es.sergiomendez.ejercicio1.controllers;

import es.sergiomendez.ejercicio1.entities.Laptop;
import es.sergiomendez.ejercicio1.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // atributos
    private LaptopRepository laptopRepository;

    // constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /**
     * Método que devuelve todas las laptop de la base de datos.
     *
     * Endpoint: http://localhost:8080/api/laptops
     *
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        log.info("Devolviendo lista de laptops");
        return laptopRepository.findAll();
    }

    /**
     * Método que devuelve una sola laptop de la base de datos si existe
     *
     * Endpoint: http://localhost:8080/api/laptops/{id}
     * Endpoint: http://localhost:8080/api/laptops/1
     *
     * @param id
     * @return
     */
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        // Si existe una laptop con ese id en la base de datos, la devolvemos
        if (laptopOpt.isPresent()) {
            log.info("Devolviendo laptop");
            return ResponseEntity.ok(laptopOpt.get());
        }

        return ResponseEntity.notFound().build();

    }

    /**
     * Método que crea una laptop recibida en formato JSON en la base de datos
     *
     * Endpoint: http://localhost:8080/api/laptops
     *
     * @param laptop
     * @return
     */
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {

        // Comprobamos que no exista ya en la base de datos una laptop con ese id
        if (laptop.getId() != null) {
            log.warn("Intentando crear una laptop con id");
            return ResponseEntity.badRequest().build();
        }

        // Creamos la laptop
        Laptop result = laptopRepository.save(laptop);
        log.info("Creando nueva laptop");
        return ResponseEntity.ok(result);
    }

    /**
     * Método que actualiza una laptop recibida como json en la base de datos.
     *
     * Endpoint: http://localhost:8080/api/laptops
     * @param laptop
     * @return
     */
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        // Comprobamos que tiene id, si no, sería una creación
        if (laptop.getId() == null) {
            log.warn("Intentando actualizar una laptop inexistente");
            return ResponseEntity.badRequest().build();
        }

        // Comprobamos que el id está en la base de datos
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Intentando actualizar una laptop inexistente");
            return ResponseEntity.notFound().build();
        }

        // Actualizamos con los nuevos datos
        Laptop result = laptopRepository.save(laptop);
        log.info("Actualizando laptop");
        return ResponseEntity.ok(result);
    }

    /**
     * Método que elimina una laptop de la base de datos
     *
     * Endpoint: http://localhost:8080/api/laptops/{id}
     * Endpoint: http://localhost:8080/api/laptops/1
     *
     * @param id
     * @return
     */
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {

        // Comprobamos que existe en la base de datos
        if (!laptopRepository.existsById(id)) {
            log.warn("Intentando eliminar una laptop inexistente");
            return ResponseEntity.notFound().build();
        }

        // La eliminamos
        laptopRepository.deleteById(id);
        log.info("Eliminando laptop");

        return ResponseEntity.notFound().build();
    }

    /**
     * Método que elimina todas las laptops de la base de datos
     *
     * Endpoint: http://localhost:8080/api/laptops
     *
     * @return
     */
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("Petición REST para eliminar todas las laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
