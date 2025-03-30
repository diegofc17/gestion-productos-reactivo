package com.example.productos.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

