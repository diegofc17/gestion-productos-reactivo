import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import com.example.productos.service.ProductoService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


public class ProductoServiceTest {
    
    private final ProductoRepository productoRepository = Mockito.mock(ProductoRepository.class);
    private final ProductoService productoService = new ProductoService(productoRepository);
    
    @Test
    void testCreateProducto() {
        Producto producto = new Producto();
        producto.setNombre("Producto Test");
        
        // Configuramos el mock para que acepte cualquier objeto Producto
        Mockito.when(productoRepository.save(any(Producto.class)))
               .thenReturn(Mono.just(producto));
        
        // Usamos StepVerifier para pruebas reactivas
        StepVerifier.create(productoService.createProducto(producto))
                    .expectNextMatches(p -> p.getNombre().equals("Producto Test"))
                    .verifyComplete();
    }
}
