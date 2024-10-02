package ms_project.microservicio_items.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ms_project.microservicio_items.entities.Valoracion;

public interface repositorioValoracion extends JpaRepository<Valoracion, Long>{
    
}
