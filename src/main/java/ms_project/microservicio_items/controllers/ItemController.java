package ms_project.microservicio_items.controllers;

import java.sql.Blob;
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
    
    @MutationMapping
    Item agregarItem(@Argument ItemInput Item){
        Item item = new Item(Item.titulo(), Item.clasificacion(),
        Item.foto(), Item.contenido(),
        Item.valoraciones(), Item.tipo_precio(),
        Item.precio(), Item.preguntas(),
        Item.vendedor(), Item.disponibilidad());
        return ItemService.agregarItem(item);
    }
    record ItemInput(String titulo, Integer clasificacion, Blob foto, String contenido, ArrayList<Valoracion> valoraciones, Integer tipo_precio, Integer precio, ArrayList<Pregunta> preguntas, Integer vendedor, Integer disponibilidad){}

}
