package com.dto;

public record ProductDTO(
        int id,
        String name,
        double price,
        int stockQuantity,
        String categoryName,
        String vendorName

) {
}
