package com.example.productos.service;

import org.springframework.stereotype.Service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;   
    }

    public Flux<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Mono<Producto> createProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
