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
    Iterable<Item> itemsByClasificacion(@Argument Integer clasificacion){
        System.out.println(clasificacion.toString());
        return ItemService.getItemsClasificacion(clasificacion);
    }

    @QueryMapping
    Iterable<Item> itemsByTitulo(@Argument String titulo){
        System.out.println("\n");
        System.out.println(titulo);
        System.out.println("\n");
        return ItemService.getItemsSimilar(titulo);
    }

    @QueryMapping
    Item getItem(@Argument Long id){
        return ItemService.getItem(id);
    }
}
