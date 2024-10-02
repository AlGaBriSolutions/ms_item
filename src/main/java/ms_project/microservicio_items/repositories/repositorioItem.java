package ms_project.microservicio_items.repositories;

import org.springframework.data.repository.CrudRepository;

import ms_project.microservicio_items.entities.Item;

public interface repositorioItem extends CrudRepository<Item, Long>{
    Iterable<Item> findByClasificacion(Integer Clasificacion);
    Iterable<Item> findByTituloLike(String titulo);
}
