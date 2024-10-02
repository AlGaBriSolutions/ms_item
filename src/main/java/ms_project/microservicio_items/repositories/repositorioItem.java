package ms_project.microservicio_items.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ms_project.microservicio_items.entities.Item;

public interface repositorioItem extends JpaRepository<Item, Long>{
    Iterable<Item> findByClasificacion(Integer Clasificacion);
    Iterable<Item> findByTituloLike(String titulo);
}
