package com.example.productos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos.model.Producto;
import com.example.productos.service.ProductoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public Flux<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @PostMapping
    public Mono<Producto> createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }
}
