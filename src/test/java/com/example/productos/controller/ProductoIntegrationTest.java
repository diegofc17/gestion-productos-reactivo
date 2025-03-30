package com.example.productos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.productos.GestionProductosReactivoApplication;
import com.example.productos.model.Producto;

@SpringBootTest(classes = GestionProductosReactivoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductoIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetAllProductos() {
        // Crear un producto antes de la consulta
        Producto producto = new Producto();
        producto.setNombre("Producto Test");

        webTestClient.post()
                .uri("/productos")
                .bodyValue(producto)
                .exchange()
                .expectStatus().isOk();

        // Ahora sí hacemos la consulta GET
        webTestClient.get()
                .uri("/productos")
                .exchange()
                .expectStatus().isOk();
    }
}
