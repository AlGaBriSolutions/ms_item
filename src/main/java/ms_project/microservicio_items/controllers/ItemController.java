package ms_project.microservicio_items.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import ms_project.microservicio_items.entities.Item;
import ms_project.microservicio_items.entities.Pregunta;
import ms_project.microservicio_items.entities.Valoracion;
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
    Iterable<Item> itemsByClasificacion(@Argument int clasificacion){
        return ItemService.getItemsClasificacion(clasificacion);
    }

    @QueryMapping
    Iterable<Item> itemsByTitulo(@Argument String titulo){
        return ItemService.getItemsSimilar(titulo);
    }

    @QueryMapping
    Item item(@Argument Long id){
        return ItemService.getItem(id);
    }
    
    @MutationMapping
    Item agregarItem(@Argument ItemInput Item){
        Item item = new Item(Item.titulo(), Item.clasificacion(), Item.foto(), Item.contenido(),
                      Item.valoraciones(), Item.tipoPrecio(), Item.precio(), Item.preguntas(),
                      Item.vendedor(), Item.disponibilidad());
        return ItemService.agregarItem(item);
    }
    record ItemInput(String titulo, Integer clasificacion, String foto, String contenido, ArrayList<Valoracion> valoraciones, Integer tipoPrecio, Integer precio, ArrayList<Pregunta> preguntas, Integer vendedor, Integer disponibilidad){}

}
