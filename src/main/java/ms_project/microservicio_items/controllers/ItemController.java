package ms_project.microservicio_items.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import ms_project.microservicio_items.entities.Item;
import ms_project.microservicio_items.services.ItemService;

@Controller
public class ItemController {

    ItemService ItemService;

    @Autowired
    ItemController(ItemService ItemService){
        this.ItemService = ItemService;
    }

    @QueryMapping
    Iterable<Item> items() {
        return ItemService.getItems();
    }
    
    @QueryMapping
    Iterable<Item> itemsByClasificacion(@Argument Integer Clasificacion){
        return ItemService.getItemsClasificacion(Clasificacion);
    }

    @QueryMapping
    Iterable<Item> itemByTitulo(@Argument String Titulo){
        return ItemService.getItemsSimilar(Titulo);
    }

    @QueryMapping
    Item getItem(@Argument Long id){
        return ItemService.getItem(id);
    }
}
