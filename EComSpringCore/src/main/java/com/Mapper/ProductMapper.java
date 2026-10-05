package com.Mapper;

import com.dto.ProductDTO;
import com.model.Category;
import com.model.Vendor;
import com.service.CategoryService;
import com.service.VendorService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<ProductDTO> {

//    private final VendorService vendorService;
//    private final CategoryService categoryService;
//
//    public ProductMapper(VendorService vendorService, CategoryService categoryService) {
//        this.vendorService = vendorService;
//        this.categoryService = categoryService;
//    }


    @Override
    public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        //getting category and vendor by ID using the respective service classes
        //to map with their names
//        int categoryId = rs.getInt("category_id");
//        Category category = categoryService.getCategoryById(categoryId);
//        int vedorId =  rs.getInt("vendor_id");
//        Vendor vendor = vendorService.getVendorsById(vedorId);

        return new ProductDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("stockQuantity"),
                rs.getString("categoryName"),
                rs.getString("vendorName")
                );
    }
}
