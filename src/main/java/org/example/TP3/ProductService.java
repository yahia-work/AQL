package org.example.TP3;

public class ProductService {
    private ProductApiClient apiClient;

    public ProductService(ProductApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Product getProduct(String productId) throws Exception {
        return apiClient.getProduct(productId);
    }
}

