package ms_project.microservicio_items;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import jakarta.transaction.Transactional;
import ms_project.microservicio_items.entities.Item;
import ms_project.microservicio_items.entities.Pregunta;
import ms_project.microservicio_items.entities.Valoracion;
import ms_project.microservicio_items.repositories.repositorioItem;
import ms_project.microservicio_items.repositories.repositorioPregunta;
import ms_project.microservicio_items.repositories.repositorioValoracion;


@Controller
@Transactional
@Profile("default")
public class DatabaseInit implements ApplicationRunner{
    @Autowired
    repositorioItem repoItem;

    @Autowired
    repositorioPregunta repoPregunta;

    @Autowired
    repositorioValoracion repoValoracion;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] nombres = {
            "Sendero Ecológico", "Excursión a la Montaña", "Caminata por la Selva", 
            "Safari Fotográfico", "Observación de Aves", "Tour en Bicicleta", 
            "Río y Cañonismo", "Avistamiento de Ballenas", "Espeleología", "Camping Ecológico"
        };

        String[] fotos = {
            "https://ejemplo.com/foto1.jpg", "https://ejemplo.com/foto2.jpg", 
            "https://ejemplo.com/foto3.jpg", "https://ejemplo.com/foto4.jpg", 
            "https://ejemplo.com/foto5.jpg", "https://ejemplo.com/foto6.jpg", 
            "https://ejemplo.com/foto7.jpg", "https://ejemplo.com/foto8.jpg", 
            "https://ejemplo.com/foto9.jpg", "https://ejemplo.com/foto10.jpg"
        };

        String[] contenidos = {
            "Un sendero tranquilo rodeado de naturaleza exuberante.",
            "Escala montañas y descubre vistas impresionantes.",
            "Sumérgete en la selva virgen y conoce su biodiversidad.",
            "Captura la belleza de la fauna en su hábitat natural.",
            "Disfruta observando aves exóticas y sus hábitats.",
            "Recorre los paisajes más bellos en bicicleta.",
            "Desafía los rápidos y cascadas en esta aventura.",
            "Vive la experiencia única de ver ballenas en su hábitat.",
            "Explora cuevas misteriosas en un entorno natural.",
            "Disfruta de una noche bajo las estrellas en un camping ecológico."
        };

        // Tipos de precio: 0 - Dólares, 1 - Pesos Colombianos, 2 - Bolívares
        Integer[] tiposPrecio = {0, 1, 2};

        // Random para generar valores aleatorios
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            // Seleccionar nombre, foto, contenido y tipo de precio aleatoriamente
            String nombre = nombres[i];
            String foto = fotos[i];
            String contenido = contenidos[i];
            Integer tipoPrecio = tiposPrecio[random.nextInt(tiposPrecio.length)];

            // Generar precio según el tipo de moneda
            Integer precio;
            precio = switch (tipoPrecio) {
                case 0 -> 50 + random.nextInt(150);
                case 1 -> 50000 + random.nextInt(200000);
                case 2 -> 1000000 + random.nextInt(4000000);
                default -> 1000;
            }; // Dólares
            // Precio entre 50 y 200 USD
            // Pesos Colombianos
            // Precio entre 50,000 y 250,000 COP
            // Bolívares
            // Precio entre 1,000,000 y 5,000,000 VES
            // Valor por defecto en caso de error

            // Generar vendedor aleatorio (número entre 0 y 14)
            Integer vendedor = random.nextInt(15);

            // Crear nuevo item
            Item nuevoItem = new Item(
                nombre,                      // Título del servicio
                i + 1,       // Clasificación aleatoria entre 1 y 6
                foto,                        // URL de la foto
                contenido,                   // Descripción del servicio
                tipoPrecio,                  // Tipo de precio
                precio,                      // Precio según el tipo
                vendedor,                    // Vendedor aleatorio
                true                         // Disponibilidad (asumimos que siempre está disponible)
            );

            // Guardar el nuevo item en la base de datos
            repoItem.save(nuevoItem);
        }

        // Crear preguntas y valoraciones aleatorias

        String[] preguntas = {
            "¿Cuál es la mejor temporada para recorrer el Sendero Ecológico?",
            "¿La Excursión a la Montaña es apta para principiantes?",
            "¿Es seguro realizar la Caminata por la Selva sin un guía?",
            "¿Qué equipo es necesario para el Safari Fotográfico?",
            "¿Cuáles son las mejores horas para la Observación de Aves?"
        };

        String[] respuestas = {
            "La mejor temporada para recorrer el Sendero Ecológico es entre abril y septiembre, cuando el clima es más seco.",
            "Sí, la Excursión a la Montaña tiene rutas para principiantes, aunque se recomienda tener una buena condición física.",
            "No es recomendable realizar la Caminata por la Selva sin un guía, ya que hay áreas densas y fauna salvaje.",
            "Para el Safari Fotográfico se recomienda llevar una cámara con zoom, binoculares, y ropa cómoda de colores neutros.",
            "Las mejores horas para la Observación de Aves son temprano en la mañana, entre las 5:00 y 9:00 am, cuando las aves son más activas."
        };

        for (int i = 0; i < 5; i++) {
            Pregunta pregunta =  new Pregunta(i + 15, preguntas[i], respuestas[i]);
            pregunta.setItem(repoItem.findById(i + 1L).get());
            
            repoPregunta.save(pregunta);
        }

        repoValoracion.save(new Valoracion(5, 16, "Muy chevere", repoItem.findById(1L).get()));

    }
}