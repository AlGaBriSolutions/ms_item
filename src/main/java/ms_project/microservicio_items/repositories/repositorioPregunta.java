package ms_project.microservicio_items.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ms_project.microservicio_items.entities.Pregunta;

public interface  repositorioPregunta extends JpaRepository<Pregunta, Long>{
    
}
