package ms_project.microservicio_items.entities;

import java.sql.Blob;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    public Item(String titulo2, Integer clasificacion2, Blob foto2, String contenido2,
            ArrayList<Valoracion> valoraciones2, Integer tipo_precio2, Integer precio2, ArrayList<Pregunta> preguntas2,
            Integer vendedor2, Integer disponibilidad2) {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String titulo;
    private Integer clasificacion;
    private Blob foto;
    private String contenido;
    private ArrayList<Valoracion> valoraciones;
    private Integer tipo_precio;
    private Integer precio;
    private ArrayList<Pregunta> preguntas;
    private Integer vendedor;
    private Integer disponibilidad;
}
