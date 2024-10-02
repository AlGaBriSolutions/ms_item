package ms_project.microservicio_items.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_project.microservicio_items.entities.Item;
import ms_project.microservicio_items.repositories.repositorioItem;

@Service
public class ItemService {

    repositorioItem repositorioItem;

    @Autowired
    ItemService(repositorioItem repositorioItem){
        this.repositorioItem = repositorioItem;
    }
    
    public Iterable<Item> getItems(){
        return repositorioItem.findAll();
    }

    public List<Item> getItemsClasificacion(Integer Clasificacion){
        return repositorioItem.findByClasificacion(Clasificacion);
    }

    public List<Item> getItemsSimilar(String titulo){
        System.out.println("\n");
        System.out.println(titulo);
        System.out.println("\n");
        return repositorioItem.findByTituloLike("%" + titulo + "%");
    }

    public Item getItem(Long id){
        Optional<Item> itemOpt = repositorioItem.findById(id);
        if(itemOpt.isPresent()){
            Item item = itemOpt.get();
            return item;
        }
        else{
            return null;
        }
    }

}
