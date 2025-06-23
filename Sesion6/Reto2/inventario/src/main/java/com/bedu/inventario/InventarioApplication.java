package com.bedu.inventario;

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
    public CommandLineRunner demo(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
        return (args) -> {
        
            Marca apple = new Marca("Apple");
            Marca motorola = new Marca("Motorola");
            Marca samsung = new Marca("Samsung");

            marcaRepo.save(apple);
            marcaRepo.save(samsung);
            marcaRepo.save(motorola);

            productoRepo.save(new Producto("Apple Watch", "Modelo S", 90000.00, apple));
            productoRepo.save(new Producto("Moto G20", "Incluye Chip Telcel", 6000.00, motorola));
            productoRepo.save(new Producto("Samsung Galaxy A24", "Version Black", 12000.00, samsung));
            
            System.out.println("*********************************************************");
            System.out.println("LISTA DE PRODUCTOS POR MARCA ");
            marcaRepo.findAll().forEach(marca -> {
            System.out.println( marca.getNombre() + ":");
            productoRepo.findAll().stream()
                .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
                .forEach(p -> System.out.println(" - " + p.getNombre()));
            });


        };
    }
}
