
// RETO 1 SESION 6 ___________________________________________________________

package com.bedu.inventario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContaining(String nombre);

    List<Producto> findByNombreStartingWith(String inicial);

    List<Producto> findByPrecioBetween(double min, double max);

}