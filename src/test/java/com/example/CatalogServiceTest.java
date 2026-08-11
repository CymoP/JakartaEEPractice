package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CatalogServiceTest {

    @Mock
    private CatalogRepository catalogRepository;

    @InjectMocks
    private CatalogService catalogService;

    @Test
    public void getProduct_returnsProduct() {
        Product product = new Product();
        product.setName("Keyboard");
        product.setPrice(49.99);

        when(catalogRepository.findById(1L))
                .thenReturn(product);

        Product result = catalogService.getProduct(1L);

        assertEquals("Keyboard", result.getName());
        assertEquals(49.99, result.getPrice());
    }

    @Test
    public void getProduct_returnsNullWhenNotFound() {
        when(catalogRepository.findById(999L))
                .thenReturn(null);

        Product result = catalogService.getProduct(999L);

        assertNull(result);
    }

    // @Test
    // public void removeProduct_removesExistingProduct() {
    //     Product product = new Product();

    //     when(catalogRepository.findById(1L))
    //             .thenReturn(product);

    //     catalogService.removeProduct(1L);

    //     verify(catalogRepository).removeById(1L);
    // }

    // @Test
    // public void removeProduct_doesNothingWhenProductDoesNotExist() {
    //     when(catalogRepository.findById(999L))
    //             .thenReturn(null);

    //     catalogService.removeProduct(999L);

    //     verify(catalogRepository, never()).removeById(any());
    // }
}