// RETO 1 SESION 6 ___________________________________________________________
package com.bedu.inventario;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository repository) {
        return (args) -> {

            repository.save(new Producto("Teclado", "Iluminado", 780.00));
            System.out.println("Guardado :)");
            repository.save(new Producto("Mouse Pad", "Diseño Floral", 3003.00));
            repository.save(new Producto("Mouse ergonomico", "Color Rosa", 700.00));
            repository.save(new Producto("Audifonos Sony", "Tipo diadema e inhalambricos", 1030.00));
            repository.save(new Producto("L663*aptop ASUS Vivobook 14", "14.6 pulgadas", 11300.00));

            System.out.println("***********************************************************************");
            System.out.println("LISTA DE TODOS LOS PRODUCTOS DISPONIBLES");
            repository.findAll().forEach(System.out::println);

            System.out.println("\nProductos que contienen la palabra 'Lap':");
            repository.findByNombreContaining("Lap").forEach(System.out::println);

            System.out.println("\nProductos con precios entre los $400 y $1,000:");
            List<Producto> productosPrecio = repository.findByPrecioBetween(400.0, 1000.0);
            System.out.println("Encontrados: " + productosPrecio.size());
            productosPrecio.forEach(System.out::println);


            System.out.println("\nProductos que comienzan con la leytra 'M' :");
            List<Producto> productosM = repository.findByNombreStartingWith("M");
            System.out.println("Encontrados: " + productosM.size());
            productosM.forEach(System.out::println);

            
        };

    }

}