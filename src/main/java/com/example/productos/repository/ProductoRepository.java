package com.example.productos.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.productos.model.Producto;

public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
}
