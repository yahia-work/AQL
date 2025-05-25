package org.example.TP3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    @Test
    void testGetProduct_Success() throws Exception {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        Product expectedProduct = new Product("p1", "Phone");

        when(apiClientMock.getProduct("p1")).thenReturn(expectedProduct);

        ProductService productService = new ProductService(apiClientMock);

        // Act
        Product product = productService.getProduct("p1");

        // Assert
        assertEquals(expectedProduct, product);
        verify(apiClientMock).getProduct("p1");
    }

    @Test
    void testGetProduct_ApiFailure() throws Exception {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        when(apiClientMock.getProduct("p2")).thenThrow(new RuntimeException("API Error"));

        ProductService productService = new ProductService(apiClientMock);

        // Act + Assert
        assertThrows(RuntimeException.class, () -> {
            productService.getProduct("p2");
        });

        verify(apiClientMock).getProduct("p2");
    }
}
