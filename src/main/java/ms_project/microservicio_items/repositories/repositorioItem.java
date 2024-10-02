package ms_project.microservicio_items.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ms_project.microservicio_items.entities.Item;

public interface repositorioItem extends JpaRepository<Item, Long>{
    List<Item> findByClasificacion(Integer Clasificacion);

    @Query("SELECT i FROM Item i WHERE i.titulo LIKE %:pattern%")
    List<Item> findByTituloLike(@Param("pattern") String pattern);
}
